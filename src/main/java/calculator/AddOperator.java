package calculator;

public class AddOperator implements Operator {
    @Override
    public double calculate(int a, int b) {
        return a + b;
    }
}
