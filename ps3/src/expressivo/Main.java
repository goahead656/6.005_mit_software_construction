/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package expressivo;

import expressivo.parser.ExpressionLexer;
import expressivo.parser.ExpressionListener;
import expressivo.parser.ExpressionParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.Literal;

/**
 * Console interface to the expression system.
 *
 * <p>PS3 instructions: you are free to change this user interface class.
 */
public class Main {

    /**
     * Read expression and command inputs from the console and output results.
     * An empty input terminates the program.
     * @param args unused
     * @throws IOException if there is an error reading the input
     */
    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Optional<Expression> currentExpression = Optional.empty();

        while (true) {
            System.out.print("> ");
            final String input = in.readLine();

            if (input.isEmpty()) {
                return; // exits the program
            }

            try {
                final String output;

                if (input.startsWith(DIFFERENTIATE_PREFIX)) {
                    final String variable = parseDifferentiate(input);
                    System.out.println(variable);
//                    output = Commands.differentiate(currentExpression.get(), variable);
//                    currentExpression = Optional.of(output);
                } else if (input.startsWith(SIMPLIFY_PREFIX)) {
                    final Map<String,Double> environment = parseSimpify(input);
//                    output = Commands.simplify(currentExpression.get(), environment);
                    // ... but don't change currentExpression
                } else {
                    final Expression expression = parse(input);
                    double value = expression.value();
                    output = expression.toString();
                    System.out.println(output);
                    System.out.println(value);
//                    currentExpression = Optional.of(output);
                }

//                System.out.println(output);
            } catch (NoSuchElementException nse) {
                // currentExpression was empty
                System.out.println("must enter an expression before using this command");
            } catch (RuntimeException re) {
                System.out.println(re.getClass().getName() + ": " + re.getMessage());
            }
        }
    }

    public static Expression parse(String input){
        // Create a stream of characters from the string
        CharStream stream = new ANTLRInputStream(input);

        // Make a parser
        ExpressionParser parser = makeParser(stream);

        // Generate the parse tree using the starter rule.
        // root is the starter rule for this grammar.
        // Other grammars may have different names for the starter rule.
        ParseTree tree = parser.root();


        // *** Debugging option #1: print the tree to the console
        System.err.println(tree.toStringTree(parser));

        // *** Debugging option #2: show the tree in a window
        Trees.inspect(tree, parser);

        // *** Debugging option #3: walk the tree with a listener
//        new ParseTreeWalker().walk(new PrintEverything(), tree);

        MakeExpression exprMaker = new MakeExpression();
        new ParseTreeWalker().walk(exprMaker, tree);
        return exprMaker.getExpression();
    }

    private static ExpressionParser makeParser(CharStream stream) {
        // Make a lexer.  This converts the stream of characters into a
        // stream of tokens.  A token is a character group, like "<i>"
        // or "</i>".  Note that this doesn't start reading the character stream yet,
        // it just sets up the lexer to read it.
        ExpressionLexer lexer = new ExpressionLexer(stream);
        lexer.reportErrorsAsExceptions();
        TokenStream tokens = new CommonTokenStream(lexer);

        // Make a parser whose input comes from the token stream produced by the lexer.
        ExpressionParser parser = new ExpressionParser(tokens);
        parser.reportErrorsAsExceptions();

        return parser;
    }


    private static final String DIFFERENTIATE_PREFIX = "!d/d";
    private static final String VARIABLE = "[A-Za-z]+";
    private static final String DIFFERENTIATE = DIFFERENTIATE_PREFIX + "(" + VARIABLE + ") *";

    private static String parseDifferentiate(final String input) {
        final Matcher commandMatcher = Pattern.compile(DIFFERENTIATE).matcher(input);
        if (!commandMatcher.matches()) {
            throw new CommandSyntaxException("usage: !d/d must be followed by a variable name");
        }

        final String variable = commandMatcher.group(1);
        return variable;
    }

    private static final String SIMPLIFY_PREFIX = "!simplify";
    private static final String ASSIGNMENT = "(" + VARIABLE + ") *= *([^ ]+)";
    private static final String SIMPLIFY = SIMPLIFY_PREFIX + "( +" + ASSIGNMENT + ")* *";

    private static Map<String,Double> parseSimpify(final String input) {
        final Matcher commandMatcher = Pattern.compile(SIMPLIFY).matcher(input);
        if (!commandMatcher.matches()) {
            throw new CommandSyntaxException("usage: !simplify var1=val1 var2=val2 ...");
        }

        final Map<String,Double> environment = new HashMap<>();
        final Matcher argumentMatcher = Pattern.compile(ASSIGNMENT).matcher(input);
        while (argumentMatcher.find()) {
            final String variable = argumentMatcher.group(1);
            final double value = Double.valueOf(argumentMatcher.group(2));
            environment.put(variable, value);
        }

        // un-comment the following line to print the environment after each !simplify command
        //System.out.println(environment);
        return environment;
    }

    public static class CommandSyntaxException extends RuntimeException {
        private static final long serialVersionUID = 1;
        public CommandSyntaxException(String message) {
            super(message);
        }
    }
}


///** Print out parse tree nodes to System.err as they are visited. */
//class PrintEverything implements ExpressionListener {
//
//    @Override public void enterRoot(ExpressionParser.RootContext context) {
//        System.err.println("entering root");
//    }
//    @Override public void exitRoot(ExpressionParser.RootContext context) {
//        System.err.println("exiting root");
//    }
//
//    @Override
//    public void enterAddOrSub(ExpressionParser.AddOrSubContext ctx) {
//        System.err.println("entering addOrSub");
//    }
//
//    @Override
//    public void exitAddOrSub(ExpressionParser.AddOrSubContext ctx) {
//        System.err.println("exiting addOrSub");
//    }
//
//    @Override
//    public void enterSingle(ExpressionParser.SingleContext ctx) {
//        System.err.println("entering single");
//    }
//
//    @Override
//    public void exitSingle(ExpressionParser.SingleContext ctx) {
//        System.err.println("exiting single");
//    }
//
//    @Override
//    public void enterLieteral(ExpressionParser.LieteralContext ctx) {
//        System.err.println("entering literal");
//    }
//
//    @Override
//    public void exitLieteral(ExpressionParser.LieteralContext ctx) {
//        System.err.println("exiting literal");
//    }
//
//    @Override
//    public void enterMultiOrDiv(ExpressionParser.MultiOrDivContext ctx) {
//        System.err.println("entering multiOrDiv");
//    }
//
//    @Override
//    public void exitMultiOrDiv(ExpressionParser.MultiOrDivContext ctx) {
//        System.err.println("exiting multiOrDiv");
//    }
//
//
//    @Override public void visitTerminal(TerminalNode terminal) {
//        System.err.println("terminal " + terminal.getText());
//    }
//
//    // don't need these here, so just make them empty implementations
//    @Override public void enterEveryRule(ParserRuleContext context) { }
//    @Override public void exitEveryRule(ParserRuleContext context) { }
//    @Override public void visitErrorNode(ErrorNode node) { }
//}

class MakeExpression implements ExpressionListener {
    private Stack<Expression> stack = new Stack<>();
    private Stack<String> operatorStack = new Stack<>();
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
    public Expression getExpression() {
        return stack.get(0);
    }

    @Override public void exitRoot(ExpressionParser.RootContext context) {
        // do nothing, root has only one child so its value is
        // already on top of the stack
    }

    @Override
    public void enterAddOrSub(ExpressionParser.AddOrSubContext ctx) {
        System.out.println("entering addOrSub");

//        System.out.println(ctx.getText());
    }

    @Override
    public void exitAddOrSub(ExpressionParser.AddOrSubContext ctx) {
        System.out.println("ctx length"+ctx.getText().length());
        System.out.println("ctx content"+ctx.getText());
        String operator = ctx.getChild(1).getText();
        System.out.println("operator"+operator);

        List<ExpressionParser.ExprContext> expr = ctx.expr();
//        Expression right = stack.pop();
//        Expression left = stack.pop();
//        for(int i=0;i<expr.size();i++){
//            System.out.print(expr.get(i).getText());
//        }
//        System.out.println();
        assert stack.size() >= expr.size();

        // the pattern above always has at least 1 child;
        // pop the last child
        assert expr.size() > 0;
        Expression sum = stack.pop();
        if(operator.equals("+")) {
            sum = new Addition(stack.pop(), sum);
        }else{
            sum = new Subtraction(stack.pop(), sum);
        }

        // pop the older children, one by one, and add them on
//        for (int i = 1; i < expr.size(); ++i) {
//            sum = new Addition(stack.pop(), sum);
//        }

        // the result is this subtree's IntegerExpression
        stack.push(sum);
        System.out.println("exiting addOrSub");
    }

    @Override
    public void enterSingle(ExpressionParser.SingleContext ctx) {
        // do nothing
        System.out.println("entering single");
    }

    @Override
    public void exitSingle(ExpressionParser.SingleContext ctx) {
        // do nothing
        System.out.println("exiting single");
        System.out.println(ctx.getText());
//        stack.push(new Constant(Double.valueOf(ctx.getText())));
    }

    @Override
    public void enterLieteral(ExpressionParser.LieteralContext ctx) {
        // do nothing
        System.out.println("entering literal");
    }

    @Override
    public void exitLieteral(ExpressionParser.LieteralContext ctx) {
        // do nothing
        System.out.println(ctx.getText());
        System.out.println("exiting literal");
        stack.push(new Constant(Double.valueOf(ctx.getText())));
    }

    @Override
    public void enterMultiOrDiv(ExpressionParser.MultiOrDivContext ctx) {
        // do nothing
        System.out.println("entering multiOrDiv");
    }

    @Override
    public void exitMultiOrDiv(ExpressionParser.MultiOrDivContext ctx) {
        // do nothing
        List<ExpressionParser.ExprContext> expr = ctx.expr();
        assert stack.size() >= expr.size();

        String operator = ctx.getChild(1).getText();
        System.out.println("operator"+operator);

        // the pattern above always has at least 1 child;
        // pop the last child
        assert expr.size() > 0;
        Expression multiplicate = stack.pop();

        if(operator.equals("*")) {
            multiplicate = new Multiplication(stack.pop(), multiplicate);
        }else{
            multiplicate = new Division(stack.pop(), multiplicate);
        }

        // the result is this subtree's IntegerExpression
        stack.push(multiplicate);
        System.out.println("exiting multiOrDiv");
    }


    // don't need these here, so just make them empty implementations
    @Override public void enterRoot(ExpressionParser.RootContext context) { }


    @Override public void visitTerminal(TerminalNode terminal) { }
    @Override public void enterEveryRule(ParserRuleContext context) { }
    @Override public void exitEveryRule(ParserRuleContext context) { }
    @Override public void visitErrorNode(ErrorNode node) { }
}