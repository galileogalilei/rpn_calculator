package rpn_calculator;

import java.util.ArrayDeque;

public interface TokenIterface<T> {
    public ArrayDeque<T> processNode(ArrayDeque<T> stack) throws Exception;
}
