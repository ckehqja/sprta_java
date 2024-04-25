package calculator;

public class DivideOperator implements Operator {
    @Override
    public double calculate(int a, int b) {
        return (double) a / b;
    }
}
