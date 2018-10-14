import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rpn_calculator.DefaultOperatorsBuilderService;
import rpn_calculator.DoubleOperator;
import rpn_calculator.OperandsNrException;

import java.util.LinkedList;
import java.util.function.Function;

public class MinOperatorTest {
    private DefaultOperatorsBuilderService operatorsBuilder;
    protected DoubleOperator testedOperator;
    protected LinkedList<Double> operands;

    public MinOperatorTest() {
        this.operatorsBuilder = new DefaultOperatorsBuilderService();
        this.operatorsBuilder.build();
        this.testedOperator = this.operatorsBuilder.getOperatorBySymbol("MIN");
    }

    @Test
    public void testMinIsCorrectForMany() {
        LinkedList<Double> operands = new LinkedList<Double>();
        operands.add(3.0);
        operands.add(2.5);
        operands.add(2.2);
        operands.add(8.0);
        operands.add(8.0);
        Double expected = (double) 2.2;
        try {
            Double res = this.testedOperator.applyOperatorLogic(operands);
            Assertions.assertEquals(expected, res, "Applying " + this.testedOperator.getSymbol() + " operator for operands " + operands + "failed");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testMinIsCorrectForOne() {
        LinkedList<Double> operands = new LinkedList<Double>();
        operands.add(5.3);
        Double expected = (double) 5.3;
        try {
            Double res = this.testedOperator.applyOperatorLogic(operands);
            Assertions.assertEquals(expected, res, "Applying " + this.testedOperator.getSymbol() + " operator for operands " + operands + "failed");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}
