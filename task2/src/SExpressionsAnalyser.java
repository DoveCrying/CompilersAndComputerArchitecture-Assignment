import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.*;

public class SExpressionsAnalyser extends SExpressionsBaseVisitor<Types>
{
    private final Map<String, SExpressionsParser.DecContext> global_funcs = new HashMap<>();
    private final Map<String, Types> local_vars = new HashMap<>();
    private SExpressionsParser.DecContext current_dec = null;
    private final SExpressionsToString toStrConverter = new SExpressionsToString();

    public String visitAndPrint(SExpressionsParser.ProgContext prog)
    {

        visit(prog);    // Discards the dummy return value.

        // At this point, we know for sure that there is at least a 'main' function.

        int index_main = 0;
        for (int i = 0; i < prog.decs.size(); ++i) {
            SExpressionsParser.DecContext dec = prog.decs.get(i);
            if (dec.identifier().Idfr().getText().equals("main")) {
                index_main = i;
            }
        }

        SExpressionsParser.DecContext main = prog.decs.get(index_main);
        prog.decs.set(index_main, prog.decs.get(0));
        prog.decs.set(0, main);

        return toStrConverter.visitHighlight(prog, prog).replaceAll("\u001B\\[[;\\d]*m", "");   // Removes ANSI colours.

    }

    @Override public Types visitProg(SExpressionsParser.ProgContext ctx)
    {
        boolean found_main = false;

        for (int i = 0; i < ctx.decs.size(); ++i)
        {
            SExpressionsParser.DecContext dec = ctx.decs.get(i);
            SExpressionsParser.IdentifierContext id = dec.identifier();
            SExpressionsParser.TypeContext type = dec.type();
            if (id.Idfr().getText().equals("main"))
            {
                //sets found_main as true (meaning a function is named main)
                found_main = true;

                //Checks whether the Types of "Main" is Int, if not
                //Main Function Error
                if (Types.toType(type) != Types.INT)
                {
                    throw new TypeException().mainFuncError(ctx,dec,Types.toType(type));
                }
            }
        }

        //If statement that checks whether found_main is true or false
        //If false, noMainFuncError
        if (!found_main)
        {
            throw new TypeException().noMainFuncError();
        }

        //for loop used to loop through all the decs adn storing them in global_funcs
        for (int i = 0; i < ctx.decs.size(); i++)
        {
            //Checks whether global funcs contains ctx.decs.get(i).identifier(), if it does
            //Duplicate Function Error
            if (global_funcs.containsKey(ctx.decs.get(i).identifier().Idfr().getText()))
            {
                throw new TypeException().duplicatedFuncError(ctx,ctx.decs.get(i).identifier(), Types.toType(ctx.decs.get(i).type()));
            }
            //Adds ctx.decs.get(i).identifier() to global funcs
            global_funcs.put(ctx.decs.get(i).identifier().Idfr().getText(),ctx.decs.get(i));
        }

        //for loop used to loop through all the decs and visit them
        for (int i = 0; i < ctx.decs.size(); i++)
        {
            //Sets current_dec to ctx.decs.get(i)
            current_dec = ctx.decs.get(i);
            visit(ctx.decs.get(i));
        }

        return Types.UNKNOWN;   // This is just a dummy return value.
    }

    @Override public Types visitDec(SExpressionsParser.DecContext ctx)
    {
        //Clears hashmap local_vars, since this is the start of the declaration of a new function
        local_vars.clear();

        //Checks whether the identifier of ctx is "main" or not
        if (ctx.identifier().Idfr().getText().equals("main"))
        {
            //Checks whether the parameter size of "main" is 0, if not
            //Main Function Error
            if (ctx.params.size() != 0)
            {
                throw new TypeException().mainFuncError(ctx,ctx.params.get(0),Types.toType(ctx.params.get(0).type()));
            }
        }

        //Loops through the parameters of ctx
        for ( int i = 0; i < ctx.params.size(); i++)
        {
            //Checks if the local vars contains a key of the same value as another, if it does
            //Duplicate Variable Error
            if (local_vars.containsKey(ctx.typed_idfr(i).identifier().getText()))
            {
                throw new TypeException().duplicatedVarError(ctx,ctx.typed_idfr(i).identifier(),Types.toType(ctx.typed_idfr(i).type()));
            }
            //Checks whether the Types of ctx.params.get(i).type() is equals to Types Unit, if it is
            //Unit Variable Error
            if (Types.toType(ctx.params.get(i).type()) == Types.UNIT)
            {
                throw new TypeException().unitVarError(ctx,ctx.typed_idfr(i).identifier(),Types.UNIT);
            }
            //Puts the ctx.typed_idfr(i).identifier().getText(),Types.toType(ctx.typed_idfr(i).type()) in local vars
            local_vars.put(ctx.typed_idfr(i).identifier().getText(),Types.toType(ctx.typed_idfr(i).type()));
        }

        //Checks if the return type is correct, if not
        //Function Body Error
        if (visit(ctx.block()) != Types.toType(current_dec.type()))
        {
            throw new TypeException().functionBodyError(ctx,ctx.block().expr,visit(ctx.block()));
        }

        return visit(ctx.block());
    }

    @Override public Types visitBlock(SExpressionsParser.BlockContext ctx)
    {
        //Looping through the expressions of ctx
        for (int i = 0; i < ctx.exprs.size(); i++)
        {
            ctx.t = visit(ctx.exprs.get(i));
        }

        //Returns the Types of the last expression of ctx
        return ctx.t;
    }

    @Override public Types visitIfExpr(SExpressionsParser.IfExprContext ctx)
    {
        // Setting up expressionOne t
        SExpressionsParser.ExprContext expressionOne = ctx.expr();
        expressionOne.t = visit(expressionOne);

        // Setting up block (0)
        SExpressionsParser.BlockContext blockOne = ctx.block(0);
        blockOne.t = visit(blockOne);

        // Setting up block (1)
        SExpressionsParser.BlockContext blockTwo = ctx.block(1);
        blockTwo.t = visit(blockTwo);

        //Checking to see if expressionOne is of Types Bool, if not
        //Condition Error
        if (expressionOne.t != Types.BOOL)
        {
            throw new TypeException().conditionError(ctx,expressionOne,expressionOne.t);
        }

        //Checking if the types of blockOne.t and blockTwo.t match, if not
        //Branch Mismatch Error
        if (blockOne.t != blockTwo.t)
        {
            throw new TypeException().branchMismatchError(ctx,blockOne.expr,blockOne.t,blockTwo.expr,blockTwo.t);
        }
        return blockOne.t;
    }

    @Override public Types visitBinExpr(SExpressionsParser.BinExprContext ctx)
    {
        Types t = null;

        //Setting up ArrayList for Comparison Algorithms (==, <, <=, >, >=)
        ArrayList<Integer> compAlg = new ArrayList<>();
        for (int i = 19; i <= 23; i++) compAlg.add(i);

        //Setting up ArrayList for Arithmetic Algorithms (+, -, *, /)
        ArrayList<Integer> aritAlg = new ArrayList<>();
        for (int i = 24; i <= 27; i++) aritAlg.add(i);

        //Setting up ArrayList for Boolean Algorithms (AND, OR, XOR)
        ArrayList<Integer> boolAlg = new ArrayList<>();
        for (int i = 28; i <= 30; i++) boolAlg.add(i);

        //Setting up expr(0) t
        SExpressionsParser.ExprContext operand1 = ctx.expr(0);
        operand1.t = visit(operand1);

        //Setting up expr(1) t
        SExpressionsParser.ExprContext operand2 = ctx.expr(1);
        operand2.t = visit(operand2);

        //Saving the type of operator in the current BinExpr (saved as an int)
        int operator = (((TerminalNode) (ctx.binop().getChild(0))).getSymbol().getType());

        //Checking if operator is part of compAlg
        if (compAlg.contains(operator))
        {
            //Checking if operand1.t and operand2.t are Int types, if not
            //Comparison Error
            if (operand1.t != Types.INT || operand2.t != Types.INT)
            {
                throw new TypeException().comparisonError(ctx, operand1, operand1.t,
                        operand2, operand2.t);
            }
            else t = Types.BOOL;
        }

        //Checking if operator is part of aritAlg
        else if (aritAlg.contains(operator))
        {
            //Checking if operand1.t and operand2.t are Int types, if not
            //Arithmetic Error
            if (operand1.t != Types.INT || operand2.t != Types.INT)
            {
                throw new TypeException().arithmeticError(ctx, operand1, operand1.t,
                        operand2, operand2.t);
            }
            t = Types.INT;
        }

        //Checking if operator is part of boolAlg
        else if (boolAlg.contains(operator))
        {
            //Checking if operand1.t and operand2.t are Bool types, if not
            //Logical Error
            if (operand1.t != Types.BOOL || operand2.t != Types.BOOL)
            {
                throw new TypeException().logicalError(ctx, operand1, operand1.t,
                        operand2, operand2.t);
            }
            t = Types.BOOL;
        }
        return t;
    }

    @Override public Types visitWhileExpr(SExpressionsParser.WhileExprContext ctx)
    {
        //Setting up expression one t and block one t
        SExpressionsParser.ExprContext expressionOne = ctx.expr();
        SExpressionsParser.BlockContext blockOne = ctx.block();
        expressionOne.t = visit(expressionOne);
        blockOne.t = visit(blockOne);

        //Checking if the type of expressionOne.t is of bool type, if not
        //Condition Error
        if (expressionOne.t != Types.BOOL)
        {
            throw new TypeException().conditionError(ctx,expressionOne,expressionOne.t);
        }

        //Checking if the type of blockOne.t is of Unity Type, if not
        //Loop Body Error
        if (blockOne.t != Types.UNIT)
        {
            throw new TypeException().loopBodyError(ctx,blockOne.expr,blockOne.t);
        }

        return Types.UNIT;
    }

    @Override public Types visitRepeatExpr(SExpressionsParser.RepeatExprContext ctx)
    {
        //Setting up expression one t
        SExpressionsParser.ExprContext exprOne = ctx.expr();
        exprOne.t = visit(exprOne);

        //Setting up block one t
        SExpressionsParser.BlockContext blockOne = ctx.block();
        blockOne.t = visit(ctx.block());

        // the if statement checks whether the type of the expression of the repeat loop is of Type Bool
        if (exprOne.t != Types.BOOL)
        {
            throw new TypeException().conditionError(ctx,exprOne,exprOne.t);
        }

        // the if statement checks whether the type of the block of the repeat loop is of Type Unit
        if (blockOne.t != Types.UNIT)
        {
            throw new TypeException().loopBodyError(ctx,blockOne.expr,blockOne.t);
        }

        return Types.UNIT;
    }

    @Override public Types visitAsgmtExpr(SExpressionsParser.AsgmtExprContext ctx)
    {
        //The if statement checks whether the identifier of the variable has been declared before in this function
        //It does so by checking if the identifier is inside local_vars
        if (!local_vars.containsKey(ctx.identifier().getText()))
        {
            throw new TypeException().undeclaredVarError(current_dec, ctx.identifier(), Types.UNKNOWN);
        }

        // Setting up expression one t
        SExpressionsParser.ExprContext exprOne = ctx.expr();
        exprOne.t = visit(exprOne);

        // Checking if the assignment exists or not
        // Assignment Error
        if (local_vars.get(ctx.identifier().getText()) != exprOne.t)
        {
            throw new TypeException().assignmentError(ctx, ctx.identifier(), local_vars.get(ctx.identifier().getText()), exprOne, exprOne.t);
        }

        return Types.UNIT;
    }

    @Override public Types visitFunInvocExpr(SExpressionsParser.FunInvocExprContext ctx)
    {
        //Checks if the  invoked function exists else
        //Undeclared Function Error
        if (!global_funcs.containsKey(ctx.identifier().Idfr().getText()))
        {
            throw new TypeException().undeclaredFuncError(current_dec,ctx.identifier(),Types.UNKNOWN);
        }

        //Checks if the number of arguments of invoked function is correct else
        //Argument Number Error
        if (ctx.block().exprs.size() != global_funcs.get(ctx.identifier().Idfr().getText()).params.size())
        {
            throw new TypeException().argumentNumberError(ctx, ctx.block(), Types.UNKNOWN);
        }

        //Loops through the expressions of ctx.block()
        for (int i = 0; i < ctx.block().exprs.size(); i++)
        {
            //Checks if the variable ctx.block().expr(i) is the correct type
            //Argument Error
            if (Types.toType(global_funcs.get(ctx.identifier().Idfr().getText()).params.get(i).type()) != visit(ctx.block().expr(i)))
            {
                throw new TypeException().argumentError(ctx,ctx.block().expr(i),visit(ctx.block().expr(i)));
            }
        }
        return Types.toType(global_funcs.get(ctx.identifier().Idfr().getText()).type());
    }

    @Override public Types visitIdExpr(SExpressionsParser.IdExprContext ctx)
    {
        //The if statement checks whether the variable is part of the arguments of the current function declaration
        //It does so by checking the hashmap local_vars
        if (!local_vars.containsKey(ctx.identifier().getText()))
        {
            throw new TypeException().undeclaredVarError(current_dec, ctx.identifier(), Types.UNKNOWN);
        }
        return local_vars.get(ctx.getText());
    }

    @Override public Types visitIntExpr(SExpressionsParser.IntExprContext ctx)
    {
        return Types.INT;
    }

    @Override public Types visitSkipExpr(SExpressionsParser.SkipExprContext ctx)
    {
        return Types.UNIT;
    }

    @Override public Types visitIdentifier(SExpressionsParser.IdentifierContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Types visitInteger(SExpressionsParser.IntegerContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Types visitBinop(SExpressionsParser.BinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Types visitTyped_idfr(SExpressionsParser.Typed_idfrContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Types visitType(SExpressionsParser.TypeContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

}
