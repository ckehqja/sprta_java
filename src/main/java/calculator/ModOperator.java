package calculator;

public class ModOperator<Double> implements Operator<Double>  {

    @Override
    public double operate(Double a, Double b) {
        return (double)a%(double)b;
    }
}
