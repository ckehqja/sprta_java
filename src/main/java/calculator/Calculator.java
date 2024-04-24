package calculator;

public class Calculator {

    public double calculate(int a, int b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if ( b == 0 ) throw new ArithmeticException("Division by zero");
                else yield (double) a / b;
            }
            default -> throw new IllegalArgumentException("Invalid operator: " + op);
        };
    }
}
