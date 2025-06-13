public class Token {
    public enum Type {
        NUMBER,
        OPERATOR,
        LEFT_PAREN,
        RIGHT_PAREN
    }

    public final Type type;
    public final String value;

    public Token(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return type + "(" + value + ")";
    }
}
