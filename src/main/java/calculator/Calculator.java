package calculator;

import java.util.Deque;

public class Calculator {
    // 모든 인스턴스에 공유하는 상수는 static final 대문자
    static final double PI = 3.14159265358979323846;
    //사칙연산 결과를 담는 컬렉션
    private Deque<Double> basket;
    //원 넓이 결과를 담는 컬렉션
    private Deque<Double> circleBasket;

    //생성자 시점에서 초기화되는 컬렉션들
    public Calculator(Deque<Double> basket, Deque<Double> circleBasket) {
        this.basket = basket;
        this.circleBasket = circleBasket;
    }
    //원넓이 컬렉션 게터
    public Deque<Double> getCircleBasket() {
        return circleBasket;
    }
    //원넓이 컬렉션 세터
    public void setCircleBasket(Deque<Double> circleBasket) {
        this.circleBasket = circleBasket;
    }

    //원의 넓이를 구하고 저장
    public double CircleArea(double r) {
        double area = PI * r * r;
        circleBasket.push(area);
        return area;
    }

    //원바스켓 모두 출력
    public void printCircleArea() {
        System.out.print("circle basket = [ ");
        for (Double c : circleBasket) {
            System.out.print(c + ", ");
        }
        System.out.println(" ] ");
    }

    //원 바스켓이 비었는지 확인
    public boolean isCircleBasketEmpty() {
        return circleBasket.isEmpty();
    }

    //원 바스켓 최근 결과데이터 삭제
    public double c_removeResult() {
        if (isCircleBasketEmpty()) {
            System.out.println("circleBasket is empty");
            return 0;
        }
        return circleBasket.pop();

    }

    public Deque<Double> getBasket() {
        return basket;
    }

    public void setBasket(Deque<Double> basket) {
        this.basket = basket;
    }

    //바스켓이 비어있는지 확인
    public boolean isBasketEmpty() {
        return basket.isEmpty();
    }

    //바스켓 최근꺼 하나 꺼내기 getter
    public double removeResult() {
        if (isBasketEmpty()) {
            System.out.println("Basket is empty");
            return 0;
        }
        return basket.pop();

    }

    //바스켓 전부 출력
    public void inquiryResults() {
        System.out.print("basket = [ ");
        for (Double v : basket) {
            System.out.print(v + ", ");
        }
        System.out.println(" ] ");
    }

    //계산
    public double calculate(int a, int b, char op) {
        double result = switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) throw new ArithmeticException("Division by zero");
                else yield (double) a / b;
            }
            default -> throw new IllegalArgumentException("Invalid operator: " + op);
        };
        basket.push(result);
        return result;
    }
}
