/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package expressivo;

import expressivo.parser.ExpressionLexer;
import expressivo.parser.ExpressionListener;
import expressivo.parser.ExpressionParser;
import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.sound.midi.Soundbank;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

/**
 * An immutable data type representing a polynomial expression of:
 *   + and *
 *   nonnegative integers and floating-point numbers
 *   variables (case-sensitive nonempty strings of letters)
 * 
 * <p>PS3 instructions: this is a required ADT interface.
 * You MUST NOT change its name or package or the names or type signatures of existing methods.
 * You may, however, add additional methods, or strengthen the specs of existing methods.
 * Declare concrete variants of Expression in their own Java source files.
 */
public interface Expression {
    
    // Datatype definition
    //   TODO

    /**
     * Expression = Constant(Double) +
     *              Variable(String) +
     *              Addition(leftExpr, rightExpr) +
     *              Multiplication(leftExpr, rightExpr)
     *
     *  Safty from rep exposure:
     *  All fields are immutable
     *
     */


    /**
     * Parse an expression.
     * @param input expression to parse, as defined in the PS3 handout.
     * @return expression AST for the input
     * @throws IllegalArgumentException if the expression is invalid
     */

    
    /**
     * @return a parsable representation of this expression, such that
     * for all e:Expression, e.equals(Expression.parse(e.toString())).
     */
    @Override 
    public String toString();

    /**
     * @param thatObject any object
     * @return true if and only if this and thatObject are structurally-equal
     * Expressions, as defined in the PS3 handout.
     */
    @Override
    public boolean equals(Object thatObject);
    
    /**
     * @return hash code value consistent with the equals() definition of structural
     * equality, such that for all e1,e2:Expression,
     *     e1.equals(e2) implies e1.hashCode() == e2.hashCode()
     */
    @Override
    public int hashCode();
    
    // TODO more instance methods

    public double value();

//    /**
//     * differentiation operarion of the expression towards
//     * @param var: a variable of which the expression derivate
//     * @return:
//     *      the derivative expression
//     */
//    public Expression<L> differentiate(Variable var);
//
//    /**
//     * Simplifying a expression with the variable. evaluate the expression with the variable.
//     *
//     * @param var: any variable, either appears in the expression or not
//     * @param value: the value of the variable
//     * @return Evaluated expression
//     */
//    public Expression<L> simplify(Variable var, Double value);
}



