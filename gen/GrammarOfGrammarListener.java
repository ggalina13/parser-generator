// Generated from /home/galina13/IdeaProjects/MT/parserGenerator2/src/GrammarOfGrammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarOfGrammarParser}.
 */
public interface GrammarOfGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarOfGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(GrammarOfGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarOfGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(GrammarOfGrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarOfGrammarParser#strings}.
	 * @param ctx the parse tree
	 */
	void enterStrings(GrammarOfGrammarParser.StringsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarOfGrammarParser#strings}.
	 * @param ctx the parse tree
	 */
	void exitStrings(GrammarOfGrammarParser.StringsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarOfGrammarParser#atrType}.
	 * @param ctx the parse tree
	 */
	void enterAtrType(GrammarOfGrammarParser.AtrTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarOfGrammarParser#atrType}.
	 * @param ctx the parse tree
	 */
	void exitAtrType(GrammarOfGrammarParser.AtrTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarOfGrammarParser#nullValue}.
	 * @param ctx the parse tree
	 */
	void enterNullValue(GrammarOfGrammarParser.NullValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarOfGrammarParser#nullValue}.
	 * @param ctx the parse tree
	 */
	void exitNullValue(GrammarOfGrammarParser.NullValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarOfGrammarParser#rule_}.
	 * @param ctx the parse tree
	 */
	void enterRule_(GrammarOfGrammarParser.Rule_Context ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarOfGrammarParser#rule_}.
	 * @param ctx the parse tree
	 */
	void exitRule_(GrammarOfGrammarParser.Rule_Context ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarOfGrammarParser#atrCode}.
	 * @param ctx the parse tree
	 */
	void enterAtrCode(GrammarOfGrammarParser.AtrCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarOfGrammarParser#atrCode}.
	 * @param ctx the parse tree
	 */
	void exitAtrCode(GrammarOfGrammarParser.AtrCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarOfGrammarParser#mainNotTerminal}.
	 * @param ctx the parse tree
	 */
	void enterMainNotTerminal(GrammarOfGrammarParser.MainNotTerminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarOfGrammarParser#mainNotTerminal}.
	 * @param ctx the parse tree
	 */
	void exitMainNotTerminal(GrammarOfGrammarParser.MainNotTerminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarOfGrammarParser#notTerminal}.
	 * @param ctx the parse tree
	 */
	void enterNotTerminal(GrammarOfGrammarParser.NotTerminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarOfGrammarParser#notTerminal}.
	 * @param ctx the parse tree
	 */
	void exitNotTerminal(GrammarOfGrammarParser.NotTerminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarOfGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GrammarOfGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarOfGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GrammarOfGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarOfGrammarParser#token}.
	 * @param ctx the parse tree
	 */
	void enterToken(GrammarOfGrammarParser.TokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarOfGrammarParser#token}.
	 * @param ctx the parse tree
	 */
	void exitToken(GrammarOfGrammarParser.TokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarOfGrammarParser#terminalExpr}.
	 * @param ctx the parse tree
	 */
	void enterTerminalExpr(GrammarOfGrammarParser.TerminalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarOfGrammarParser#terminalExpr}.
	 * @param ctx the parse tree
	 */
	void exitTerminalExpr(GrammarOfGrammarParser.TerminalExprContext ctx);
}