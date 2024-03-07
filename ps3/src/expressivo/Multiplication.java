package expressivo;

import java.util.Objects;

public class Multiplication<L> implements Expression<L>{
    private final Expression<L> leftExpression;
    private final Expression<L> rightExpression;
    private Expression<L> ex;


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

    public Multiplication(Expression<L> leftExpression, Expression<L> rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public void checkRep(){
        assert (this.leftExpression instanceof Expression);
        assert (this.rightExpression instanceof Expression);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Multiplication that = (Multiplication) o;
        return Objects.equals(leftExpression, that.leftExpression) && Objects.equals(rightExpression, that.rightExpression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftExpression, rightExpression);
    }

    @Override
    public String toString() {
        return leftExpression.toString() + "*" + rightExpression.toString();
    }

    @Override
    public Expression<L> differentiate(Variable var) {
        return new Addition(new Multiplication(leftExpression.differentiate(var),rightExpression),
                            new Multiplication(leftExpression,rightExpression.differentiate(var)));
    }

    @Override
    public Expression<L> simplify(Variable var, Double value) {
        return new Multiplication(leftExpression.simplify(var,value),rightExpression.simplify(var,value));
    }
}
