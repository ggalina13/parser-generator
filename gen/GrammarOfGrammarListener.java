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
	 * Enter a parse tree produced by {@link GrammarOfGrammarParser#notTerminalRule}.
	 * @param ctx the parse tree
	 */
	void enterNotTerminalRule(GrammarOfGrammarParser.NotTerminalRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarOfGrammarParser#notTerminalRule}.
	 * @param ctx the parse tree
	 */
	void exitNotTerminalRule(GrammarOfGrammarParser.NotTerminalRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarOfGrammarParser#terminalRule}.
	 * @param ctx the parse tree
	 */
	void enterTerminalRule(GrammarOfGrammarParser.TerminalRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarOfGrammarParser#terminalRule}.
	 * @param ctx the parse tree
	 */
	void exitTerminalRule(GrammarOfGrammarParser.TerminalRuleContext ctx);
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
	 * Enter a parse tree produced by {@link GrammarOfGrammarParser#terminal}.
	 * @param ctx the parse tree
	 */
	void enterTerminal(GrammarOfGrammarParser.TerminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarOfGrammarParser#terminal}.
	 * @param ctx the parse tree
	 */
	void exitTerminal(GrammarOfGrammarParser.TerminalContext ctx);
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