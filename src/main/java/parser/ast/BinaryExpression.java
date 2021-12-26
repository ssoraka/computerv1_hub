package parser.ast;

import parser.lib.Value;

public class BinaryExpression implements Expression{

    private Expression expr1, expr2;
    private char operation;

    public BinaryExpression(char operation, Expression expr1, Expression expr2) {
        this.operation = operation;
        this.expr1 = expr1;
        this.expr2 = expr2;
    }


    @Override
    public Value eval() {
        Value value1 = expr1.eval();
        Value value2 = expr2.eval();

        switch (operation) {
            case '*' : return value1.mult(value2);
            case '/' : return value1.div(value2);
            case '-' : return value1.sub(value2);
            case '^' : return value1.pow(value2);
            case '+' :
            default :
                return value1.add(value2);
        }
    }

    @Override
    public String toString() {
        return String.format("[%s %c %s]", expr1, operation, expr2);
    }
}
