package javaHomeWork.week03.step4;

public class Calculator {

    AbstractOperation op;

    public void setOperation(AbstractOperation op) {
        this.op = op;
    }
    public double calculate(int a, int b) {
        return op.operate(a, b);
    }
}
