package calculator;

import java.util.Deque;

public class CircleCalculator extends Calculator {

    public CircleCalculator(Deque<Double> basket) {
        super(basket);
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
