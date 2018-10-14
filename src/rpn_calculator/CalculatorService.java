package rpn_calculator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Purpose: evaluates RPN expressions for double type operands!
 */
public class CalculatorService implements RPNCalculatorInterface<Double> {
    private DefaultOperatorsBuilderService operatorsBuilderService;
    private DoubleOperator currentOperator;
    private DoubleOperand currentOperand;

    public CalculatorService() {
    }

    public DefaultOperatorsBuilderService setOperatorsBuilderService(DefaultOperatorsBuilderService service) {
        this.operatorsBuilderService = service;
        return this.operatorsBuilderService;
    }

    public Double calculate(String inputExpression) throws Exception {
        ArrayDeque<Double> stack = new ArrayDeque<Double>();
        Double result = (double) 0;
        String[] tockenList = inputExpression.split(" ");
        for (String tocken : tockenList) {
            if (this.operatorsBuilderService.getOperatorBySymbol(tocken) != null) {
                this.currentOperator = this.operatorsBuilderService.getOperatorBySymbol(tocken);
                this.currentOperator.processNode(stack);
            } else {
                try {
                    this.currentOperand = new DoubleOperand(Double.parseDouble(tocken));
                    this.currentOperand.processNode(stack);
                } catch (NumberFormatException e) {
                    throw new Exception("Input string " + inputExpression + " contains illegal operand: " + tocken);
                }

            }
        }

        return stack.pop();
    }

}
