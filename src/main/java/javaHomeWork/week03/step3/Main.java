package javaHomeWork.week03.step3;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double calculate = calculator.calculate("+", 100, 200);
        double calculate2 = calculator.calculate("*", 100, 200);
        System.out.println("calculate = " + calculate);
        System.out.println("calculate2 = " + calculate2);
    }
}
