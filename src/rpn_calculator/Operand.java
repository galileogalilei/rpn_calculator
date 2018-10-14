package rpn_calculator;

import java.util.ArrayDeque;

abstract class Operand<T> implements TokenIterface<T> {
    T value;

    public Operand(T input) {
        this.value = input;
    }

    public T getValue() {
        return this.value;
    }

    @Override
    public ArrayDeque<T> processNode(ArrayDeque<T> stack) {
        stack.push(this.value);
        return stack;
    }
}
