package parser.ast;

import java.util.ArrayList;
import java.util.List;

public class BlockStatement implements Statement{
    private List<Statement> list = new ArrayList<>();

    @Override
    public void execute() {
        list.forEach(Statement::execute);
    }

    public void add(Statement statement) {
        list.add(statement);
    }
}
