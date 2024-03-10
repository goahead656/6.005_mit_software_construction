// Generated from D:/code_file/JAVA/6.005_mit_software_construction/sp16-ex18-parser-generators/src/intexpr/parser/IntegerExpression.g4 by ANTLR 4.13.1
package intexpr.parser;

package intexpr.parser;
// Do not edit this .java file! Edit the grammar in IntegerExpression.g4 and re-run Antlr.

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link IntegerExpressionVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
@SuppressWarnings("CheckReturnValue")
public class IntegerExpressionBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements IntegerExpressionVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitRoot(IntegerExpressionParser.RootContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSum(IntegerExpressionParser.SumContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitPrimitive(IntegerExpressionParser.PrimitiveContext ctx) { return visitChildren(ctx); }
}