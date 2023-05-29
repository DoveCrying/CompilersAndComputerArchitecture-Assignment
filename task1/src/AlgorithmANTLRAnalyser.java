public class AlgorithmANTLRAnalyser extends AlgorithmANTLRBaseVisitor<String>
{
    public String visitTopLevel(AlgorithmANTLRParser.TopLevelContext ctx)
    {
        return "[" + visit(ctx.prog()) + "]";
    }

    //==========Prog Visits===========
    @Override public String visitProg(AlgorithmANTLRParser.ProgContext ctx)
    {
        //prog: dec
        if (ctx.prog() == null) return visit(ctx.dec());

        //prog: dec prog
        return visit(ctx.dec()) +","+ visit(ctx.prog());
    }

    //==========Dec Visits===========
    @Override public String visitDec(AlgorithmANTLRParser.DecContext ctx)
    {
        // [FunDecl, (fn-name-idfr), (return-type), [list of parameters], (fn-body) ]
        return "[FunDecl," + visit(ctx.idfr()) + "," + visit(ctx.type()) +
                ",[" + visit(ctx.vardec()) + "]," + visit(ctx.block()) + "]";
    }

    //==========Vardec Visits===========
    @Override public String visitVardec(AlgorithmANTLRParser.VardecContext ctx)
    {
        //vardec:
        if(ctx.vardecne() == null) return "";

        //vardec: vardecne
        else return visit(ctx.vardecne()) + "";
    }

    //==========Vardecne Visits===========
    @Override public String visitVardecne(AlgorithmANTLRParser.VardecneContext ctx)
    {
        //vardecne: type idfr
        if (ctx.vardecne() == null) return "[" + visit(ctx.idfr()) + "," + visit(ctx.type()) +"]";

        //vardecne: vardecne Comma type idfr
        return visit(ctx.vardecne()) + "," + "[" + visit(ctx.idfr()) +","+ visit(ctx.type()) +"]";
    }

    //==========Block Visits===========
    @Override public String visitBlock(AlgorithmANTLRParser.BlockContext ctx)
    {
        //   [ (expr-1), (expr-2), ... ]
        return "[" + visit(ctx.ene()) + "]";
    }

    //==========Ene Visits===========
    @Override public String visitEne(AlgorithmANTLRParser.EneContext ctx)
    {
        //ene: exp
        if (ctx.ene() == null) return visit(ctx.exp());

        //ene: exp Semicolon ene
        return visit(ctx.exp()) + "," + visit(ctx.ene());
    }

    //==========Exp Visits===========
    @Override public String visitIdExpr(AlgorithmANTLRParser.IdExprContext ctx)
    {
        return visit(ctx.idfr());
    }

    @Override public String visitIntExpr(AlgorithmANTLRParser.IntExprContext ctx)
    {
        return visit(ctx.intlit());
    }

    @Override public String visitAsgmtExpr (AlgorithmANTLRParser.AsgmtExprContext ctx)
    {
        // [Asgmt, (idfr), (expr) ]
        return "[Asgmt," + visit(ctx.idfr()) + "," +
                visit(ctx.exp()) + "]";
    }

    @Override public String visitBinOpExpr(AlgorithmANTLRParser.BinOpExprContext ctx)
    {
        // [BinOpExpr, (operator-token), (expr-1), (expr-2) ]
        return "[BinOpExpr," +
                visit(ctx.binop())+ "," +
                visit(ctx.exp(0)) + "," +
                visit(ctx.exp(1)) + "]";
    }

    @Override public String visitFunInvocExpr(AlgorithmANTLRParser.FunInvocExprContext ctx)
    {
        //   [FunInvoc, (idfr), [list of arguments] ]
        return "[FunInvoc,"  +
                visit(ctx.idfr()) + "," +
                "[" + visit(ctx.args()) + "]" + "]" ;
    }

    @Override public String visitBlockExpr(AlgorithmANTLRParser.BlockExprContext ctx)
    {
        return visit(ctx.block());
    }

    @Override public String visitIfExpr(AlgorithmANTLRParser.IfExprContext ctx)
    {
        // [IfStmt,     (expr), (then-body), (else-body) ]
        return "[IfStmt," +
                visit(ctx.exp()) + "," +
                visit(ctx.block(0)) + "," +
                visit(ctx.block(1)) + "]" ;
    }

    @Override public String visitWhileExpr(AlgorithmANTLRParser.WhileExprContext ctx)
    {
        // [WhileLoop,  (expr), (loop-body) ]
        return "[WhileLoop," +
                visit(ctx.exp()) + "," +
                visit(ctx.block()) + "]" ;
    }

    @Override public String visitRepeatExpr(AlgorithmANTLRParser.RepeatExprContext ctx)
    {
        // [RepeatLoop, (expr), (loop-body) ]
        return "[RepeatLoop," +
                visit(ctx.exp()) + "," +
                visit(ctx.block()) + "]" ;
    }

    @Override public String visitSkipExpr(AlgorithmANTLRParser.SkipExprContext ctx)
    {
        return AlgorithmANTLRParser.VOCABULARY.getSymbolicName(ctx.getStart().getType());
    }

    //==========Args Visits===========
    @Override public String visitArgs(AlgorithmANTLRParser.ArgsContext ctx)
    {
        //args:
        if (ctx.argsne() == null) return "";

        //args: argsne
        return visit(ctx.argsne());
    }

    //==========Argsne Visits===========
    @Override public String visitArgsne(AlgorithmANTLRParser.ArgsneContext ctx)
    {
        //argsne: exp
        if (ctx.argsne() == null) return visit(ctx.exp());

        //argsne: argsne Comma exp
        else return visit(ctx.argsne()) + ctx.Comma().getText() + visit(ctx.exp()) ;
    }

    //==========Type Visits===========
    @Override public String visitType(AlgorithmANTLRParser.TypeContext ctx)
    {
        return AlgorithmANTLRParser.VOCABULARY.getSymbolicName(ctx.getStart().getType());
    }

    //==========Idfr Visits===========
    @Override public String visitIdfr(AlgorithmANTLRParser.IdfrContext ctx)
    {
        return AlgorithmANTLRParser.VOCABULARY.getSymbolicName(ctx.getStart().getType()) + "(" + '"' + ctx.getText() + '"'  + ")";
    }

    //==========Intlit Visits===========
    @Override public String visitIntlit(AlgorithmANTLRParser.IntlitContext ctx)
    {
        return AlgorithmANTLRParser.VOCABULARY.getSymbolicName(ctx.getStart().getType())+ "(" + ctx.getText() + ")";
    }

    //==========Binop Visits===========
    @Override public String visitBinop(AlgorithmANTLRParser.BinopContext ctx)
    {
        return AlgorithmANTLRParser.VOCABULARY.getSymbolicName(ctx.getStart().getType());
    }
}
