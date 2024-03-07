package expressivo;

import java.util.Objects;

public class Addition implements Expression{

    private final Expression leftExpression;
    private final Expression rightExpression;
    private Expression ex;


    /**
     *
     * AF:
     *    AF(leftExpression, rightExpression) = leftExpression + rightExpression
     *
     * RI:
     *    leftExpression and rightExpression are instance of Expression
     *
     * Rep Exposure:
     *     the leftExpression and rightExpression are immutable
     *
     */

    public Addition(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }



    public void checkRep(){
        assert (this.leftExpression != null);
        assert (this.rightExpression != null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Addition addition = (Addition) o;
        return Objects.equals(leftExpression, addition.leftExpression) && Objects.equals(rightExpression, addition.rightExpression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftExpression, rightExpression);
    }

    @Override
    public String toString() {
        return leftExpression.toString() + "+" + rightExpression.toString();
    }

    @Override
    public Expression differentiate(Variable var) {
        return new Addition(leftExpression.differentiate(var),rightExpression.differentiate(var));
    }

    @Override
    public Expression simplify(Variable var, Double value) {
        return new Addition(leftExpression.simplify(var,value),rightExpression.simplify(var,value));
    }
}
