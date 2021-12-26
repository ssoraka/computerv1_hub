package parser.ast;

import parser.lib.NumberValue;
import parser.lib.UnknownValue;
import parser.lib.Value;

public class ValueExpression implements Expression{

    private final Value value;

    public ValueExpression(double value) {
        this.value = new NumberValue(value);
    }

    public ValueExpression(String value) {
        this.value = new UnknownValue(value);
    }

    @Override
    public Value eval() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

