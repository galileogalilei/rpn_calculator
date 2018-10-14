package rpn_calculator;

import java.util.ArrayDeque;
import java.util.LinkedList;

@Deprecated
public class SumOperator extends Operator<Double> {
    public SumOperator(String symbol, int precedence, int operandsNr) {
        super(symbol, precedence, operandsNr);
    }

    public SumOperator(String symbol, int precedence) {
        super(symbol, precedence);
    }

    @Override
    public Double applyOperatorLogic(LinkedList<Double> operandsList) throws Exception {
        if (this.getOperandsNr() > 0 && this.getOperandsNr() != operandsList.size()) {
            throw new Exception("Input nr of operands: " + operandsList.size() + " does not match Operator's configuration number of operands:" + this.getOperandsNr());
        }
        Double sum = (double) 0;
        for (double i : operandsList) {
            sum += i;
        }
        return sum;
    }
}
