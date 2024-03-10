// Generated from ..\src\expressivo\parser\Expression.g4 by ANTLR 4.5.1

package expressivo.parser;
// Do not edit this .java file! Edit the grammar in Expression.g4 and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionParser}.
 */
public interface ExpressionListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link ExpressionParser#root}.
   * @param ctx the parse tree
   */
  void enterRoot(ExpressionParser.RootContext ctx);
  /**
   * Exit a parse tree produced by {@link ExpressionParser#root}.
   * @param ctx the parse tree
   */
  void exitRoot(ExpressionParser.RootContext ctx);
  /**
   * Enter a parse tree produced by the {@code AddOrSub}
   * labeled alternative in {@link ExpressionParser#expr}.
   * @param ctx the parse tree
   */
  void enterAddOrSub(ExpressionParser.AddOrSubContext ctx);
  /**
   * Exit a parse tree produced by the {@code AddOrSub}
   * labeled alternative in {@link ExpressionParser#expr}.
   * @param ctx the parse tree
   */
  void exitAddOrSub(ExpressionParser.AddOrSubContext ctx);
  /**
   * Enter a parse tree produced by the {@code Single}
   * labeled alternative in {@link ExpressionParser#expr}.
   * @param ctx the parse tree
   */
  void enterSingle(ExpressionParser.SingleContext ctx);
  /**
   * Exit a parse tree produced by the {@code Single}
   * labeled alternative in {@link ExpressionParser#expr}.
   * @param ctx the parse tree
   */
  void exitSingle(ExpressionParser.SingleContext ctx);
  /**
   * Enter a parse tree produced by the {@code Lieteral}
   * labeled alternative in {@link ExpressionParser#expr}.
   * @param ctx the parse tree
   */
  void enterLieteral(ExpressionParser.LieteralContext ctx);
  /**
   * Exit a parse tree produced by the {@code Lieteral}
   * labeled alternative in {@link ExpressionParser#expr}.
   * @param ctx the parse tree
   */
  void exitLieteral(ExpressionParser.LieteralContext ctx);
  /**
   * Enter a parse tree produced by the {@code MultiOrDiv}
   * labeled alternative in {@link ExpressionParser#expr}.
   * @param ctx the parse tree
   */
  void enterMultiOrDiv(ExpressionParser.MultiOrDivContext ctx);
  /**
   * Exit a parse tree produced by the {@code MultiOrDiv}
   * labeled alternative in {@link ExpressionParser#expr}.
   * @param ctx the parse tree
   */
  void exitMultiOrDiv(ExpressionParser.MultiOrDivContext ctx);
}