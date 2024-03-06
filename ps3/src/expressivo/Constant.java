package expressivo;

import java.util.Objects;

public class Constant implements Expression{
    private final Double value;

    /**
     * AF:
     * AF(non-negative number) = a non-negative number,e.g. , 1,1.2
     * RI:
     *   non-negative numbers,ranging from 0 to max
     *
     *
     */

    public Constant(Double value) {
        this.value = value;
    }

    public void checkRep(){
        assert this.value > 0;
    }

    public static Expression parse(String input) throws Exception{
        throw new Exception("not implemented");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constant constant = (Constant) o;
        return Objects.equals(value, constant.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }



    @Override
    public Expression differentiate(Variable var) {
        return new Constant(0.0);
    }

    @Override
    public Expression simplify(Variable var, Double value) {
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }


}
