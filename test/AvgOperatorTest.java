import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rpn_calculator.DefaultOperatorsBuilderService;
import rpn_calculator.DoubleOperator;
import rpn_calculator.OperandsNrException;

import java.util.LinkedList;

public class AvgOperatorTest {
    private DefaultOperatorsBuilderService operatorsBuilder;
    protected DoubleOperator testedOperator;

    public AvgOperatorTest() {
        this.operatorsBuilder = new DefaultOperatorsBuilderService();
        this.operatorsBuilder.build();
        this.testedOperator = this.operatorsBuilder.getOperatorBySymbol("AVG");
    }

    @Test
    public void testAvgSuccess() {
        LinkedList<Double> operands = new LinkedList<Double>();
        operands.add(3.0);
        operands.add(4.0);
        operands.add(5.0);
        Double expected = (double) 4;
        try {
            Double res = this.testedOperator.applyOperatorLogic(operands);
            Assertions.assertEquals(expected, res, "Applying " + this.testedOperator.getSymbol() + " operator for operands " + operands + "failed");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testAvgFailOperation() {
        LinkedList<Double> operands = new LinkedList<Double>();
        operands.add(5.0);
        operands.add(6.0);
        Double expected = (double) 5.7;
        try {
            Double res = this.testedOperator.applyOperatorLogic(operands);
            Assertions.assertNotEquals(expected, res, "Applying " + this.testedOperator.getSymbol() + " operator for operands " + operands + "failed");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testAvgFailNullOperands() {
        LinkedList<Double> operands = new LinkedList<Double>();
        Double expected = (double) 4;
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
