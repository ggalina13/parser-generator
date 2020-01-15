// Generated from /home/galina13/IdeaProjects/MT/parserGenerator2/src/GrammarOfGrammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarOfGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, TokenName=6, Rgx=7, WS=8;
	public static final int
		RULE_start = 0, RULE_strings = 1, RULE_notTerminalRule = 2, RULE_terminalRule = 3, 
		RULE_mainNotTerminal = 4, RULE_notTerminal = 5, RULE_terminal = 6, RULE_expr = 7, 
		RULE_token = 8, RULE_terminalExpr = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "strings", "notTerminalRule", "terminalRule", "mainNotTerminal", 
			"notTerminal", "terminal", "expr", "token", "terminalExpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "':'", "'|'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "TokenName", "Rgx", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GrammarOfGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarOfGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public StringsContext strings() {
			return getRuleContext(StringsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarOfGrammarParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarOfGrammarVisitor ) return ((GrammarOfGrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			strings();
			setState(21);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringsContext extends ParserRuleContext {
		public StringsContext strings() {
			return getRuleContext(StringsContext.class,0);
		}
		public TerminalRuleContext terminalRule() {
			return getRuleContext(TerminalRuleContext.class,0);
		}
		public NotTerminalRuleContext notTerminalRule() {
			return getRuleContext(NotTerminalRuleContext.class,0);
		}
		public StringsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strings; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).enterStrings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).exitStrings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarOfGrammarVisitor ) return ((GrammarOfGrammarVisitor<? extends T>)visitor).visitStrings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringsContext strings() throws RecognitionException {
		StringsContext _localctx = new StringsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_strings);
		try {
			setState(31);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TokenName:
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(23);
					terminalRule();
					}
					break;
				case 2:
					{
					setState(24);
					notTerminalRule();
					}
					break;
				}
				setState(27);
				match(T__0);
				setState(28);
				strings();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotTerminalRuleContext extends ParserRuleContext {
		public MainNotTerminalContext mainNotTerminal() {
			return getRuleContext(MainNotTerminalContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public NotTerminalRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notTerminalRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).enterNotTerminalRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).exitNotTerminalRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarOfGrammarVisitor ) return ((GrammarOfGrammarVisitor<? extends T>)visitor).visitNotTerminalRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotTerminalRuleContext notTerminalRule() throws RecognitionException {
		NotTerminalRuleContext _localctx = new NotTerminalRuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_notTerminalRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			mainNotTerminal();
			setState(34);
			match(T__1);
			setState(35);
			expr(0);
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(36);
				match(T__2);
				setState(37);
				expr(0);
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TerminalRuleContext extends ParserRuleContext {
		public TerminalContext terminal() {
			return getRuleContext(TerminalContext.class,0);
		}
		public TerminalExprContext terminalExpr() {
			return getRuleContext(TerminalExprContext.class,0);
		}
		public TerminalRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminalRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).enterTerminalRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).exitTerminalRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarOfGrammarVisitor ) return ((GrammarOfGrammarVisitor<? extends T>)visitor).visitTerminalRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerminalRuleContext terminalRule() throws RecognitionException {
		TerminalRuleContext _localctx = new TerminalRuleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_terminalRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			terminal();
			setState(44);
			match(T__1);
			setState(45);
			terminalExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainNotTerminalContext extends ParserRuleContext {
		public NotTerminalContext notTerminal() {
			return getRuleContext(NotTerminalContext.class,0);
		}
		public MainNotTerminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainNotTerminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).enterMainNotTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).exitMainNotTerminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarOfGrammarVisitor ) return ((GrammarOfGrammarVisitor<? extends T>)visitor).visitMainNotTerminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainNotTerminalContext mainNotTerminal() throws RecognitionException {
		MainNotTerminalContext _localctx = new MainNotTerminalContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_mainNotTerminal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			notTerminal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotTerminalContext extends ParserRuleContext {
		public TerminalNode TokenName() { return getToken(GrammarOfGrammarParser.TokenName, 0); }
		public NotTerminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notTerminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).enterNotTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).exitNotTerminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarOfGrammarVisitor ) return ((GrammarOfGrammarVisitor<? extends T>)visitor).visitNotTerminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotTerminalContext notTerminal() throws RecognitionException {
		NotTerminalContext _localctx = new NotTerminalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_notTerminal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(TokenName);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TerminalContext extends ParserRuleContext {
		public TerminalNode TokenName() { return getToken(GrammarOfGrammarParser.TokenName, 0); }
		public TerminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).enterTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).exitTerminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarOfGrammarVisitor ) return ((GrammarOfGrammarVisitor<? extends T>)visitor).visitTerminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerminalContext terminal() throws RecognitionException {
		TerminalContext _localctx = new TerminalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_terminal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(TokenName);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TokenContext token() {
			return getRuleContext(TokenContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarOfGrammarVisitor ) return ((GrammarOfGrammarVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TokenName:
			case Rgx:
				{
				setState(54);
				token();
				}
				break;
			case T__3:
				{
				setState(55);
				match(T__3);
				setState(56);
				expr(0);
				setState(57);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(61);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(62);
					expr(2);
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TokenContext extends ParserRuleContext {
		public NotTerminalContext notTerminal() {
			return getRuleContext(NotTerminalContext.class,0);
		}
		public TerminalExprContext terminalExpr() {
			return getRuleContext(TerminalExprContext.class,0);
		}
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).enterToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).exitToken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarOfGrammarVisitor ) return ((GrammarOfGrammarVisitor<? extends T>)visitor).visitToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_token);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TokenName:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				notTerminal();
				}
				break;
			case Rgx:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				terminalExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TerminalExprContext extends ParserRuleContext {
		public TerminalNode Rgx() { return getToken(GrammarOfGrammarParser.Rgx, 0); }
		public TerminalExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminalExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).enterTerminalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarOfGrammarListener ) ((GrammarOfGrammarListener)listener).exitTerminalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarOfGrammarVisitor ) return ((GrammarOfGrammarVisitor<? extends T>)visitor).visitTerminalExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerminalExprContext terminalExpr() throws RecognitionException {
		TerminalExprContext _localctx = new TerminalExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_terminalExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(Rgx);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\nM\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\2\3\3\3\3\5\3\34\n\3\3\3\3\3\3\3\3\3\5\3\"\n\3\3\4\3\4\3\4\3"+
		"\4\3\4\7\4)\n\4\f\4\16\4,\13\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\5\t>\n\t\3\t\3\t\7\tB\n\t\f\t\16\tE\13\t\3\n"+
		"\3\n\5\nI\n\n\3\13\3\13\3\13\2\3\20\f\2\4\6\b\n\f\16\20\22\24\2\2\2H\2"+
		"\26\3\2\2\2\4!\3\2\2\2\6#\3\2\2\2\b-\3\2\2\2\n\61\3\2\2\2\f\63\3\2\2\2"+
		"\16\65\3\2\2\2\20=\3\2\2\2\22H\3\2\2\2\24J\3\2\2\2\26\27\5\4\3\2\27\30"+
		"\7\2\2\3\30\3\3\2\2\2\31\34\5\b\5\2\32\34\5\6\4\2\33\31\3\2\2\2\33\32"+
		"\3\2\2\2\34\35\3\2\2\2\35\36\7\3\2\2\36\37\5\4\3\2\37\"\3\2\2\2 \"\3\2"+
		"\2\2!\33\3\2\2\2! \3\2\2\2\"\5\3\2\2\2#$\5\n\6\2$%\7\4\2\2%*\5\20\t\2"+
		"&\'\7\5\2\2\')\5\20\t\2(&\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\7\3\2"+
		"\2\2,*\3\2\2\2-.\5\16\b\2./\7\4\2\2/\60\5\24\13\2\60\t\3\2\2\2\61\62\5"+
		"\f\7\2\62\13\3\2\2\2\63\64\7\b\2\2\64\r\3\2\2\2\65\66\7\b\2\2\66\17\3"+
		"\2\2\2\678\b\t\1\28>\5\22\n\29:\7\6\2\2:;\5\20\t\2;<\7\7\2\2<>\3\2\2\2"+
		"=\67\3\2\2\2=9\3\2\2\2>C\3\2\2\2?@\f\3\2\2@B\5\20\t\4A?\3\2\2\2BE\3\2"+
		"\2\2CA\3\2\2\2CD\3\2\2\2D\21\3\2\2\2EC\3\2\2\2FI\5\f\7\2GI\5\24\13\2H"+
		"F\3\2\2\2HG\3\2\2\2I\23\3\2\2\2JK\7\t\2\2K\25\3\2\2\2\b\33!*=CH";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}