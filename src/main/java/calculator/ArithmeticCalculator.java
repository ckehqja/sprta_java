package calculator;

import java.util.Deque;

public class ArithmeticCalculator<T> extends Calculator {

    public ArithmeticCalculator(Deque<Double> basket) {
        super(basket);
    }

    private Operator operator;
    private T a, b;
    private char op;

    public void arithSetter(T a, T b, char op) {
        this.a = a;
        this.b = b;
        this.op = op;
    }

    //계산
    @Override
    public double calculate() throws IllegalArgumentException {
        double result;
        if (op == OperatorType.ADD.getOp()) {
            result = new AddOperator().operate(a, b);
        } else if (op == OperatorType.SUBTRACT.getOp()) {
            result = new SubtractOperator().operate(a, b);
        } else if (op == OperatorType.MULTIPLY.getOp()) {
            result = new MultiplyOperator().operate(a, b);
        } else if (op == OperatorType.DIVIDE.getOp()) {
            if ((Double)b == (Double)0.0) throw new ArithmeticException("Division by zero");
            else result = new DivideOperator().operate(a, b);
        } else if (op == OperatorType.MOD.getOp()) {
            result = new ModOperator().operate(a, b);
        } else throw new IllegalArgumentException("Invalid operator: " + op);
        basket.push(result);
        return result;
    }

    @Override
    public void inquiryResults() {
        System.out.print("arithmetic basket = [ ");
        for (Double c : basket) {
            System.out.print(c + ", ");
        }
        System.out.println(" ] ");
    }

    public void overStream(double d) {
        System.out.print(" [ ");
        basket.stream().filter(a-> a >= d).forEach(a-> System.out.print(a + " "));
        System.out.println(" ] ");
    }
    public void underStream(double d) {
        System.out.print(" [ ");
        basket.stream().filter(a-> a <= d).forEach(a-> System.out.print(a + " "));
        System.out.println(" ] ");
    }


}
