package rpn_calculator;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.function.Function;

/**
 * Purpose: base class for all operators than can be implemented in a RPN Calculator service
 *
 * @param <T>
 */
public abstract class Operator<T> implements TokenIterface<T>, OperatorTokenInterface<T> {
    private int operandsNr;
    private int precedence;
    private String symbol;
    private Function callback;

    public Operator(String symbol, int precedence, int operandsNr) {
        this.symbol = symbol;
        this.precedence = precedence;
        this.operandsNr = operandsNr;
    }

    public Operator(String symbol, int precedence) {
        this(symbol, precedence, 0);
    }

    public int getOperandsNr() {
        return operandsNr;
    }

    public int getPrecedence() {
        return precedence;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract T applyOperatorLogic(LinkedList<T> operandsList) throws Exception;

    @Override
    public ArrayDeque<T> processNode(ArrayDeque<T> stack) throws Exception {
        LinkedList<T> operandsList = new LinkedList<T>();
        ArrayDeque<T> initialStack = stack.clone();
        T result;
        if (this.operandsNr > 0) {
            for (int i = 0; i < this.operandsNr; i++) {
                if (stack.isEmpty()) {
                    throw new Exception("not enough operands found for " + this.getSymbol() + " operator for given stack: " + initialStack);
                }
                operandsList.add(stack.pop());
            }
        } else {
            while (!stack.isEmpty()) {
                operandsList.add(stack.pop());
            }
        }
        try {
            result = this.applyOperatorLogic(operandsList);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        if (!result.equals(null)) {
            stack.push(result);
        }
        return stack;
    }
}
