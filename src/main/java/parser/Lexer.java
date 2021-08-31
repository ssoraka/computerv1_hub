package parser;

import parser.lexer.InvalidCaracterException;
import parser.lexer.Token;
import parser.lexer.TokenType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lexer {
    final private static Map<Character, TokenType> OPERATORS;
    static {
        OPERATORS = new HashMap<>();
        OPERATORS.put('(', TokenType.LPAREN);
        OPERATORS.put(')', TokenType.RPAREN);

        OPERATORS.put('+', TokenType.PLUS);
        OPERATORS.put('-', TokenType.MINUS);
        OPERATORS.put('*', TokenType.STAR);
        OPERATORS.put('/', TokenType.SLASH);
        OPERATORS.put('^', TokenType.POW);

        OPERATORS.put('=', TokenType.EQ);
    }

    private final String input;
    private final int length;

    private List<Token> tokens;

    private int pos;

    public Lexer(String input) {
        this.input = input;
        this.length = input.length();

        tokens = new ArrayList<>();
    }

    public List<Token> tokenize() {
        while (pos < length) {
            char current = peek();
            if (Character.isDigit(current)) {
                tokenizeNumber();
            } else if (Character.isLetter(current)) {
                tokenizeWord();
            } else if (OPERATORS.containsKey(current)) {
                tokenizeOperator();
            } else if (Character.isSpaceChar(current)) {
                next();
            } else {
                throw new InvalidCaracterException(String.format(
                        "Недопустимый символ %c в строке %s на позиции %d", current, input, pos)
                );
            }
        }
        return tokens;
    }

    //todo . или ,
    private void tokenizeNumber() {
        StringBuilder buffer = new StringBuilder();
        char current = peek();

        while (Character.isDigit(current) || current == '.') {
            if (current == '.' && buffer.indexOf(".") != -1) {
                    throw new RuntimeException("Invalid float number");
            }
            buffer.append(current);
            current = next();
        }
        if (buffer.indexOf(".") != -1)
            addToken(TokenType.DOUBLE, buffer.toString());
        else
            addToken(TokenType.NUMBER, buffer.toString());
    }

    private void tokenizeWord() {
        StringBuilder buffer = new StringBuilder();
        char current = peek();

        while (Character.isLetterOrDigit(current)) {
            buffer.append(current);
            current = next();
        }
        addToken(TokenType.WORD, buffer.toString());
    }

    private void tokenizeOperator() {
        char current = peek();
        addToken(OPERATORS.get(current), String.valueOf(current));
        next();
    }

    private char next() {
        pos++;
        return peek();
    }

    private char peek() {
        return pos < length ? input.charAt(pos) : '\0';
    }

    private void addToken(TokenType type, String text) {
        tokens.add(new Token(type, text));
    }
}
