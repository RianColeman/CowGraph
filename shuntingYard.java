import java.util.*;

public class shuntingYard {
    private static final Map<String, Integer> PRECEDENCE = Map.of(
        "+", 1,
        "-", 1,
        "*", 2,
        "/", 2,
        "^", 3
    );

    private static final Set<String> RIGHT_ASSOC = Set.of("^");

    public static List<Token> convert(List<Token> infixTokens) {
        List<Token> output = new ArrayList<>();
        Deque<Token> opStack = new ArrayDeque<>();

        for (Token token : infixTokens) {
            switch (token.type) {
                case NUMBER:
                    output.add(token);
                    break;

                case OPERATOR:
                    while (!opStack.isEmpty()) {
                        Token top = opStack.peek();
                        if (top.type != Token.Type.OPERATOR) break;

                        int currPrec = PRECEDENCE.get(token.value);
                        int topPrec = PRECEDENCE.get(top.value);
                        boolean rightAssoc = RIGHT_ASSOC.contains(token.value);

                        if ((currPrec < topPrec) ||
                            (currPrec == topPrec && !rightAssoc)) {
                            output.add(opStack.pop());
                        } else {
                            break;
                        }
                    }
                    opStack.push(token);
                    break;

                case LEFT_PAREN:
                    opStack.push(token);
                    break;

                case RIGHT_PAREN:
                    while (!opStack.isEmpty() && opStack.peek().type != Token.Type.LEFT_PAREN) {
                        output.add(opStack.pop());
                    }
                    if (opStack.isEmpty() || opStack.peek().type != Token.Type.LEFT_PAREN) {
                        throw new IllegalArgumentException("Mismatched parentheses");
                    }
                    opStack.pop(); // discard the '('
                    break;
            }
        }

        while (!opStack.isEmpty()) {
            Token top = opStack.pop();
            if (top.type == Token.Type.LEFT_PAREN || top.type == Token.Type.RIGHT_PAREN) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            output.add(top);
        }

        return output;
    }
}
