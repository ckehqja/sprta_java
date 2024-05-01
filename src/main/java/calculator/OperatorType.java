package calculator;

public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    MOD('%');
    private final char op;
    OperatorType(char op) {
        this.op = op;
    }

    public static OperatorType getOpt(char op) {
        for (OperatorType type : OperatorType.values()) {
            if(type.op == op) {
                return type;
            }
        }
        throw new IllegalArgumentException("해당하는 연산자가 없습니다. " + op);
    }
}
