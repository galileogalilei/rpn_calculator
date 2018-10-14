package rpn_calculator;

import java.util.LinkedList;
import java.util.function.Function;

public interface OperatorCallbackInterface extends Function<LinkedList<Double>, Double> {
    @Override
    default Double apply(LinkedList<Double> doubles) {
        return apply(doubles);
    }
}
