// Generated from D:/code_file/JAVA/6.005_mit_software_construction/sp16-ex18-parser-generators/src/intexpr/parser/IntegerExpression.g4 by ANTLR 4.13.1
package intexpr.parser;

package intexpr.parser;
// Do not edit this .java file! Edit the grammar in IntegerExpression.g4 and re-run Antlr.

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class IntegerExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, NUMBER=4;
	public static final int
		RULE_root = 0, RULE_sum = 1, RULE_primitive = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "sum", "primitive"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "NUMBER"
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
	public String getGrammarFileName() { return "IntegerExpression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    // This method makes the lexer or parser stop running if it encounters
	    // invalid input and throw a ParseCancellationException.
	    public void reportErrorsAsExceptions() {
	        // To prevent any reports to standard error, add this line:
	        //removeErrorListeners();
	        
	        addErrorListener(new BaseErrorListener() {
	            public void syntaxError(Recognizer<?, ?> recognizer,
	                                    Object offendingSymbol, 
	                                    int line, int charPositionInLine,
	                                    String msg, RecognitionException e) {
	                throw new ParseCancellationException(msg, e);
	            }
	        });
	    }

	public IntegerExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public TerminalNode EOF() { return getToken(IntegerExpressionParser.EOF, 0); }
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IntegerExpressionListener ) ((IntegerExpressionListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IntegerExpressionListener ) ((IntegerExpressionListener)listener).exitRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntegerExpressionVisitor ) return ((IntegerExpressionVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			sum();
			setState(7);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SumContext extends ParserRuleContext {
		public List<PrimitiveContext> primitive() {
			return getRuleContexts(PrimitiveContext.class);
		}
		public PrimitiveContext primitive(int i) {
			return getRuleContext(PrimitiveContext.class,i);
		}
		public SumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IntegerExpressionListener ) ((IntegerExpressionListener)listener).enterSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IntegerExpressionListener ) ((IntegerExpressionListener)listener).exitSum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntegerExpressionVisitor ) return ((IntegerExpressionVisitor<? extends T>)visitor).visitSum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SumContext sum() throws RecognitionException {
		SumContext _localctx = new SumContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			primitive();
			setState(14);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(10);
				match(T__0);
				setState(11);
				primitive();
				}
				}
				setState(16);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(IntegerExpressionParser.NUMBER, 0); }
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public PrimitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IntegerExpressionListener ) ((IntegerExpressionListener)listener).enterPrimitive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IntegerExpressionListener ) ((IntegerExpressionListener)listener).exitPrimitive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntegerExpressionVisitor ) return ((IntegerExpressionVisitor<? extends T>)visitor).visitPrimitive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveContext primitive() throws RecognitionException {
		PrimitiveContext _localctx = new PrimitiveContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_primitive);
		try {
			setState(22);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				match(NUMBER);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(18);
				match(T__1);
				setState(19);
				sum();
				setState(20);
				match(T__2);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0004\u0019\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001\r\b\u0001\n\u0001\f\u0001\u0010\t"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002\u0017\b\u0002\u0001\u0002\u0000\u0000\u0003\u0000\u0002\u0004\u0000"+
		"\u0000\u0017\u0000\u0006\u0001\u0000\u0000\u0000\u0002\t\u0001\u0000\u0000"+
		"\u0000\u0004\u0016\u0001\u0000\u0000\u0000\u0006\u0007\u0003\u0002\u0001"+
		"\u0000\u0007\b\u0005\u0000\u0000\u0001\b\u0001\u0001\u0000\u0000\u0000"+
		"\t\u000e\u0003\u0004\u0002\u0000\n\u000b\u0005\u0001\u0000\u0000\u000b"+
		"\r\u0003\u0004\u0002\u0000\f\n\u0001\u0000\u0000\u0000\r\u0010\u0001\u0000"+
		"\u0000\u0000\u000e\f\u0001\u0000\u0000\u0000\u000e\u000f\u0001\u0000\u0000"+
		"\u0000\u000f\u0003\u0001\u0000\u0000\u0000\u0010\u000e\u0001\u0000\u0000"+
		"\u0000\u0011\u0017\u0005\u0004\u0000\u0000\u0012\u0013\u0005\u0002\u0000"+
		"\u0000\u0013\u0014\u0003\u0002\u0001\u0000\u0014\u0015\u0005\u0003\u0000"+
		"\u0000\u0015\u0017\u0001\u0000\u0000\u0000\u0016\u0011\u0001\u0000\u0000"+
		"\u0000\u0016\u0012\u0001\u0000\u0000\u0000\u0017\u0005\u0001\u0000\u0000"+
		"\u0000\u0002\u000e\u0016";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}