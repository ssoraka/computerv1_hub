package parser.lexer;

public class InvalidCaracterException extends RuntimeException{
    public InvalidCaracterException(String message) {
        super(message);
    }
}
