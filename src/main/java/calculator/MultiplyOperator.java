package calculator;

public class MultiplyOperator implements Operator{
    @Override
    public double calculate(int a, int b) {
        return a * b;
    }
}
