import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rpn_calculator.DefaultOperatorsBuilderService;
import rpn_calculator.DoubleOperator;

import java.util.LinkedList;

public class SumOperatorTest {
    protected DoubleOperator testedOperator;
    protected DefaultOperatorsBuilderService operatorsBuilder;

    public SumOperatorTest() {
        this.operatorsBuilder = new DefaultOperatorsBuilderService();
        this.operatorsBuilder.build();
        this.testedOperator = this.operatorsBuilder.getOperatorBySymbol("SUM");
    }


    @Test
    public void testapplyOperatorLogicForOne() {
        LinkedList<Double> operands = new LinkedList<Double>();
        operands.add(32.5);
        Double expected = (double) 32.5;
        try {
            Double res = this.testedOperator.applyOperatorLogic(operands);
            Assertions.assertEquals(expected, res, "Applying " + this.testedOperator.getSymbol() + " operator for operands " + operands + "failed");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testapplyOperatorLogicForTwo() {
        LinkedList<Double> operands = new LinkedList<Double>();
        operands.add(10.0);
        operands.add(10.0);
        Double expected = (double) 20;
        try {
            Double res = this.testedOperator.applyOperatorLogic(operands);
            Assertions.assertEquals(expected, res, "Applying " + this.testedOperator.getSymbol() + " operator for operands " + operands + "failed");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testapplyOperatorLogicForMany() {
        LinkedList<Double> operands = new LinkedList<Double>();
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                operands.add((double) i);
            }
        }
        Double expected = (double) 1683;
        try {
            Double res = this.testedOperator.applyOperatorLogic(operands);
            Assertions.assertEquals(expected, res, "Applying " + this.testedOperator.getSymbol() + " operator for operands " + operands + "failed");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}
