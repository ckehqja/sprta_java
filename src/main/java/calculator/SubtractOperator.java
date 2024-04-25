package calculator;

public class SubtractOperator implements Operator{
    @Override
    public double calculate(int a, int b) {
        return a - b;
    }
}
