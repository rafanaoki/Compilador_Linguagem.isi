// Generated from SimpleLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleLangParser}.
 */
public interface SimpleLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(SimpleLangParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(SimpleLangParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(SimpleLangParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(SimpleLangParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#declareStmt}.
	 * @param ctx the parse tree
	 */
	void enterDeclareStmt(SimpleLangParser.DeclareStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#declareStmt}.
	 * @param ctx the parse tree
	 */
	void exitDeclareStmt(SimpleLangParser.DeclareStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(SimpleLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(SimpleLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmts(SimpleLangParser.StmtsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmts(SimpleLangParser.StmtsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(SimpleLangParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(SimpleLangParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(SimpleLangParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(SimpleLangParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void enterWriteStmt(SimpleLangParser.WriteStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void exitWriteStmt(SimpleLangParser.WriteStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#writelnStmt}.
	 * @param ctx the parse tree
	 */
	void enterWritelnStmt(SimpleLangParser.WritelnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#writelnStmt}.
	 * @param ctx the parse tree
	 */
	void exitWritelnStmt(SimpleLangParser.WritelnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#readStmt}.
	 * @param ctx the parse tree
	 */
	void enterReadStmt(SimpleLangParser.ReadStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#readStmt}.
	 * @param ctx the parse tree
	 */
	void exitReadStmt(SimpleLangParser.ReadStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(SimpleLangParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(SimpleLangParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(SimpleLangParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(SimpleLangParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(SimpleLangParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(SimpleLangParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SimpleLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SimpleLangParser.ExprContext ctx);
}