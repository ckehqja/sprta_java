package calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    private Deque<Double> basket = new ArrayDeque<>();

    //바스켓이 비어있는지 확인
    public boolean isBasketEmpty() {
        return basket.isEmpty();
    }

    //바스켓 최근꺼 하나 꺼내기
    public double getBasket() {
        if (isBasketEmpty()) {
            System.out.println("Basket is empty");
            return 0;
        }
        return basket.pop();

    }
    //바스케에 하나 추가하기
    public void setBasket(double result) {
        basket.push(result);
    }

    //바스켓 전부 출력
    public void printBasket() {
        System.out.print("basket = [ ");
        for (Double v : basket) {
            System.out.print(v + ", ");
        }
        ;
        System.out.println(" ] ");
    }

    //계산
    public double calculate(int a, int b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) throw new ArithmeticException("Division by zero");
                else yield (double) a / b;
            }
            default -> throw new IllegalArgumentException("Invalid operator: " + op);
        };
    }
}
