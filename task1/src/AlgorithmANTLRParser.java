// Generated from /Users/zenodeangeli/Desktop/Compilers/Assignments/FinalHandIn/215872/task1/src/AlgorithmANTLR.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AlgorithmANTLRParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IntType=1, BoolType=2, UnitType=3, Assign=4, LessEq=5, Eq=6, GtrEq=7, 
		Less=8, Plus=9, Minus=10, And=11, Xor=12, Gtr=13, Times=14, Div=15, Or=16, 
		While=17, Do=18, Repeat=19, Until=20, If=21, Then=22, Else=23, LParen=24, 
		Comma=25, RParen=26, LBrace=27, Semicolon=28, RBrace=29, Skip=30, Idfr=31, 
		IntLit=32, Ignore=33;
	public static final int
		RULE_topLevel = 0, RULE_prog = 1, RULE_dec = 2, RULE_vardec = 3, RULE_vardecne = 4, 
		RULE_block = 5, RULE_ene = 6, RULE_exp = 7, RULE_args = 8, RULE_argsne = 9, 
		RULE_binop = 10, RULE_type = 11, RULE_idfr = 12, RULE_intlit = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"topLevel", "prog", "dec", "vardec", "vardecne", "block", "ene", "exp", 
			"args", "argsne", "binop", "type", "idfr", "intlit"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'bool'", "'unit'", "':='", "'<='", "'=='", "'>='", "'<'", 
			"'+'", "'-'", "'&&'", "'^^'", "'>'", "'*'", "'/'", "'||'", "'while'", 
			"'do'", "'repeat'", "'until'", "'if'", "'then'", "'else'", "'('", "','", 
			"')'", "'{'", "';'", "'}'", "'skip'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IntType", "BoolType", "UnitType", "Assign", "LessEq", "Eq", "GtrEq", 
			"Less", "Plus", "Minus", "And", "Xor", "Gtr", "Times", "Div", "Or", "While", 
			"Do", "Repeat", "Until", "If", "Then", "Else", "LParen", "Comma", "RParen", 
			"LBrace", "Semicolon", "RBrace", "Skip", "Idfr", "IntLit", "Ignore"
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
	public String getGrammarFileName() { return "AlgorithmANTLR.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AlgorithmANTLRParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class TopLevelContext extends ParserRuleContext {
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public TopLevelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterTopLevel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitTopLevel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitTopLevel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopLevelContext topLevel() throws RecognitionException {
		TopLevelContext _localctx = new TopLevelContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_topLevel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			prog();
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

	public static class ProgContext extends ParserRuleContext {
		public DecContext dec() {
			return getRuleContext(DecContext.class,0);
		}
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_prog);
		try {
			setState(34);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				dec();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				dec();
				setState(32);
				prog();
				}
				break;
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

	public static class DecContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdfrContext idfr() {
			return getRuleContext(IdfrContext.class,0);
		}
		public TerminalNode LParen() { return getToken(AlgorithmANTLRParser.LParen, 0); }
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public TerminalNode RParen() { return getToken(AlgorithmANTLRParser.RParen, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			type();
			setState(37);
			idfr();
			setState(38);
			match(LParen);
			setState(39);
			vardec();
			setState(40);
			match(RParen);
			setState(41);
			block();
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

	public static class VardecContext extends ParserRuleContext {
		public VardecneContext vardecne() {
			return getRuleContext(VardecneContext.class,0);
		}
		public VardecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterVardec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitVardec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitVardec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardecContext vardec() throws RecognitionException {
		VardecContext _localctx = new VardecContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_vardec);
		try {
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				vardecne(0);
				}
				break;
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

	public static class VardecneContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdfrContext idfr() {
			return getRuleContext(IdfrContext.class,0);
		}
		public VardecneContext vardecne() {
			return getRuleContext(VardecneContext.class,0);
		}
		public TerminalNode Comma() { return getToken(AlgorithmANTLRParser.Comma, 0); }
		public VardecneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterVardecne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitVardecne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitVardecne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardecneContext vardecne() throws RecognitionException {
		return vardecne(0);
	}

	private VardecneContext vardecne(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VardecneContext _localctx = new VardecneContext(_ctx, _parentState);
		VardecneContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_vardecne, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				}
				break;
			case 2:
				{
				setState(48);
				type();
				setState(49);
				idfr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(60);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VardecneContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_vardecne);
					setState(53);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(54);
					match(Comma);
					setState(55);
					type();
					setState(56);
					idfr();
					}
					} 
				}
				setState(62);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(AlgorithmANTLRParser.LBrace, 0); }
		public EneContext ene() {
			return getRuleContext(EneContext.class,0);
		}
		public TerminalNode RBrace() { return getToken(AlgorithmANTLRParser.RBrace, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(LBrace);
			setState(64);
			ene();
			setState(65);
			match(RBrace);
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

	public static class EneContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(AlgorithmANTLRParser.Semicolon, 0); }
		public EneContext ene() {
			return getRuleContext(EneContext.class,0);
		}
		public EneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ene; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterEne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitEne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitEne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EneContext ene() throws RecognitionException {
		EneContext _localctx = new EneContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ene);
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				exp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				exp();
				setState(69);
				match(Semicolon);
				setState(70);
				ene();
				}
				break;
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

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhileExprContext extends ExpContext {
		public TerminalNode While() { return getToken(AlgorithmANTLRParser.While, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Do() { return getToken(AlgorithmANTLRParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterWhileExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitWhileExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitWhileExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkipExprContext extends ExpContext {
		public TerminalNode Skip() { return getToken(AlgorithmANTLRParser.Skip, 0); }
		public SkipExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterSkipExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitSkipExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitSkipExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunInvocExprContext extends ExpContext {
		public IdfrContext idfr() {
			return getRuleContext(IdfrContext.class,0);
		}
		public TerminalNode LParen() { return getToken(AlgorithmANTLRParser.LParen, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode RParen() { return getToken(AlgorithmANTLRParser.RParen, 0); }
		public FunInvocExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterFunInvocExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitFunInvocExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitFunInvocExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfExprContext extends ExpContext {
		public TerminalNode If() { return getToken(AlgorithmANTLRParser.If, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Then() { return getToken(AlgorithmANTLRParser.Then, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode Else() { return getToken(AlgorithmANTLRParser.Else, 0); }
		public IfExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterIfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitIfExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitIfExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdExprContext extends ExpContext {
		public IdfrContext idfr() {
			return getRuleContext(IdfrContext.class,0);
		}
		public IdExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RepeatExprContext extends ExpContext {
		public TerminalNode Repeat() { return getToken(AlgorithmANTLRParser.Repeat, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Until() { return getToken(AlgorithmANTLRParser.Until, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public RepeatExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterRepeatExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitRepeatExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitRepeatExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinOpExprContext extends ExpContext {
		public TerminalNode LParen() { return getToken(AlgorithmANTLRParser.LParen, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public BinopContext binop() {
			return getRuleContext(BinopContext.class,0);
		}
		public TerminalNode RParen() { return getToken(AlgorithmANTLRParser.RParen, 0); }
		public BinOpExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterBinOpExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitBinOpExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitBinOpExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntExprContext extends ExpContext {
		public IntlitContext intlit() {
			return getRuleContext(IntlitContext.class,0);
		}
		public IntExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterIntExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitIntExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitIntExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AsgmtExprContext extends ExpContext {
		public IdfrContext idfr() {
			return getRuleContext(IdfrContext.class,0);
		}
		public TerminalNode Assign() { return getToken(AlgorithmANTLRParser.Assign, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AsgmtExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterAsgmtExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitAsgmtExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitAsgmtExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockExprContext extends ExpContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterBlockExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitBlockExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitBlockExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exp);
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new IdExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				idfr();
				}
				break;
			case 2:
				_localctx = new IntExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				intlit();
				}
				break;
			case 3:
				_localctx = new AsgmtExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				idfr();
				setState(77);
				match(Assign);
				setState(78);
				exp();
				}
				break;
			case 4:
				_localctx = new BinOpExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				match(LParen);
				setState(81);
				exp();
				setState(82);
				binop();
				setState(83);
				exp();
				setState(84);
				match(RParen);
				}
				break;
			case 5:
				_localctx = new FunInvocExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(86);
				idfr();
				setState(87);
				match(LParen);
				setState(88);
				args();
				setState(89);
				match(RParen);
				}
				break;
			case 6:
				_localctx = new BlockExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(91);
				block();
				}
				break;
			case 7:
				_localctx = new IfExprContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(92);
				match(If);
				setState(93);
				exp();
				setState(94);
				match(Then);
				setState(95);
				block();
				setState(96);
				match(Else);
				setState(97);
				block();
				}
				break;
			case 8:
				_localctx = new WhileExprContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(99);
				match(While);
				setState(100);
				exp();
				setState(101);
				match(Do);
				setState(102);
				block();
				}
				break;
			case 9:
				_localctx = new RepeatExprContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(104);
				match(Repeat);
				setState(105);
				block();
				setState(106);
				match(Until);
				setState(107);
				exp();
				}
				break;
			case 10:
				_localctx = new SkipExprContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(109);
				match(Skip);
				}
				break;
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

	public static class ArgsContext extends ParserRuleContext {
		public ArgsneContext argsne() {
			return getRuleContext(ArgsneContext.class,0);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_args);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RParen:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case While:
			case Repeat:
			case If:
			case LParen:
			case LBrace:
			case Skip:
			case Idfr:
			case IntLit:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				argsne(0);
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

	public static class ArgsneContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ArgsneContext argsne() {
			return getRuleContext(ArgsneContext.class,0);
		}
		public TerminalNode Comma() { return getToken(AlgorithmANTLRParser.Comma, 0); }
		public ArgsneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argsne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterArgsne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitArgsne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitArgsne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsneContext argsne() throws RecognitionException {
		return argsne(0);
	}

	private ArgsneContext argsne(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgsneContext _localctx = new ArgsneContext(_ctx, _parentState);
		ArgsneContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_argsne, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(117);
			exp();
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgsneContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_argsne);
					setState(119);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(120);
					match(Comma);
					setState(121);
					exp();
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class BinopContext extends ParserRuleContext {
		public TerminalNode Assign() { return getToken(AlgorithmANTLRParser.Assign, 0); }
		public TerminalNode LessEq() { return getToken(AlgorithmANTLRParser.LessEq, 0); }
		public TerminalNode Eq() { return getToken(AlgorithmANTLRParser.Eq, 0); }
		public TerminalNode GtrEq() { return getToken(AlgorithmANTLRParser.GtrEq, 0); }
		public TerminalNode Less() { return getToken(AlgorithmANTLRParser.Less, 0); }
		public TerminalNode Plus() { return getToken(AlgorithmANTLRParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(AlgorithmANTLRParser.Minus, 0); }
		public TerminalNode And() { return getToken(AlgorithmANTLRParser.And, 0); }
		public TerminalNode Xor() { return getToken(AlgorithmANTLRParser.Xor, 0); }
		public TerminalNode Gtr() { return getToken(AlgorithmANTLRParser.Gtr, 0); }
		public TerminalNode Times() { return getToken(AlgorithmANTLRParser.Times, 0); }
		public TerminalNode Div() { return getToken(AlgorithmANTLRParser.Div, 0); }
		public TerminalNode Or() { return getToken(AlgorithmANTLRParser.Or, 0); }
		public BinopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitBinop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinopContext binop() throws RecognitionException {
		BinopContext _localctx = new BinopContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_binop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Assign) | (1L << LessEq) | (1L << Eq) | (1L << GtrEq) | (1L << Less) | (1L << Plus) | (1L << Minus) | (1L << And) | (1L << Xor) | (1L << Gtr) | (1L << Times) | (1L << Div) | (1L << Or))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode IntType() { return getToken(AlgorithmANTLRParser.IntType, 0); }
		public TerminalNode BoolType() { return getToken(AlgorithmANTLRParser.BoolType, 0); }
		public TerminalNode UnitType() { return getToken(AlgorithmANTLRParser.UnitType, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << UnitType))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class IdfrContext extends ParserRuleContext {
		public TerminalNode Idfr() { return getToken(AlgorithmANTLRParser.Idfr, 0); }
		public IdfrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idfr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterIdfr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitIdfr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitIdfr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdfrContext idfr() throws RecognitionException {
		IdfrContext _localctx = new IdfrContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_idfr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(Idfr);
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

	public static class IntlitContext extends ParserRuleContext {
		public TerminalNode IntLit() { return getToken(AlgorithmANTLRParser.IntLit, 0); }
		public IntlitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intlit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).enterIntlit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlgorithmANTLRListener ) ((AlgorithmANTLRListener)listener).exitIntlit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlgorithmANTLRVisitor ) return ((AlgorithmANTLRVisitor<? extends T>)visitor).visitIntlit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntlitContext intlit() throws RecognitionException {
		IntlitContext _localctx = new IntlitContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_intlit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(IntLit);
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
		case 4:
			return vardecne_sempred((VardecneContext)_localctx, predIndex);
		case 9:
			return argsne_sempred((ArgsneContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean vardecne_sempred(VardecneContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean argsne_sempred(ArgsneContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u008a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\3\3\3\5\3%\n"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\5\5\60\n\5\3\6\3\6\3\6\3\6\5\6"+
		"\66\n\6\3\6\3\6\3\6\3\6\3\6\7\6=\n\6\f\6\16\6@\13\6\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\5\bK\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tq\n\t\3\n\3\n\5\nu\n\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\7\13}\n\13\f\13\16\13\u0080\13\13\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\17\2\4\n\24\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\2\4\3\2\6\22\3\2\3\5\2\u008b\2\36\3\2\2\2\4$\3\2\2\2\6&\3\2\2\2\b/\3"+
		"\2\2\2\n\65\3\2\2\2\fA\3\2\2\2\16J\3\2\2\2\20p\3\2\2\2\22t\3\2\2\2\24"+
		"v\3\2\2\2\26\u0081\3\2\2\2\30\u0083\3\2\2\2\32\u0085\3\2\2\2\34\u0087"+
		"\3\2\2\2\36\37\5\4\3\2\37\3\3\2\2\2 %\5\6\4\2!\"\5\6\4\2\"#\5\4\3\2#%"+
		"\3\2\2\2$ \3\2\2\2$!\3\2\2\2%\5\3\2\2\2&\'\5\30\r\2\'(\5\32\16\2()\7\32"+
		"\2\2)*\5\b\5\2*+\7\34\2\2+,\5\f\7\2,\7\3\2\2\2-\60\3\2\2\2.\60\5\n\6\2"+
		"/-\3\2\2\2/.\3\2\2\2\60\t\3\2\2\2\61\66\b\6\1\2\62\63\5\30\r\2\63\64\5"+
		"\32\16\2\64\66\3\2\2\2\65\61\3\2\2\2\65\62\3\2\2\2\66>\3\2\2\2\678\f\3"+
		"\2\289\7\33\2\29:\5\30\r\2:;\5\32\16\2;=\3\2\2\2<\67\3\2\2\2=@\3\2\2\2"+
		"><\3\2\2\2>?\3\2\2\2?\13\3\2\2\2@>\3\2\2\2AB\7\35\2\2BC\5\16\b\2CD\7\37"+
		"\2\2D\r\3\2\2\2EK\5\20\t\2FG\5\20\t\2GH\7\36\2\2HI\5\16\b\2IK\3\2\2\2"+
		"JE\3\2\2\2JF\3\2\2\2K\17\3\2\2\2Lq\5\32\16\2Mq\5\34\17\2NO\5\32\16\2O"+
		"P\7\6\2\2PQ\5\20\t\2Qq\3\2\2\2RS\7\32\2\2ST\5\20\t\2TU\5\26\f\2UV\5\20"+
		"\t\2VW\7\34\2\2Wq\3\2\2\2XY\5\32\16\2YZ\7\32\2\2Z[\5\22\n\2[\\\7\34\2"+
		"\2\\q\3\2\2\2]q\5\f\7\2^_\7\27\2\2_`\5\20\t\2`a\7\30\2\2ab\5\f\7\2bc\7"+
		"\31\2\2cd\5\f\7\2dq\3\2\2\2ef\7\23\2\2fg\5\20\t\2gh\7\24\2\2hi\5\f\7\2"+
		"iq\3\2\2\2jk\7\25\2\2kl\5\f\7\2lm\7\26\2\2mn\5\20\t\2nq\3\2\2\2oq\7 \2"+
		"\2pL\3\2\2\2pM\3\2\2\2pN\3\2\2\2pR\3\2\2\2pX\3\2\2\2p]\3\2\2\2p^\3\2\2"+
		"\2pe\3\2\2\2pj\3\2\2\2po\3\2\2\2q\21\3\2\2\2ru\3\2\2\2su\5\24\13\2tr\3"+
		"\2\2\2ts\3\2\2\2u\23\3\2\2\2vw\b\13\1\2wx\5\20\t\2x~\3\2\2\2yz\f\3\2\2"+
		"z{\7\33\2\2{}\5\20\t\2|y\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2"+
		"\177\25\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\t\2\2\2\u0082\27\3\2\2\2\u0083"+
		"\u0084\t\3\2\2\u0084\31\3\2\2\2\u0085\u0086\7!\2\2\u0086\33\3\2\2\2\u0087"+
		"\u0088\7\"\2\2\u0088\35\3\2\2\2\n$/\65>Jpt~";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}