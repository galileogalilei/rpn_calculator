package rpn_calculator;

import java.util.LinkedList;

public interface OperatorTokenInterface<T> {
    public T applyOperatorLogic(LinkedList<T> operandsList) throws Exception;
}
