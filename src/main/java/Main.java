import parser.Lexer;
import parser.lexer.Token;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String str = " - X + 1 * X^10 101010000 -10 /2";
        List<Token> tokenize = new Lexer(str).tokenize();

        tokenize.forEach(System.out::println);


    }
}
