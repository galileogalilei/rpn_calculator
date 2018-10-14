package rpn_calculator;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.function.Function;

/**
 * Purpose: concrete implementation class for operators applied to double type operands
 */
public class DoubleOperator extends Operator<Double> {
    private Function<LinkedList<Double>, Double> callback;

    public DoubleOperator(String symbol, Function<LinkedList<Double>, Double> callback, int precedence, int operandsNr) {
        super(symbol, precedence, operandsNr);
        this.callback = callback;
    }

    public DoubleOperator(String symbol, Function<LinkedList<Double>, Double> callback, int precedence) {
        super(symbol, precedence);
        this.callback = callback;
    }

    @Override
    public Double applyOperatorLogic(LinkedList<Double> operandsList) throws Exception {
        if (operandsList.size() < 1) {
            throw new OperandsNrException("Input nr of operands cannot be empty!");
        }
        if (this.getOperandsNr() > 0 && this.getOperandsNr() != operandsList.size()) {
            throw new OperandsNrException("Input nr of operands: " + operandsList.size() + " does not match Operator's configuration number of operands:" + this.getOperandsNr());
        }
        Double res = this.callback.apply(operandsList);
        if (!res.isNaN()) {
            if (res > Double.MAX_VALUE) {
                throw new OperandsNrException("Double type max value overflow!");
            }
            if (res < -Double.MAX_VALUE) {
                throw new OperandsNrException("Double type min value overflow!");
            }
        }
        return res;
    }
}
