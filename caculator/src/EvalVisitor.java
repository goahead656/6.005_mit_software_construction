/*
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 */


import parse.LabeledExprBaseVisitor;
import parse.LabeledExprParser;

import java.util.HashMap;

// 实现计算功能的访问器类
public class EvalVisitor extends LabeledExprBaseVisitor<Integer> {
    // 模拟计算器的内存，存放"变量名->值"的映射，即在赋值时候往这里写
    HashMap<String, Integer> memory = new HashMap<>();

    // 访问赋值语句：ID '=' expr NEWLINE
    @Override
    public Integer visitAssign(LabeledExprParser.AssignContext ctx) {
        System.out.println("visitAssign");
        System.out.println(ctx.getText());
        String id = ctx.ID().getText();  // 获取左值标识符
        int value = visit(ctx.expr());   // 对右值表达式访问求值
        memory.put(id, value);           // 存储赋值
        return value;
    }

    // 访问表达式语句：expr NEWLINE
    @Override
    public Integer visitPrintExpr(LabeledExprParser.PrintExprContext ctx) {
        System.out.println("visitPrintExpr");
        //visit方法调用了tree.accept(this)方法，所以这里的visit方法会被递归调用
        //tree.accept()用于启动访问者模式，即访问者模式的入口
        // 一般来说不会使用visit模式而是使用listener模式，listener模式是antlr4的默认模式，更加简洁
        Integer value = visit(ctx.expr()); // 对表达式访问求值
        System.out.println(value);         // 把值打印出来
        return 0;                          // 反正用不到这个返回值，这里返回假值
    }

    // 访问单个整数构成的表达式：INT
    @Override
    public Integer visitInt(LabeledExprParser.IntContext ctx) {
        System.out.println("visitInt");
        return Integer.valueOf(ctx.INT().getText()); // 把这个数返回
    }

    // 访问单个标识符构成的表达式：ID
    @Override
    public Integer visitId(LabeledExprParser.IdContext ctx) {
        System.out.println("visitId");
        String id = ctx.ID().getText(); // 获取标识符名字
        if (memory.containsKey(id)) // 查表，找到就返回
            return memory.get(id);
        return 0; // 找不到返回0
    }

    // 访问乘除法表达式：expr op=('*'|'/') expr
    @Override
    public Integer visitMulDiv(LabeledExprParser.MulDivContext ctx) {
        System.out.println("visitMulDiv");
        int left = visit(ctx.expr(0));  // 被除数，或乘法因子1
        int right = visit(ctx.expr(1)); // 除数，或乘法因子2
        if (ctx.op.getType() == LabeledExprParser.MUL) // 检查操作符
            return left * right; // 乘法
        return left / right; // 除法
    }

    // 访问加减法表达式：expr op=('+'|'-') expr
    @Override
    public Integer visitAddSub(LabeledExprParser.AddSubContext ctx) {
        System.out.println("visitAddSub");
        int left = visit(ctx.expr(0));  // 项1
        int right = visit(ctx.expr(1)); // 项2
        if (ctx.op.getType() == LabeledExprParser.ADD) // 检查操作符
            return left + right; // 加法
        return left - right; // 减法
    }

    // 访问表达式加括号：'(' expr ')'
    @Override
    public Integer visitParens(LabeledExprParser.ParensContext ctx) {
        System.out.println("visitParens");
        return visit(ctx.expr()); // 其实就是把括号里表达式的值算出来返回
    }

}
