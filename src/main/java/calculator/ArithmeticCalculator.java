package calculator;

import java.util.Deque;

public class ArithmeticCalculator extends Calculator{
    public ArithmeticCalculator(Deque<Double> basket) {
        super(basket);
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
