// Generated from /home/galina13/IdeaProjects/MT/parserGenerator2/src/GrammarOfGrammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarOfGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarOfGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarOfGrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(GrammarOfGrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarOfGrammarParser#strings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrings(GrammarOfGrammarParser.StringsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarOfGrammarParser#atrType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtrType(GrammarOfGrammarParser.AtrTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarOfGrammarParser#nullValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullValue(GrammarOfGrammarParser.NullValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarOfGrammarParser#rule_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule_(GrammarOfGrammarParser.Rule_Context ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarOfGrammarParser#atrCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtrCode(GrammarOfGrammarParser.AtrCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarOfGrammarParser#mainNotTerminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainNotTerminal(GrammarOfGrammarParser.MainNotTerminalContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarOfGrammarParser#notTerminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotTerminal(GrammarOfGrammarParser.NotTerminalContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarOfGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(GrammarOfGrammarParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarOfGrammarParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToken(GrammarOfGrammarParser.TokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarOfGrammarParser#terminalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminalExpr(GrammarOfGrammarParser.TerminalExprContext ctx);
}