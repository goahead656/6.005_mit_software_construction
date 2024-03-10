package intexpr;

import java.util.List;
import java.util.Stack;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import intexpr.parser.IntegerExpressionLexer;
import intexpr.parser.IntegerExpressionListener;
import intexpr.parser.IntegerExpressionParser;

public class Main {
 
    public static void main(String[] args) {
//        String input = "54+(2+89)";
        String input = "3+3";
        IntegerExpression expr = parse(input);
        int value = expr.value();
        System.out.println(input + "=" + expr + "=" + value);
    }

    /**
     * Parse a string into an integer arithmetic expression, displaying various
     * debugging output.
     */
    public static IntegerExpression parse(String string) {
       // Create a stream of characters from the string
       CharStream stream = new ANTLRInputStream(string);

       // Make a parser
       IntegerExpressionParser parser = makeParser(stream);
       
       // Generate the parse tree using the starter rule.
       // root is the starter rule for this grammar.
       // Other grammars may have different names for the starter rule.
       ParseTree tree = parser.root();

       // *** Debugging option #1: print the tree to the console
       System.err.println(tree.toStringTree(parser));

       // *** Debugging option #2: show the tree in a window
       Trees.inspect(tree, parser);
       
       // *** Debugging option #3: walk the tree with a listener
       new ParseTreeWalker().walk(new PrintEverything(), tree);
       
       MakeIntegerExpression exprMaker = new MakeIntegerExpression();
       new ParseTreeWalker().walk(exprMaker, tree);
       return exprMaker.getExpression();
   }

    
    /**
     * Make a parser that is ready to parse a stream of characters.
     * To start parsing, the client should call a method on the returned parser
     * corresponding to the start rule of the grammar, e.g. parser.root() or
     * whatever it happens to be.
     * During parsing, if the parser encounters a syntax error, it will throw a
     * ParseCancellationException.
     * @param stream stream of characters
     * @return a parser that is ready to parse the stream
     */
    private static IntegerExpressionParser makeParser(CharStream stream) {
        // Make a lexer.  This converts the stream of characters into a 
        // stream of tokens.  A token is a character group, like "<i>"
        // or "</i>".  Note that this doesn't start reading the character stream yet,
        // it just sets up the lexer to read it.
        IntegerExpressionLexer lexer = new IntegerExpressionLexer(stream);
        lexer.reportErrorsAsExceptions();
        TokenStream tokens = new CommonTokenStream(lexer);
        
        // Make a parser whose input comes from the token stream produced by the lexer.
        IntegerExpressionParser parser = new IntegerExpressionParser(tokens);
        parser.reportErrorsAsExceptions();
        
        return parser;
    }
}

/** Print out parse tree nodes to System.err as they are visited. */
class PrintEverything implements IntegerExpressionListener {
    
    @Override public void enterRoot(IntegerExpressionParser.RootContext context) {
        System.err.println("entering root");
    }
    @Override public void exitRoot(IntegerExpressionParser.RootContext context) {
        System.err.println("exiting root");
    }

    @Override public void enterSum(IntegerExpressionParser.SumContext context) {
        System.err.println("entering sum");
    }
    @Override public void exitSum(IntegerExpressionParser.SumContext context) {
        System.err.println("exiting sum");
    }

    @Override public void enterPrimitive(IntegerExpressionParser.PrimitiveContext context) {
        System.err.println("entering primitive");
    }
    @Override public void exitPrimitive(IntegerExpressionParser.PrimitiveContext context) {
        System.err.println("exiting primitive");
    }

    @Override public void visitTerminal(TerminalNode terminal) {
        System.err.println("terminal " + terminal.getText());            
    }
    
    // don't need these here, so just make them empty implementations
    @Override public void enterEveryRule(ParserRuleContext context) { }
    @Override public void exitEveryRule(ParserRuleContext context) { }
    @Override public void visitErrorNode(ErrorNode node) { }         
}

/** Make a IntegerExpresion value from a parse tree. */
class MakeIntegerExpression implements IntegerExpressionListener {
    private Stack<IntegerExpression> stack = new Stack<>();
    // Invariant: stack contains the IntegerExpression value of each parse
    // subtree that has been fully-walked so far, but whose parent has not yet
    // been exited by the walk. The stack is ordered by recency of visit, so that
    // the top of the stack is the IntegerExpression for the most recently walked
    // subtree.
    //
    // At the start of the walk, the stack is empty, because no subtrees have
    // been fully walked.
    //
    // Whenever a node is exited by the walk, the IntegerExpression values of its
    // children are on top of the stack, in order with the last child on top. To
    // preserve the invariant, we must pop those child IntegerExpression values
    // from the stack, combine them with the appropriate IntegerExpression
    // producer, and push back an IntegerExpression value representing the entire
    // subtree under the node.
    //
    // At the end of the walk, after all subtrees have been walked and the the
    // root has been exited, only the entire tree satisfies the invariant's
    // "fully walked but parent not yet exited" property, so the top of the stack
    // is the IntegerExpression of the entire parse tree.
    
    /**
     * Returns the expression constructed by this listener object.
     * Requires that this listener has completely walked over an IntegerExpression
     * parse tree using ParseTreeWalker.
     * @return IntegerExpression for the parse tree that was walked
     */
    public IntegerExpression getExpression() {
        return stack.get(0);
    }
    
    @Override public void exitRoot(IntegerExpressionParser.RootContext context) {
        // do nothing, root has only one child so its value is 
        // already on top of the stack
    }

    @Override public void exitSum(IntegerExpressionParser.SumContext context) {  
        // matched the primitive ('+' primitive)* rule
        List<IntegerExpressionParser.PrimitiveContext> addends = context.primitive();
        assert stack.size() >= addends.size();
        
        // the pattern above always has at least 1 child;
        // pop the last child
        assert addends.size() > 0;
        IntegerExpression sum = stack.pop();
        
        // pop the older children, one by one, and add them on
        for (int i = 1; i < addends.size(); ++i) {
            sum = new Plus(stack.pop(), sum);
        }
        
        // the result is this subtree's IntegerExpression
        stack.push(sum);
    }

    @Override public void exitPrimitive(IntegerExpressionParser.PrimitiveContext context) {
        if (context.NUMBER() != null) {
            // matched the NUMBER alternative
            int n = Integer.valueOf(context.NUMBER().getText());
            IntegerExpression number = new Number(n);
            stack.push(number);
        } else {
            // matched the '(' sum ')' alternative
            // do nothing, because sum's value is already on the stack
        }
    }

    // don't need these here, so just make them empty implementations
    @Override public void enterRoot(IntegerExpressionParser.RootContext context) { }
    @Override public void enterSum(IntegerExpressionParser.SumContext context) { }
    @Override public void enterPrimitive(IntegerExpressionParser.PrimitiveContext context) { }

    @Override public void visitTerminal(TerminalNode terminal) { }
    @Override public void enterEveryRule(ParserRuleContext context) { }
    @Override public void exitEveryRule(ParserRuleContext context) { }
    @Override public void visitErrorNode(ErrorNode node) { }         
}

