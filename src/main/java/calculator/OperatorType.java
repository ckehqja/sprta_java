package calculator;

import java.util.Collections;

public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    MOD('%');
    char op;
    OperatorType(char op) {
        this.op = op;
    }
    public char getOp() {
        return op;
    }

}
