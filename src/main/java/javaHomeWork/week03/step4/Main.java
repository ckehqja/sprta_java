package javaHomeWork.week03.step4;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setOperation(new DivideOperation());
        double cal1 = calculator.calculate(120, 44);

        calculator.setOperation(new MultiplyOperation());
        double cal2 = calculator.calculate(10, 5);

        System.out.println("cal1 = " + cal1);
        System.out.println("cal2 = " + cal2);
    }
}
