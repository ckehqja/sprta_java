package calculator.operator;

public class ArithmeticConverter<T extends Number> {

    public T convert(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() + b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        } else if (a instanceof Float) {
            return (T) Float.valueOf(a.floatValue() + b.floatValue());
        } else if (a instanceof Long) {
            return (T) Long.valueOf(a.longValue() + b.longValue());
        } else if (a instanceof Short) {
            return (T) Short.valueOf((short) (a.shortValue() + b.shortValue()));
        } else if (a instanceof Byte) {
            return (T) Byte.valueOf((byte) (a.byteValue() + b.byteValue()));
        } else {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }
}
