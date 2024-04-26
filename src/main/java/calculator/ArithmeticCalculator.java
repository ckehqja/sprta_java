package calculator;

import java.util.Deque;

public class ArithmeticCalculator extends Calculator{

    public ArithmeticCalculator(Deque<Double> basket) {
        super(basket);
    }


    //계산
    public double calculate(int a, int b, char op) {
        double result = switch (op) {
            case '+' -> addOp.calculate(a, b);
            case '-' -> subOp.calculate(a, b);
            case '*' -> mulOp.calculate(a, b);
            case '/' -> {
                if (b == 0) throw new ArithmeticException("Division by zero");
                else yield divOp.calculate(a, b);
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
