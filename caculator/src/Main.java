import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parse.LabeledExprLexer;
import parse.LabeledExprParser;


public class Main {
    public static void main(String[] args) {
        CharStream input = CharStreams.fromString("a=2*(3+4)-5\nb=2\na+b\n");
        // 词法分析->Token流->生成语法分析器对象
        LabeledExprLexer lexer = new LabeledExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);
        // 启动语法分析，获取语法树(根节点)
        ParseTree tree = parser.prog();
        // 创建自定义的能进行四则运算的访问者类
        EvalVisitor evalVisitor = new EvalVisitor();
        // 访问这棵语法树，在访问同时即可进行计算获取结果
        evalVisitor.visit(tree);
    }
}