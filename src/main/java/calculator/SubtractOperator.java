package calculator;

public class SubtractOperator<Double> implements Operator<Double> {

    @Override
    public double operate(double a, double b) {
        return a-b;
    }
}
