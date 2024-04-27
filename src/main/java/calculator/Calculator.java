package calculator;

import java.util.Deque;

public abstract class Calculator {

    //사칙연산 결과를 담는 컬렉션 자손까지 물려받으라고 protected
    protected Deque<Double> basket;

    //생성자 시점에서 초기화되는 컬렉션들
    public Calculator(Deque<Double> basket) {
        this.basket = basket;
    }

    public abstract double calculate();
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


    //바스켓 가장 먼저 저장된 값 꺼내기 getter
    public double removeResult() {
        if (isBasketEmpty()) {
            System.out.println("Basket is empty");
            return 0;
        }
        return basket.pollLast();
    }

    //바스켓 전부 출력
    public abstract void inquiryResults();
}


