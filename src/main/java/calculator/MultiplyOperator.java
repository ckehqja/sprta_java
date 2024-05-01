package calculator;

public class MultiplyOperator<Double> implements Operator<Double>  {
   @Override
    public double operate(Double a, Double b) {
        return (double)a * (double)b;
    }
}
