// Generated from ..\src\expressivo\parser\Expression.g4 by ANTLR 4.5.1

package expressivo.parser;
// Do not edit this .java file! Edit the grammar in Expression.g4 and re-run Antlr.

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionParser extends Parser {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, SPACES=7, INT=8;
  public static final int
    RULE_root = 0, RULE_expr = 1;
  public static final String[] ruleNames = {
    "root", "expr"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'*'", "'/'", "'+'", "'-'", "'('", "')'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, null, null, null, "SPACES", "INT"
  };
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
  public String getGrammarFileName() { return "Expression.g4"; }

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

  public ExpressionParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class RootContext extends ParserRuleContext {
    public ExprContext expr() {
      return getRuleContext(ExprContext.class,0);
    }
    public TerminalNode EOF() { return getToken(ExpressionParser.EOF, 0); }
    public RootContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_root; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterRoot(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitRoot(this);
    }
    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitRoot(this);
      else return visitor.visitChildren(this);
    }
  }

  public final RootContext root() throws RecognitionException {
    RootContext _localctx = new RootContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_root);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(4);
      expr(0);
      setState(5);
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

  public static class ExprContext extends ParserRuleContext {
    public ExprContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_expr; }
   
    public ExprContext() { }
    public void copyFrom(ExprContext ctx) {
      super.copyFrom(ctx);
    }
  }
  public static class AddOrSubContext extends ExprContext {
    public List<ExprContext> expr() {
      return getRuleContexts(ExprContext.class);
    }
    public ExprContext expr(int i) {
      return getRuleContext(ExprContext.class,i);
    }
    public AddOrSubContext(ExprContext ctx) { copyFrom(ctx); }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterAddOrSub(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitAddOrSub(this);
    }
    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitAddOrSub(this);
      else return visitor.visitChildren(this);
    }
  }
  public static class SingleContext extends ExprContext {
    public ExprContext expr() {
      return getRuleContext(ExprContext.class,0);
    }
    public SingleContext(ExprContext ctx) { copyFrom(ctx); }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterSingle(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitSingle(this);
    }
    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitSingle(this);
      else return visitor.visitChildren(this);
    }
  }
  public static class LieteralContext extends ExprContext {
    public TerminalNode INT() { return getToken(ExpressionParser.INT, 0); }
    public LieteralContext(ExprContext ctx) { copyFrom(ctx); }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterLieteral(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitLieteral(this);
    }
    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitLieteral(this);
      else return visitor.visitChildren(this);
    }
  }
  public static class MultiOrDivContext extends ExprContext {
    public List<ExprContext> expr() {
      return getRuleContexts(ExprContext.class);
    }
    public ExprContext expr(int i) {
      return getRuleContext(ExprContext.class,i);
    }
    public MultiOrDivContext(ExprContext ctx) { copyFrom(ctx); }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterMultiOrDiv(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitMultiOrDiv(this);
    }
    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitMultiOrDiv(this);
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
    int _startState = 2;
    enterRecursionRule(_localctx, 2, RULE_expr, _p);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(13);
      switch (_input.LA(1)) {
      case INT:
        {
        _localctx = new LieteralContext(_localctx);
        _ctx = _localctx;
        _prevctx = _localctx;

        setState(8);
        match(INT);
        }
        break;
      case T__4:
        {
        _localctx = new SingleContext(_localctx);
        _ctx = _localctx;
        _prevctx = _localctx;
        setState(9);
        match(T__4);
        setState(10);
        expr(0);
        setState(11);
        match(T__5);
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
      _ctx.stop = _input.LT(-1);
      setState(23);
      _errHandler.sync(this);
      _alt = getInterpreter().adaptivePredict(_input,2,_ctx);
      while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
        if ( _alt==1 ) {
          if ( _parseListeners!=null ) triggerExitRuleEvent();
          _prevctx = _localctx;
          {
          setState(21);
          switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
          case 1:
            {
            _localctx = new MultiOrDivContext(new ExprContext(_parentctx, _parentState));
            pushNewRecursionContext(_localctx, _startState, RULE_expr);
            setState(15);
            if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
            setState(16);
            _la = _input.LA(1);
            if ( !(_la==T__0 || _la==T__1) ) {
            _errHandler.recoverInline(this);
            } else {
              consume();
            }
            setState(17);
            expr(5);
            }
            break;
          case 2:
            {
            _localctx = new AddOrSubContext(new ExprContext(_parentctx, _parentState));
            pushNewRecursionContext(_localctx, _startState, RULE_expr);
            setState(18);
            if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
            setState(19);
            _la = _input.LA(1);
            if ( !(_la==T__2 || _la==T__3) ) {
            _errHandler.recoverInline(this);
            } else {
              consume();
            }
            setState(20);
            expr(4);
            }
            break;
          }
          } 
        }
        setState(25);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

  public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
    switch (ruleIndex) {
    case 1:
      return expr_sempred((ExprContext)_localctx, predIndex);
    }
    return true;
  }
  private boolean expr_sempred(ExprContext _localctx, int predIndex) {
    switch (predIndex) {
    case 0:
      return precpred(_ctx, 4);
    case 1:
      return precpred(_ctx, 3);
    }
    return true;
  }

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\n\35\4\2\t\2\4"+
      "\3\t\3\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\20\n\3\3\3\3\3\3\3"+
      "\3\3\3\3\3\3\7\3\30\n\3\f\3\16\3\33\13\3\3\3\2\3\4\4\2\4\2\4\3\2\3"+
      "\4\3\2\5\6\35\2\6\3\2\2\2\4\17\3\2\2\2\6\7\5\4\3\2\7\b\7\2\2\3\b\3"+
      "\3\2\2\2\t\n\b\3\1\2\n\20\7\n\2\2\13\f\7\7\2\2\f\r\5\4\3\2\r\16\7"+
      "\b\2\2\16\20\3\2\2\2\17\t\3\2\2\2\17\13\3\2\2\2\20\31\3\2\2\2\21\22"+
      "\f\6\2\2\22\23\t\2\2\2\23\30\5\4\3\7\24\25\f\5\2\2\25\26\t\3\2\2\26"+
      "\30\5\4\3\6\27\21\3\2\2\2\27\24\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2"+
      "\2\31\32\3\2\2\2\32\5\3\2\2\2\33\31\3\2\2\2\5\17\27\31";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}