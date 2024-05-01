package calculator;

public class AddOperator<Double> implements Operator<Double> {

    @Override
    public double operate(Double a, Double b) {
        return (double)a+ (double)b;
    }
}
