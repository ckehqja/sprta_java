package calculator;

import calculator.operator.*;

import java.util.Deque;

public class ArithmeticCalculator<T extends Number> extends Calculator {

    Operator<Double> add = new AddOperator();
    Operator<Double> subtract = new SubtractOperator();
    Operator<Double> multiply = new MultiplyOperator();
    Operator<Double> divide = new DivideOperator();
    Operator<Double> mod = new ModOperator();

    public ArithmeticCalculator(Deque<Double> basket) {
        super(basket);
    }

    //계산
    public double calculate(double a, double b, char op) {
        Operator<Double> operatorFactory = operatorFactory(op);
        if (operatorFactory instanceof DivideOperator<Double> || operatorFactory instanceof ModOperator<Double>) {
            if(b == 0) {
                System.out.println("두번째 숫자는 0을 입력하면 안됩니다. ㅡㅡ;");
//                throw new ArithmeticException("0으로 나누면 무한입니다.");
                return 0;
            }
        }
        double result = operatorFactory.operate(a, b);
        basket.push(result);
        return result;
    }

    //op 에 맞는 클래스를 가져온다.
    private Operator<Double> operatorFactory(char operator) {
        OperatorType operatorType = OperatorType.getOpt(operator);
        return switch (operatorType) {
            case ADD -> add;
            case SUBTRACT -> subtract;
            case MULTIPLY -> multiply;
            case DIVIDE -> divide;
            case MOD -> mod;
        };
    }

    //바스켓 결곽값을 추력하는 메서드2
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
        basket.stream().filter(a -> a >= d).forEach(a -> System.out.print(a + " "));
        System.out.println(" ] ");
    }

    //바스켓에서 이하 값을 찾는 메서드
    public void underStream(double d) {
        System.out.print(" [ ");
        basket.stream().filter(a -> a <= d).forEach(a -> System.out.print(a + " "));
        System.out.println(" ] ");
    }
}