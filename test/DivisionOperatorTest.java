import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import rpn_calculator.DefaultOperatorsBuilderService;
import rpn_calculator.DoubleOperator;
import rpn_calculator.OperandsNrException;

import java.util.LinkedList;

public class DivisionOperatorTest {
    private DefaultOperatorsBuilderService operatorsBuilder;
    protected DoubleOperator testedOperator;

    public DivisionOperatorTest() {
        this.operatorsBuilder = new DefaultOperatorsBuilderService();
        this.operatorsBuilder.build();
        this.testedOperator = this.operatorsBuilder.getOperatorBySymbol("/");
    }

    @Test
    public void testDivisionIsSuccess() {
        LinkedList<Double> operands = new LinkedList<Double>();
        operands.add(2.0);
        operands.add(8.0);
        Double expected = (double) 4;
        try {
            Double res = this.testedOperator.applyOperatorLogic(operands);
            Assertions.assertEquals(expected, res, "Applying " + this.testedOperator.getSymbol() + " operator for operands " + operands + "failed");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testDivisionByZero() {
        LinkedList<Double> operands = new LinkedList<Double>();
        operands.add(0.0);
        operands.add(8.0);
        Double expected = (double) 4;
        try {
            Double res = this.testedOperator.applyOperatorLogic(operands);
            Assertions.assertEquals(expected, res, "Applying " + this.testedOperator.getSymbol() + " operator for operands " + operands + "failed");
        } catch (OperandsNrException e) {
            Assertions.assertTrue(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }
}
