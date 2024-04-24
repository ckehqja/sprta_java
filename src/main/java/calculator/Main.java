package calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double calculate = calculator.calculate(10, 0, '/');
        System.out.println("calculate = " + calculate);

    }
}
