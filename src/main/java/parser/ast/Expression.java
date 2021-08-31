package parser.ast;

import parser.lib.MapValue;

public interface Expression {
    public MapValue eval();
}
