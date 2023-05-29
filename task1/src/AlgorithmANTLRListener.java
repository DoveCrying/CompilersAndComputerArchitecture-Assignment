// Generated from /Users/zenodeangeli/Desktop/Compilers/Assignments/FinalHandIn/215872/task1/src/AlgorithmANTLR.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AlgorithmANTLRParser}.
 */
public interface AlgorithmANTLRListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AlgorithmANTLRParser#topLevel}.
	 * @param ctx the parse tree
	 */
	void enterTopLevel(AlgorithmANTLRParser.TopLevelContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgorithmANTLRParser#topLevel}.
	 * @param ctx the parse tree
	 */
	void exitTopLevel(AlgorithmANTLRParser.TopLevelContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgorithmANTLRParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(AlgorithmANTLRParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgorithmANTLRParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(AlgorithmANTLRParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgorithmANTLRParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterDec(AlgorithmANTLRParser.DecContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgorithmANTLRParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitDec(AlgorithmANTLRParser.DecContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgorithmANTLRParser#vardec}.
	 * @param ctx the parse tree
	 */
	void enterVardec(AlgorithmANTLRParser.VardecContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgorithmANTLRParser#vardec}.
	 * @param ctx the parse tree
	 */
	void exitVardec(AlgorithmANTLRParser.VardecContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgorithmANTLRParser#vardecne}.
	 * @param ctx the parse tree
	 */
	void enterVardecne(AlgorithmANTLRParser.VardecneContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgorithmANTLRParser#vardecne}.
	 * @param ctx the parse tree
	 */
	void exitVardecne(AlgorithmANTLRParser.VardecneContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgorithmANTLRParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(AlgorithmANTLRParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgorithmANTLRParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(AlgorithmANTLRParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgorithmANTLRParser#ene}.
	 * @param ctx the parse tree
	 */
	void enterEne(AlgorithmANTLRParser.EneContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgorithmANTLRParser#ene}.
	 * @param ctx the parse tree
	 */
	void exitEne(AlgorithmANTLRParser.EneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(AlgorithmANTLRParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(AlgorithmANTLRParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(AlgorithmANTLRParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(AlgorithmANTLRParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AsgmtExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAsgmtExpr(AlgorithmANTLRParser.AsgmtExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AsgmtExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAsgmtExpr(AlgorithmANTLRParser.AsgmtExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinOpExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBinOpExpr(AlgorithmANTLRParser.BinOpExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinOpExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBinOpExpr(AlgorithmANTLRParser.BinOpExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunInvocExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterFunInvocExpr(AlgorithmANTLRParser.FunInvocExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunInvocExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitFunInvocExpr(AlgorithmANTLRParser.FunInvocExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBlockExpr(AlgorithmANTLRParser.BlockExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBlockExpr(AlgorithmANTLRParser.BlockExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIfExpr(AlgorithmANTLRParser.IfExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIfExpr(AlgorithmANTLRParser.IfExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterWhileExpr(AlgorithmANTLRParser.WhileExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitWhileExpr(AlgorithmANTLRParser.WhileExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RepeatExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterRepeatExpr(AlgorithmANTLRParser.RepeatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RepeatExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitRepeatExpr(AlgorithmANTLRParser.RepeatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SkipExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSkipExpr(AlgorithmANTLRParser.SkipExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SkipExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSkipExpr(AlgorithmANTLRParser.SkipExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgorithmANTLRParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(AlgorithmANTLRParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgorithmANTLRParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(AlgorithmANTLRParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgorithmANTLRParser#argsne}.
	 * @param ctx the parse tree
	 */
	void enterArgsne(AlgorithmANTLRParser.ArgsneContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgorithmANTLRParser#argsne}.
	 * @param ctx the parse tree
	 */
	void exitArgsne(AlgorithmANTLRParser.ArgsneContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgorithmANTLRParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterBinop(AlgorithmANTLRParser.BinopContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgorithmANTLRParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitBinop(AlgorithmANTLRParser.BinopContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgorithmANTLRParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(AlgorithmANTLRParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgorithmANTLRParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(AlgorithmANTLRParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgorithmANTLRParser#idfr}.
	 * @param ctx the parse tree
	 */
	void enterIdfr(AlgorithmANTLRParser.IdfrContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgorithmANTLRParser#idfr}.
	 * @param ctx the parse tree
	 */
	void exitIdfr(AlgorithmANTLRParser.IdfrContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgorithmANTLRParser#intlit}.
	 * @param ctx the parse tree
	 */
	void enterIntlit(AlgorithmANTLRParser.IntlitContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgorithmANTLRParser#intlit}.
	 * @param ctx the parse tree
	 */
	void exitIntlit(AlgorithmANTLRParser.IntlitContext ctx);
}