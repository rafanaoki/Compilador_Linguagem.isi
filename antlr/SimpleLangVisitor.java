// Generated from SimpleLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(SimpleLangParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(SimpleLangParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#declareStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareStmt(SimpleLangParser.DeclareStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(SimpleLangParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmts(SimpleLangParser.StmtsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(SimpleLangParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(SimpleLangParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#writeStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStmt(SimpleLangParser.WriteStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#writelnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWritelnStmt(SimpleLangParser.WritelnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#readStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStmt(SimpleLangParser.ReadStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(SimpleLangParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(SimpleLangParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(SimpleLangParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SimpleLangParser.ExprContext ctx);
}