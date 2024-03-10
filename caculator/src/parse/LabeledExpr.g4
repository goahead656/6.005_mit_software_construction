grammar LabeledExpr;

prog:   stat+ ;

// -------------给每个备选分支打标签

stat:   expr NEWLINE                # printExpr
    |   ID '=' expr NEWLINE         # assign
    |   NEWLINE                     # blank
    ;

expr:   expr op=('*'|'/') expr      # MulDiv
    |   expr op=('+'|'-') expr      # AddSub
    |   INT                         # int
    |   ID                          # id
    |   '(' expr ')'                # parens
    ;

// -------------给运算符号设置名字，也形成词法符号

MUL :   '*' ;
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;

// -------------剩下的是和之前一样的词法符号

ID  :   [a-zA-Z]+ ;      // 标识符：一个到多个英文字母
INT :   [0-9]+ ;         // 整形值：一个到多个数字
NEWLINE:'\r'? '\n' ;     // 换行符
WS  :   [ \t]+ -> skip ; // 跳过空格和tab
