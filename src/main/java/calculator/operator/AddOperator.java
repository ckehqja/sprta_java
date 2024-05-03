package calculator.operator;

public class AddOperator<T extends Number> implements Operator<T> {

    @Override
    public T operate(T a, T b) {
        return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
    }
}
