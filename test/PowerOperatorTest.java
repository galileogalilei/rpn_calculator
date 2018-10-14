import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import rpn_calculator.DefaultOperatorsBuilderService;
import rpn_calculator.DoubleOperator;

import java.util.LinkedList;

public class PowerOperatorTest {
    private DefaultOperatorsBuilderService operatorsBuilder;
    protected DoubleOperator testedOperator;

    public PowerOperatorTest() {
        this.operatorsBuilder = new DefaultOperatorsBuilderService();
        this.operatorsBuilder.build();
        this.testedOperator = this.operatorsBuilder.getOperatorBySymbol("^");
    }

    @Test
    public void testPowerIsCorrect() {
        LinkedList<Double> operands = new LinkedList<Double>();
        operands.add(3.0);
        operands.add(2.0);
        Double expected = (double) 8;
        try {
            Double res = this.testedOperator.applyOperatorLogic(operands);
            Assertions.assertEquals(expected, res, "Applying " + this.testedOperator.getSymbol() + " operator for operands " + operands + "failed");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}
