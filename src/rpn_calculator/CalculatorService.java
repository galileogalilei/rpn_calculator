package rpn_calculator;

import java.util.*;

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

    public String convertInfileToRpn(String inputExpression) throws Exception {
        String rpnStr = "";
        ArrayDeque<String> outputQue = new ArrayDeque<String>();
        LinkedList<DoubleOperator> operatorsStack = new LinkedList<DoubleOperator>();
        String[] tockenList = inputExpression.split(" ");
        for (String tocken : tockenList) {
            if (this.operatorsBuilderService.getOperatorBySymbol(tocken) != null) {
                this.currentOperator = this.operatorsBuilderService.getOperatorBySymbol(tocken);
                if (!operatorsStack.isEmpty()) {
                    DoubleOperator last = operatorsStack.getLast();
                    if (currentOperator.getPrecedence() > last.getPrecedence()) {
                        outputQue.push(last.getSymbol());
                        operatorsStack.push(currentOperator);
                    }
                } else {
                    operatorsStack.push(currentOperator);
                }
            } else {
                try {
                    this.currentOperand = new DoubleOperand(Double.parseDouble(tocken));
                    outputQue.push(tocken);
                } catch (NumberFormatException e) {
                    throw new Exception("Input string " + inputExpression + " contains illegal operand: " + tocken);
                }

            }
        }
        if (!operatorsStack.isEmpty()) {
            for (DoubleOperator leftOperator : operatorsStack) {
                outputQue.push(leftOperator.getSymbol());
            }
        }

        ArrayList<String> arr = new ArrayList<String>();
        while (!outputQue.isEmpty()) {
            arr.add(outputQue.pop());
        }
        Collections.reverse(arr);
        rpnStr = String.join(" ", arr);
        return rpnStr;
    }

}
