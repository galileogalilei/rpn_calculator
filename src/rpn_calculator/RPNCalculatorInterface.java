package rpn_calculator;

public interface RPNCalculatorInterface<T> {
    public T calculate(String expression) throws Exception;
}
