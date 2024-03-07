package expressivo;

import java.util.Objects;

public class ExpressionImple<L> implements Expression<L>{

    private final String expression;

    public ExpressionImple(String expression) {
        this.expression = expression;
    }

    public static Expression parse(String expression){
        char[] chars = expression.toCharArray();
        Boolean addition_flag = false;
        Boolean Multiply_flag = false;
        for(int i=0; i < chars.length; i++){
            System.out.println(chars[i]);
        }
        Character pre_char;
        Character late_char;


//        for(int i=0; i<split.length; i++){
//            if(split[i] >= "0" && split[i] <= "9"){
//
//            }
//            else{
//
//            }
//        }
        return new ExpressionImple("111");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpressionImple that = (ExpressionImple) o;
        return Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression);
    }

    @Override
    public Expression differentiate(Variable var) {
        return null;
    }

    @Override
    public Expression simplify(Variable var, Double value) {
        return null;
    }

    @Override
    public String toString() {
        return "ExpressionImple{" +
                "expression='" + expression + '\'' +
                '}';
    }


}
