import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rpn_calculator.DefaultOperatorsBuilderService;
import rpn_calculator.OperandsNrException;

import java.util.LinkedList;

public class AddOperatorTest extends SumOperatorTest {
    public AddOperatorTest() {
        this.operatorsBuilder = new DefaultOperatorsBuilderService();
        this.operatorsBuilder.build();
        this.testedOperator = this.operatorsBuilder.getOperatorBySymbol("+");
    }

    @Test
    public void testapplyOperatorLogicForEmpty() {
        LinkedList<Double> operands = new LinkedList<Double>();
        Double expected = (double) 0;
        try {
            Double res = this.testedOperator.applyOperatorLogic(operands);
        } catch (OperandsNrException e) {
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testapplyOperatorLogicForOne() {
        LinkedList<Double> operands = new LinkedList<Double>();
        operands.add(32.5);
        Double expected = (double) 32.5;
        try {
            Double res = this.testedOperator.applyOperatorLogic(operands);
            Assertions.assertEquals(expected, res, "Applying " + this.testedOperator.getSymbol() + " operator for operands " + operands + "failed");
        } catch (OperandsNrException e) {
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testapplyOperatorLogicForMany() {
        LinkedList<Double> operands = new LinkedList<Double>();
        for (int i = 1; i < 7; i++) {
            if (i % 3 == 0) {
                operands.add((double) i);
            }
        }
        Double expected = (double) 9;
        try {
            Double res = this.testedOperator.applyOperatorLogic(operands);
            Assertions.assertEquals(expected, res, "Applying " + this.testedOperator.getSymbol() + " operator for operands " + operands + "failed");
        } catch (OperandsNrException e) {
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}
