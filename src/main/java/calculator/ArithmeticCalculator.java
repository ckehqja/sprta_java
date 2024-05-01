package calculator;

import java.util.Deque;

public class ArithmeticCalculator<T extends Number> extends Calculator {

    public ArithmeticCalculator(Deque<Double> basket) {
        super(basket);
    }

    //계산
    public double calculate(double a, double b, char op) {
        double result = operatorFactory(op).operate(a, b);
        basket.push(result);
        return result;
    }

    //op 에 맞는 클래스를 가져온다.
    private Operator<T> operatorFactory(char operator) {
        OperatorType operatorType = OperatorType.getOpt(operator);
        return switch (operatorType) {
            case ADD -> new AddOperator();
            case SUBTRACT -> new SubtractOperator();
            case MULTIPLY -> new MultiplyOperator();
            case DIVIDE -> new DivideOperator();
            case MOD -> new ModOperator();
        };
    }

    //바스켓 결곽값을 추력하는 메서드
    @Override
    public void inquiryResults() {
        System.out.print("arithmetic basket = [ ");
        for (Double c : basket) {
            System.out.print(c + ", ");
        }
        System.out.println(" ] ");
    }

    //바스켓에서 이상 값을 찾는 메서드
    public void overStream(double d) {
        System.out.print(" [ ");
        basket.stream().filter(a-> a >= d).forEach(a-> System.out.print(a + " "));
        System.out.println(" ] ");
    }

    //바스켓에서 이하 값을 찾는 메서드
    public void underStream(double d) {
        System.out.print(" [ ");
        basket.stream().filter(a-> a <= d).forEach(a-> System.out.print(a + " "));
        System.out.println(" ] ");
    }
}