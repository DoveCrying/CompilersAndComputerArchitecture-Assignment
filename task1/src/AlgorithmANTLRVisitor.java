// Generated from /Users/zenodeangeli/Desktop/Compilers/Assignments/FinalHandIn/215872/task1/src/AlgorithmANTLR.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlgorithmANTLRParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlgorithmANTLRVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AlgorithmANTLRParser#topLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevel(AlgorithmANTLRParser.TopLevelContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgorithmANTLRParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(AlgorithmANTLRParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgorithmANTLRParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec(AlgorithmANTLRParser.DecContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgorithmANTLRParser#vardec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardec(AlgorithmANTLRParser.VardecContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgorithmANTLRParser#vardecne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardecne(AlgorithmANTLRParser.VardecneContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgorithmANTLRParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(AlgorithmANTLRParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgorithmANTLRParser#ene}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEne(AlgorithmANTLRParser.EneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(AlgorithmANTLRParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(AlgorithmANTLRParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AsgmtExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsgmtExpr(AlgorithmANTLRParser.AsgmtExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinOpExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinOpExpr(AlgorithmANTLRParser.BinOpExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunInvocExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunInvocExpr(AlgorithmANTLRParser.FunInvocExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockExpr(AlgorithmANTLRParser.BlockExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpr(AlgorithmANTLRParser.IfExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileExpr(AlgorithmANTLRParser.WhileExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RepeatExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatExpr(AlgorithmANTLRParser.RepeatExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SkipExpr}
	 * labeled alternative in {@link AlgorithmANTLRParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipExpr(AlgorithmANTLRParser.SkipExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgorithmANTLRParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(AlgorithmANTLRParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgorithmANTLRParser#argsne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgsne(AlgorithmANTLRParser.ArgsneContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgorithmANTLRParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinop(AlgorithmANTLRParser.BinopContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgorithmANTLRParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(AlgorithmANTLRParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgorithmANTLRParser#idfr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdfr(AlgorithmANTLRParser.IdfrContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgorithmANTLRParser#intlit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntlit(AlgorithmANTLRParser.IntlitContext ctx);
}