package parser.ast;

//import parser.lib.NumberValue;
//import parser.lib.UnknownValue;
import parser.lib.MapValue;
import parser.lib.Value;

public class ValueExpression implements Expression{

    private final MapValue value;

    public ValueExpression(double value) {
        this.value = new MapValue(value);
    }

    public ValueExpression(String value) {
        this.value = new MapValue(value);
    }

    @Override
    public MapValue eval() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

