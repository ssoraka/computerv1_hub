import parser.Lexer;
import parser.Parser;
import parser.ast.Expression;
import parser.ast.ValueExpression;
import parser.lexer.Token;
import parser.lib.MapValue;
import parser.lib.Val;
//import parser.lib.Value;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*

надо сделать единый интерфейс для единичного значения и

 */


public class Main {
    public static void main(String[] args) {

        String str = "1 + 20";
        List<Token> tokenize = new Lexer(str).tokenize();
        tokenize.forEach(System.out::println);

        Expression expression = new Parser(tokenize).expression();
        MapValue eval = expression.eval();
        System.out.println(eval);
    }
}
