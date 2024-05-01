package calculator;

public class DivideOperator<Double> implements Operator<Double> {

    @Override
    public double operate(double a, double b) {
        return a/b;
    }
}
