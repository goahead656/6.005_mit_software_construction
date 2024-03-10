grammar IntegerExpression;
import Configuration;

root : sum EOF;
sum : primitive ('+' primitive)*;
primitive : NUMBER | '(' sum ')';
NUMBER : [0-9]+;
