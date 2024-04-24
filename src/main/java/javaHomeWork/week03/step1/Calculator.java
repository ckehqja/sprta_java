package javaHomeWork.week03.step1;

public class Calculator {

    public double calculate(String operator, int firstNumber, int secondNumber) {
        return switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> (double) firstNumber / secondNumber;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}

