package parser.ast;

import parser.lib.MapValue;
//import parser.lib.Value;

public interface Expression {
    public MapValue eval();
}
