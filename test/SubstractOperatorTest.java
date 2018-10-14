import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rpn_calculator.DefaultOperatorsBuilderService;
import rpn_calculator.DoubleOperator;

import java.util.LinkedList;

public class SubstractOperatorTest {
    private DefaultOperatorsBuilderService operatorsBuilder;
    protected DoubleOperator testedOperator;

    public SubstractOperatorTest() {
        this.operatorsBuilder = new DefaultOperatorsBuilderService();
        this.operatorsBuilder.build();
        this.testedOperator = this.operatorsBuilder.getOperatorBySymbol("-");
    }


    @Test
    public void testDiffIsCorrect() {
        LinkedList<Double> operands = new LinkedList<Double>();
        operands.add(4.5);
        operands.add(2.5);
        Double expected = (double) 2.0;
        try {
            Double res = this.testedOperator.applyOperatorLogic(operands);
            Assertions.assertEquals(expected, res, "Applying " + this.testedOperator.getSymbol() + " operator for operands " + operands + "failed");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}
