package calculator;

import java.util.Deque;

public class ArithmeticCalculator extends Calculator {

    public ArithmeticCalculator(Deque<Double> basket) {
        super(basket);
    }
    private Operator operator;
    private int a, b;
    private char op;

    public void arithSetter(int a, int b, char op) {
        this.a = a;
        this.b = b;
        this.op = op;
    }


    //계산
    @Override
    public double calculate() {
        double result = switch (op) {
            case '+' -> {
                operator = new AddOperator();
                yield operator.operate(a, b);
            }
            case '-' ->  {
                operator = new SubtractOperator();
                yield operator.operate(a, b);
            }
            case '*' -> {
                operator = new MultiplyOperator();
                yield operator.operate(a, b);
            }
            case '/' -> {
                if (b == 0) throw new ArithmeticException("Division by zero");
                else {
                    operator = new DivideOperator();
                    yield operator.operate(a, b);
                }
            }
            case '%' -> {
                operator = new ModOperator();
                yield operator.operate(a, b);
            }
            default -> throw new IllegalArgumentException("Invalid operator: " + op);
        };
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
}
