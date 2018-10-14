import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rpn_calculator.DefaultOperatorsBuilderService;
import rpn_calculator.DoubleOperator;

import java.util.LinkedList;

public class DotOperatorTest {
    private DefaultOperatorsBuilderService operatorsBuilder;
    protected DoubleOperator testedOperator;

    public DotOperatorTest() {
        this.operatorsBuilder = new DefaultOperatorsBuilderService();
        this.operatorsBuilder.build();
        this.testedOperator = this.operatorsBuilder.getOperatorBySymbol(".");
    }

    @Test
    public void testPrintTopToken() {
        LinkedList<Double> operands = new LinkedList<Double>();
        operands.add(5.0);
        Double expected = Double.NaN;
        try {
            Double res = this.testedOperator.applyOperatorLogic(operands);
            Assertions.assertEquals(expected, res, "Applying " + this.testedOperator.getSymbol() + " operator for operands " + operands + "failed");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}
