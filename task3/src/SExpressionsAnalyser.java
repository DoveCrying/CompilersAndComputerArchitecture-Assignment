import java.util.*;

public class SExpressionsAnalyser extends SExpressionsBaseVisitor<String>
{
    //HashMap to keep track of variables present in the current function
    private final HashMap<String, String> fpLabels = new HashMap<>();

    private boolean funInvocArg = false;

    //Counter used to create unique labels (label_1, label_2 etc...)
    private static int counter = 0;

    //Used to keep the fp counter
    private int fpCount = 0;

    public String visitAndPrint(SExpressionsParser.ProgContext prog)
    {
        String macros = "         .macro PushImm ($number)\n" +
                "                li                      t1, $number\n" +
                "                sw                      t1, (sp)\n" +
                "                addi            sp, sp, -4\n" +
                "        .end_macro\n" +
                "        \n" +
                "        .macro PushAbs ($address)\n" +
                "                sw                      $address, (sp)\n" +
                "                addi            sp, sp, -4\n" +
                "        .end_macro\n" +
                "        \n" +
                "        .macro PushVar ($number)\n" +
                "                lw                      t1, -$number(fp)\n" +
                "                sw                      t1, (sp)\n" +
                "                addi            sp, sp, -4\n" +
                "        .end_macro \n" +
                "        \n" +
                "        .macro PopVar ($number)\n" +
                "                addi             sp, sp, 4\n" +
                "                lw                      t1, (sp)\n" +
                "                sw                      t1, -$number(fp)\n" +
                "        .end_macro \n" +
                "        \n" +
                "        .macro PushArg ($number)\n" +
                "        \tlw\t\t\tt1, -$number(a5)\n" +
                "        \tsw                      t1, (sp)\n" +
                "                addi            \tsp, sp, -4\n" +
                "        .end_macro\n" +
                "        .macro PushRel($number)\n" +
                "                lw                      t1, $number(sp)\n" +
                "                sw                      t1, (sp)\n" +
                "                addi            sp, sp, -4\n" +
                "        .end_macro \n" +
                "        \n" +
                "        .macro PopAbs ($address)\n" +
                "                addi            sp, sp, 4\n" +
                "                lw                      $address, (sp)\n" +
                "        .end_macro\n" +
                "        \n" +
                "        .macro PopRel ($number)\n" +
                "                addi            sp, sp, 4\n" +
                "                lw                      t1, (sp)\n" +
                "                sw                      t1, $number(sp)\n" +
                "        .end_macro\n" +
                "        \n" +
                "        .macro FunInvoc\n" +
                "        \tmv \t\t\ta5 fp\n" +
                "                mv                      t2 sp\n" +
                "                sw                      ra 0(sp)        \n" +
                "                addi            sp  sp  -4  \n" +
                "                sw                      t2 0(sp)      \n" +
                "                addi            sp  sp  -4  \n" +
                "                sw                      fp 0(sp)        \n" +
                "                mv                      fp  sp          \n" +
                "                addi            sp  sp  -4\n" +
                "        .end_macro \n" +
                "        \n" +
                "        .macro RestoreRecursion\n" +
                "                lw                      sp 4(fp)\n" +
                "                lw                      fp 0(fp)\n" +
                "                lw                      ra 0(sp)\n" +
                "        .end_macro \n" +
                "        \n" +
                "        .macro  Plus\n" +
                "                lw                      t1, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                lw                      t2, 4(sp)\n" +
                "                addi            sp, sp, 4               \n" +
                "                add                     t2, t2, t1\n" +
                "                sw                      t2, (sp)\n" +
                "                addi            sp, sp, -4\n" +
                "        .end_macro\n" +
                "        \n" +
                "        .macro  Minus\n" +
                "                lw                      t1, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                lw                      t2, 4(sp)\n" +
                "                addi            sp, sp, 4               \n" +
                "                sub                     t2, t1, t2\n" +
                "                sw                      t2, (sp)\n" +
                "                addi            sp, sp, -4\n" +
                "        .end_macro\n" +
                "        .macro  Times\n" +
                "                lw                      t1, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                lw                      t2, 4(sp)\n" +
                "                addi            sp, sp, 4               \n" +
                "                mul                     t2, t2, t1\n" +
                "                sw                      t2, (sp)\n" +
                "                addi            sp, sp, -4\n" +
                "        .end_macro\n" +
                "        \n" +
                "        .macro  Divide\n" +
                "                lw                      t1, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                lw                      t2, 4(sp)\n" +
                "                addi            sp, sp, 4               \n" +
                "                div                     t2, t1, t2\n" +
                "                sw                      t2, (sp)\n" +
                "                addi            sp, sp, -4\n" +
                "        .end_macro\n" +
                "        \n" +
                "        .macro  Eq              \n" +
                "                lw                      t1, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                lw                      t2, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                sub             t4, t1, t2\n" +
                "                seqz            t4, t4     \n" +
                "                sw              t4, (sp)\n" +
                "                addi            sp, sp, -4   \n" +
                "        .end_macro\n" +
                "\n" +
                "        .macro  Less            \n" +
                "                lw                      t1, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                lw                      t2, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                sgt             t3, t2, t1\n" +
                "                sw                      t3, (sp)\n" +
                "                addi            sp, sp, -4\n" +
                "        .end_macro\n" +
                "        \n" +
                "        .macro  LessEq          \n" +
                "                lw                      t1, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                lw                      t2, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                sgt             t3, t2, t1\n" +
                "                sub             t4, t1, t2\n" +
                "                seqz            t4, t4\n" +
                "                or              t5, t4, t3\n" +
                "                sw              t5, (sp)\n" +
                "                addi            sp, sp, -4\n" +
                "        .end_macro\n" +
                "\n" +
                "        .macro  Gtr             \n" +
                "                lw                      t1, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                lw                      t2, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                sgt             t3, t1, t2     \n" +
                "                sw                      t3, (sp)\n" +
                "                addi            sp, sp, -4  \n" +
                "        .end_macro\n" +
                "        \n" +
                "        .macro  GtrEq           \n" +
                "                lw                      t1, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                lw                      t2, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                sgt             t3, t1, t2\n" +
                "                sub             t4, t1, t2\n" +
                "                seqz            t4, t4\n" +
                "                or              t5, t4, t3\n" +
                "                sw              t5, (sp)\n" +
                "                addi            sp, sp, -4\n" +
                "        .end_macro\n" +
                "        .macro  JumpTrue ($label)\n" +
                "                lw                      t1, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                li      t2, 1\n" +
                "                beq t1, t2, $label\n" +
                "        .end_macro\n" +
                "        .macro And_\n" +
                "                lw                      t1, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                lw                      t2, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                and t3, t2, t1\n" +
                "                sw              t3, (sp)\n" +
                "                addi            sp, sp, -4\n" +
                "        .end_macro \n" +
                "        \n" +
                "        .macro Or_\n" +
                "                lw                      t1, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                lw                      t2, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                or t3, t2, t1\n" +
                "                sw              t3, (sp)\n" +
                "                addi            sp, sp, -4\n" +
                "        .end_macro \n" +
                "        \n" +
                "        .macro Xor_\n" +
                "                lw                      t1, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                lw                      t2, 4(sp)\n" +
                "                addi            sp, sp, 4\n" +
                "                xor t3, t2, t1\n" +
                "                sw              t3, (sp)\n" +
                "                addi            sp, sp, -4\n" +
                "        .end_macro\n";

        //visit(prog).replaceAll("(?m)^[ \t]*\r?\n", "") removes all the empty lines from the code generation
        //To get this regex as good as possible, it was inspired and learnt from this
        //post: https://stackoverflow.com/questions/4123385/remove-all-empty-lines
        return macros + visit(prog).replaceAll("(?m)^[ \t]*\r?\n", "");
    }

    //Visiting Function Declaration Function
    //===============================
    @Override public String visitProg(SExpressionsParser.ProgContext ctx)
    {
        SExpressionsParser.DecContext main = null;

        StringBuilder codeGeneration = new StringBuilder();

        //For loop to initialise all global functions
        for (int i = 0; i < ctx.decs.size(); i++)
        {
            stringNewLine(codeGeneration,"    .globl " +  ctx.dec(i).identifier().Idfr().getText() +"_");
        }

        //b main makes sure that the stack machine begins compiling from class main
        stringNewLine(codeGeneration,"b main_");

        for (int i = 0; i < ctx.decs.size(); i++)
        {
            //If the Function is not named main, then the function is visited and instructions are adedd to the
            //String Builder
            if (!Objects.equals(ctx.dec(i).identifier().Idfr().getText(), "main"))
            {
                stringNewLine(codeGeneration,ctx.dec(i).identifier().Idfr().getText()+"_:");
                stringNewLine(codeGeneration,visit(ctx.dec(i)));
            }
            //Checking if the name of the function is main, if it is, the declaration number i is saved in the
            //Main variable
            if (Objects.equals(ctx.dec(i).identifier().Idfr().getText(), "main"))
            {
                main = ctx.dec(i);
            }
        }

        //Variable main is visited (necessary to have the final function being main)
        assert main != null;
        stringNewLine(codeGeneration,main.identifier().Idfr().getText() +"_:");
        stringNewLine(codeGeneration, visit(main));

        //At the very end, the top of the stack is popped into a0 and the programs finishes its run
        stringNewLine(codeGeneration,"PopAbs a0");

        return codeGeneration.toString();
    }

    //Visiting Function Declaration Function
    //===============================
    @Override public String visitDec(SExpressionsParser.DecContext ctx)
    {
        StringBuilder codeGeneration = new StringBuilder();

        //Clears and restore all the fpLabels and fpCount for the current declaration function
        fpCount = 0;
        fpLabels.clear();

        //Check whether the current function declaration has name main, if not, then the arguments
        //are saved in the fpLabels HashMap
        if (!Objects.equals(ctx.identifier().Idfr().getText(), "main"))
        {
            for (int i = 0; i < ctx.typed_idfr().size(); i++)
            {
                String currentFp = fPointer();
                fpLabels.put(ctx.typed_idfr(i).identifier().getText(), currentFp);
            }
        }

        //The Contents of the function are visited and added to the StringBuilder
        stringNewLine(codeGeneration, visit(ctx.block()));

        //If the name of the function is not main, then ret is added at the end. This is to make sure if the function
        //Only returns a variable, that it returns to its previous return address. This is not needed if the function
        //is named main.
        if (!Objects.equals(ctx.identifier().Idfr().getText(), "main"))
        {
            stringNewLine(codeGeneration, "ret");
        }
        return codeGeneration.toString();
    }

    //Visiting Block Function
    //===============================
    @Override public String visitBlock(SExpressionsParser.BlockContext ctx)
    {
        StringBuilder codeGeneration = new StringBuilder();

        //The for loop, loops through all the expressions of ctx.block() and adds their contents to
        //the StringBuilder
        for (int i = 0; i < ctx.exprs.size(); i++)
        {
            stringNewLine(codeGeneration,visit(ctx.expr(i)));
        }
        return codeGeneration.toString();
    }

    //Visiting Loops  and If Functions
    //===============================
    //If Statement
    @Override public String visitIfExpr(SExpressionsParser.IfExprContext ctx)
    {
        StringBuilder codeGeneration = new StringBuilder();

        //Creating a label to indicate where to go if the if statement is successful
        String thenLabel = newLabel();
        String finishIf = newLabel();

        //Prepares the variables and specifies to the FuncInvoc macro the label (thenLabel)
        stringNewLine(codeGeneration, visit(ctx.expr()));
        stringNewLine(codeGeneration,"JumpTrue " + thenLabel);

        //If the function does not jump to the thenLabel, the content of the else part of the
        //if statement are placed.
        stringNewLine(codeGeneration, visit(ctx.block(1)));

        //After the if function is over, it jumps at the end of said if statement
        stringNewLine(codeGeneration, "b " + finishIf);

        //Preparation of label thenLabel and its contents ctx.block(0)
        stringNewLine(codeGeneration,thenLabel + ":");
        stringNewLine(codeGeneration, visit(ctx.block(0)));

        //Same thing as before, but in this case its added at the then label
        stringNewLine(codeGeneration, "b " + finishIf);

        //finishIf label is placed at the end of the if Statement
        stringNewLine(codeGeneration, finishIf + ":");

        return codeGeneration.toString();
    }

    //===============================
    //While loop Statement
    @Override public String visitWhileExpr (SExpressionsParser.WhileExprContext ctx)
    {
        StringBuilder codeGeneration = new StringBuilder();

        //Similarly to the IfStatement, here we create a doLabel to indicate what to do
        //while the condition is met
        String whileLabel = newLabel();
        String doLabel = newLabel();
        String endLoop = newLabel();

        //Condition for the loop to run are placed after the whileLabel
        //If the conditions are met, the body of the loop is run by jumping to label doLabel
        stringNewLine(codeGeneration, whileLabel + ":");
        stringNewLine(codeGeneration, visit(ctx.expr()));
        stringNewLine(codeGeneration, "JumpTrue " + doLabel);

        //After the expr returns false (0), the code will branch to endloop
        stringNewLine(codeGeneration, "b " +endLoop);

        //The contents of the do part of the while loop are added, ending with "b whileLabel" which allows us to check
        //if the condition are met in the next iteration
        stringNewLine(codeGeneration, doLabel + ":");
        stringNewLine(codeGeneration, visit(ctx.block()));
        stringNewLine(codeGeneration, "b " + whileLabel);
        stringNewLine(codeGeneration, endLoop + ":");
        return codeGeneration.toString();
    }

    //===============================
    //Repeat\For loop Statement
    @Override public String visitRepeatExpr(SExpressionsParser.RepeatExprContext ctx)
    {
        StringBuilder codeGeneration = new StringBuilder();

        //Creating a Label for the start of the repeat loop
        String startLabel = newLabel();

        //Creating a Label for the end of the repeat loop
        String endLabel = newLabel();

        //Creating a label for the body of the repeat loop
        String bodyLabel = newLabel();

        //The loop body is generated
        stringNewLine(codeGeneration, bodyLabel + ":");
        stringNewLine(codeGeneration, visit(ctx.block()));
        stringNewLine(codeGeneration, "b " + startLabel);

        //The condition of the for loop are generated
        stringNewLine(codeGeneration, startLabel + ":");
        stringNewLine(codeGeneration, visit(ctx.expr()));
        stringNewLine(codeGeneration,"JumpTrue " + endLabel);

        //If the condition to stop the repeat loop is not met, then the program jumps back to the bodyLabel
        stringNewLine(codeGeneration, "b " + bodyLabel);

        //endLabel placed at the end of the repeat loop
        stringNewLine(codeGeneration, endLabel + ":");

        return codeGeneration.toString();
    }

    //===============================
    //Visiting BinExpr (and Binop to get operator)
    @Override public String visitBinExpr(SExpressionsParser.BinExprContext ctx)
    {
        //firstExpr gets the first expression of the BinOp
        String firstExpr = visit(ctx.expr(0)) + "\n";

        //secondExpr gets the second expression of the BinOp
        String secondtExpr = visit(ctx.expr(1)) + "\n";

        //Returns the expressions plus the binop().getText()
        //Some words in binop are already used as functions in rars, thus for this few ones a "_" is added at the end
        if (ctx.binop().getText().equals("Div")) return secondtExpr + firstExpr + "Divide";
        else if (ctx.binop().getText().equals("And")) return secondtExpr + firstExpr + "And_";
        else if (ctx.binop().getText().equals("Or")) return secondtExpr + firstExpr + "Or_";
        else if (ctx.binop().getText().equals("Xor")) return secondtExpr + firstExpr + "Xor_";
        else return secondtExpr + firstExpr + ctx.binop().getText();
    }

    @Override public String visitBinop(SExpressionsParser.BinopContext ctx)
    {
        //Simply returns the name of the Binop of ctx
        //Macros allow us to not worry about the function of each different Binop
        return ctx.getText();
    }

    //Visiting Function Invocation
    //===============================
    @Override public String visitFunInvocExpr(SExpressionsParser.FunInvocExprContext ctx)
    {
        StringBuilder codeGeneration = new StringBuilder();

        //FunInvocArg is set true, this means that until this value becomes false
        //Every variable added will be considered an argument of the invoked function
        //So, instead of Pushing the fp value of the desired variable, the a5 value is pushed(which is the backup of the
        //Previous fp value)
        funInvocArg = true;

        //Letting the machine know to start the macro FunInvoc
        stringNewLine(codeGeneration, "FunInvoc");

        //The for loop adds all the argument for the current FunInvoc in the form PushArg and not PushVal
        //Examples:
        //PushArg = lw t1, -$number(a5)
        //PushVal = lw t1, -$number(fp)
        for (int i = 0 ; i < ctx.block().exprs.size(); i++)
        {
            stringNewLine(codeGeneration, visit(ctx.block().expr(i)));
        }

        //After all the arguments are done being pushed in, funInvocArg becomes false.
        funInvocArg = false;

        //This next line then specifies where the function is using jal and the name of the function
        stringNewLine(codeGeneration, "jal " + ctx.identifier().Idfr().getText()+"_");
        stringNewLine(codeGeneration, "PopAbs a0");
        stringNewLine(codeGeneration, "RestoreRecursion");

        //PushAbs a0 adds on top of the stack the return value of the current function invocation.
        stringNewLine(codeGeneration, "PushAbs a0");

        return codeGeneration.toString();
    }

    //Visiting Assignment
    //===============================
    @Override public String visitAsgmtExpr (SExpressionsParser.AsgmtExprContext ctx)
    {
        //For the Assignments expressions, the code first visits and returns a list of commands of the expression.
        //This expression is then saved in the correct argument (AKA the correct fpLabels value, found by using
        //ctx.identifier() )
        return visit(ctx.expr()) + "\nPopVar " + fpLabels.get(ctx.identifier().getText()) + "\n";
    }

    //Visiting Id and IntLit Token
    //===============================
    @Override public String visitIdExpr(SExpressionsParser.IdExprContext ctx)
    {
        //Checks whether the variable called exists in fpLabels.
        //If it does, then macro PushInvoc + fpLabels is returned
        //This keeps track of same name variables
        if(funInvocArg) return "PushArg " + fpLabels.get(ctx.identifier().getText());
        return "PushVar " + fpLabels.get(ctx.identifier().getText());
    }

    @Override public String visitIntExpr(SExpressionsParser.IntExprContext ctx)
    {
        //A simple PushImm macro is used in combination with the ctx's IntLit() value
        return "PushImm " + ctx.integer().IntLit().getText();
    }

    //Visiting Skip Token
    //===============================
    @Override public String visitSkipExpr(SExpressionsParser.SkipExprContext ctx)
    {
        return "nop\n";
    }

    /**
     * Essentially, stringNewline is used to clean up the entire code. Since every line of the code needs to be separated
     * by a new line, calling stringNewLine automatically adds a "\n" after the code is added to the StringBuilder.
     * Inspired by this post: https://stackoverflow.com/questions/19813431/stringbuilder-append-content-to-a-new-line-every-time
     *
     * @param codeGeneration This is the StringBuilder that we want to have the code added to
     * @param code This is the String of the newly generated code
     */
    public void stringNewLine(StringBuilder codeGeneration, String code) {
        codeGeneration.append(code);
        codeGeneration.append(System.lineSeparator());
    }

    /**
     * newLabel() is a simple function that creates a new label (used in for loops, while loops, and if statements)
     * Everytime a newLabel() is called, a unique label is created using the static int counter value, that will increase
     * by one everytime the function is called
     *
     * @return The function returns the String label_ + the new unique number taken by the integer counter.
     */
    public String newLabel()
    {
        //Static counter increases by one everytime its called
        counter++;
        return "label_" + counter;
    }

    /**
     * fPointer is a function that will create and add to the fp number.
     * This is needed to keep track of the arguments in activation records
     *
     * @return The new fpCounter of the argument in the activation record
     */
    public String fPointer()
    {
        //fpCount increases by 4 everytime it's called
        fpCount += 4;
        return String.valueOf(fpCount);
    }
}
