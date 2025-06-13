import java.util.ArrayList;
import java.util.List;

public class Tokeniser {
    public static List<Token> tokenise(String input) {
        List<Token> tokens = new ArrayList<>();
        StringBuilder numberBuffer = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // Check for blank space
            if (Character.isWhitespace(c)) continue;

            // Check for numbers
            if (Character.isDigit(c) || c == '.') {
                numberBuffer.append(c);
                continue;
            }

            // Reaet number buffer
            if (numberBuffer.length() > 0) {
                tokens.add(new Token(Token.Type.NUMBER, numberBuffer.toString()));
                numberBuffer.setLength(0);
            }

            // Minus checker
            if (c == '-' && (tokens.isEmpty() || tokens.get(tokens.size() - 1).type == Token.Type.OPERATOR || tokens.get(tokens.size() - 1).type == Token.Type.LEFT_PAREN)) {
                numberBuffer.append(c);
                continue;
            }

            // Assign type
            switch (c) {
                case '+': case '-': case '*': case '/': case '^':
                    tokens.add(new Token(Token.Type.OPERATOR, String.valueOf(c)));
                    break;
                case '(':
                    tokens.add(new Token(Token.Type.LEFT_PAREN, String.valueOf(c)));
                    break;
                case ')':
                    tokens.add(new Token(Token.Type.RIGHT_PAREN, String.valueOf(c)));
                    break;
                default:
                    throw new IllegalArgumentException("ERROR! unexpected character: " + c);
            }
        }

        if (numberBuffer.length() > 0) {
            tokens.add(new Token(Token.Type.NUMBER, numberBuffer.toString()));
        }

        return tokens;
    }
}
