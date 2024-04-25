package javaHomeWork.week04;


import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    private final Calculator calculator = new Calculator();

    public Parser parseFirstNum(String firstInput) throws BadInputException {
        // 구현 1.
        boolean matches = Pattern.matches(NUMBER_REG, firstInput);
        if (!matches) {
            throw new BadInputException("정수값");
        }
        this.calculator.setFirstNumber(Integer.parseInt(firstInput));
        return this;
    }

    public Parser parseSecondNum(String secondInput) throws BadInputException {
        // 구현 1.
        boolean matches = Pattern.matches(NUMBER_REG, secondInput);
        if (!matches) {
            throw new BadInputException("정수값");
        }
        this.calculator.setSecondNumber(Integer.parseInt(secondInput));
        return this;
    }

    public Parser parseOperator(String operationInput) throws BadInputException {
        // 구현 1.
        boolean matches = Pattern.matches(OPERATION_REG, operationInput);
        if (!matches) {
            throw new BadInputException("연산자");
        }

        AbstractOperation operation = switch (operationInput) {
            case "+" -> new AddOperation();
            case "-" -> new SubstractOperation();
            case "*" -> new MultiplyOperation();
            case "/" -> new DivideOperation();
            default -> null;
        };

        this.calculator.setOperation(operation);
        return this;
    }

    public double executeCalculator() {
        return calculator.calculate();
    }
}