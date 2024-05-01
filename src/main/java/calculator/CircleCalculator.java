package calculator;

import java.util.Deque;

public class CircleCalculator extends Calculator {

    private double r;

    public CircleCalculator(Deque<Double> basket) {
        super(basket);
    }

    //원의 넓이를 구하고 저장
    public double calculate(double r) {
        double area = PI * r * r;
        basket.push(area);
        return area;
    }

    @Override
    public void inquiryResults() {
        System.out.print("circle basket = [ ");
        for (Double c : basket) {
            System.out.print(c + ", ");
        }
        System.out.println(" ] ");
    }
}
