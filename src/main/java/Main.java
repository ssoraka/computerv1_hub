import parser.Lexer;
import parser.Parser;
import parser.ast.Expression;
import parser.lexer.Token;
import parser.lib.Value;

import java.io.IOException;
import java.util.List;


/*

надо сделать единый интерфейс для единичного значения и

 */


public class Main {
    public static void main(String[] args) {

        String str = "1 * 10 - 101010000 -10 /2";
        List<Token> tokenize = new Lexer(str).tokenize();

        tokenize.forEach(System.out::println);


        try {
            System.out.println();
        } catch (RuntimeException e) {
            ;
        }

        final Expression expression = new Parser(tokenize).expression();
        final Value eval = expression.eval();
        System.out.println(eval);
    }
}
