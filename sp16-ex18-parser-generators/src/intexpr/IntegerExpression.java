package intexpr;

/** Immutable type representing an integer arithmetic expression. */
public interface IntegerExpression {
    // Data type definition (abbreviated IntExpr)
    //    IntExpr = Number(n:int) + Plus(left:IntExpr, right:IntExpr)
    
    /** @return the computed value of this expression */
    public int value();
}

class Number implements IntegerExpression {
    private final int n;
    
    // Abstraction function
    //    represents the integer n
    // Rep invariant
    //    true
    // Safety from rep exposure
    //    all fields are immutable and final
    
    /** Make a Number. */
    public Number(int n) {
        this.n = n;
    }
    
    @Override public int value() {
        return n;
    }
    
    @Override public String toString() {
        return String.valueOf(n);
    }
}

class Plus implements IntegerExpression {
    private final IntegerExpression left, right;
    
    // Abstraction function
    //    represents the sum of two expressions left+right
    // Rep invariant
    //    true
    // Safety from rep exposure
    //    all fields are immutable and final
    
    /** Make a Plus which is the sum of left and right. */
    public Plus(IntegerExpression left, IntegerExpression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override public int value() {
        return left.value() + right.value();
    }
    
    @Override public String toString() {
        return "("+left+")+("+right+")";
    }
}
