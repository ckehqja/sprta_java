package javaHomeWork.week03.step3;

public class Calculator {
    public double calculate(String operator, int firstNumber, int secondNumber) {
        return switch (operator) {
            case "+" -> AddOperation.operate(firstNumber, secondNumber);
            case "-" -> SubstractOperation.operate(firstNumber, secondNumber);
            case "*" -> MultiplyOperation.operate(firstNumber, secondNumber);
            case "/" -> DivideOperation.operate(firstNumber, secondNumber);
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}
