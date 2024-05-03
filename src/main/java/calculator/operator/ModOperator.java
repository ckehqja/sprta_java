package calculator.operator;

public class ModOperator<T extends Number> implements Operator<T> {

    @Override
    public T operate(T a, T b) {
        return (T) java.lang.Double.valueOf(a.doubleValue() % b.doubleValue());
    }
}
