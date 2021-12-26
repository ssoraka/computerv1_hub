package parser;

import com.sun.javafx.fxml.expression.VariableExpression;
import parser.ast.*;
import parser.lexer.Token;
import parser.lexer.TokenType;

import java.util.List;

public class Parser {
    final static Token EOF = new Token(TokenType.EOF, "");

    final private List<Token> tokens;

    private int pos;
    final private int size;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        size = tokens.size();
    }

//    public Statement parse() {
//        final BlockStatement result = new BlockStatement();
//
//        while (!match(TokenType.EOF)) {
//            result.add(statement());
//        }
//        return result;
//    }

//    private Statement statementOrBlock() {
//        if (get(0).getType() == TokenType.LBRASE) {
//            return block();
//        }
//        return statement();
//    }
//
//    private Statement block() {
//        consume(TokenType.LBRASE);
//
//        final BlockStatement block = new BlockStatement();
//        while (!match(TokenType.RBRASE)) {
//            block.add(statement());
//        }
//        return block;
//    }

//    private Statement statement() {
//        if (get(0).getType() == TokenType.WORD && get(1).getType() == TokenType.LPAREN) {
//            return new FunctionStatement(function());
//        }
//        return assignmentStatement();
//    }

//    private Statement assignmentStatement() {
//        Token current = get(0);
//        if (lookMatch(0, TokenType.WORD) && lookMatch(1, TokenType.EQ)) {
//            final String variable = consume(TokenType.WORD).getText();
//            consume(TokenType.EQ);
//            return new AssignmentStatement(variable, expression());
//        }
//        if (lookMatch(0,TokenType.WORD) && lookMatch(1, TokenType.LBRACKET)) {
//            ArrayAccessExpression array = element();
//            consume(TokenType.EQ);
//            return new ArrayAssignmentStatement(array, expression());
//        }
//        throw new RuntimeException("Unknown statement");
//    }

    public Expression expression() {
        return additive();
    }

    private Expression additive() {
        Expression result = multiplicative();

        while (true) {
            if (match(TokenType.PLUS)) {
                result = new BinaryExpression('+', result, multiplicative());
                continue;
            }
            if (match(TokenType.MINUS)) {
                result = new BinaryExpression('-', result, multiplicative());
                continue;
            }
            break;
        }
        return result;
    }

    private Expression multiplicative() {
        Expression result = unary();

        while (true) {
            if (match(TokenType.STAR)) {
                result = new BinaryExpression('*', result, unary());
                continue;
            }
            if (match(TokenType.SLASH)) {
                result = new BinaryExpression('/', result, unary());
                continue;
            }
            break;
        }
        return result;
    }

    private Expression unary() {
        if (match(TokenType.MINUS)) {
            return new UnaryExpression('-', primary());
        }
        if (match(TokenType.PLUS)) {
            return primary();
        }
        return primary();
    }

    private Expression primary() {
        final Token current = get(0);

        if (match(TokenType.NUMBER)) {
            return new ValueExpression(Double.parseDouble(current.getText()));
        }

        if (match(TokenType.WORD)) {
            return new ValueExpression(current.getText());
        }


        if (match(TokenType.LPAREN)) {
            Expression result = expression();
            match(TokenType.RPAREN);
            return result;
        }
        throw new RuntimeException("Unknown Expression");
    }

    private Token consume(TokenType type) {
        final Token current = get(0);
        if (type != current.getType())
            throw new RuntimeException("Token " + type + " doesn't match " + current.getType());
        pos++;
        return current;
    }

    private boolean match(TokenType type) {
        final Token current = get(0);
        if (type != current.getType())
            return false;
        pos++;
        return true;
    }

    private boolean lookMatch(int pos, TokenType type) {
        return get(pos).getType() == type;
    }

    private Token get() {
        return  pos >= size ?  EOF : tokens.get(pos);
    }

    private Token get(int relativePosition) {
        final int position = pos + relativePosition;

        if (position >= size) return EOF;
        return tokens.get(position);
    }
}