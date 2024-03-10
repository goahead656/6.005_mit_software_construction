package expressivo;

import java.util.Objects;

public class Subtraction implements Expression{
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

    public Subtraction(Expression leftExpression, Expression rightExpression) {
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
        Subtraction that = (Subtraction) o;
        return Objects.equals(leftExpression, that.leftExpression) && Objects.equals(rightExpression, that.rightExpression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftExpression, rightExpression);
    }

    @Override
    public double value() {
        return leftExpression.value() - rightExpression.value();
    }

    @Override
    public String toString() {
        return leftExpression.toString() + "-" + rightExpression.toString();
    }
}
