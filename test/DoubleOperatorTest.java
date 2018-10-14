import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rpn_calculator.DefaultOperatorsBuilderService;
import rpn_calculator.DoubleOperand;
import rpn_calculator.DoubleOperator;

import java.util.ArrayDeque;

public class DoubleOperatorTest {
    private DefaultOperatorsBuilderService operatorsBuilder;

    public DoubleOperatorTest() {
        this.operatorsBuilder = new DefaultOperatorsBuilderService();
        this.operatorsBuilder.build();
    }

    @Test
    public void testAddFromStack() {
        ArrayDeque<Double> stack = new ArrayDeque<Double>();
        DoubleOperand operand1 = new DoubleOperand(2.0);
        DoubleOperand operand2 = new DoubleOperand(3.0);
        DoubleOperator operator1 = this.operatorsBuilder.getOperatorBySymbol("^");
        operand1.processNode(stack);
        operand2.processNode(stack);
        try {
            operator1.processNode(stack);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
        Double expected = (double) 8;
        Double res = stack.pop();
        Assertions.assertEquals(expected, res, "Adding DoubleOperand elements in the stack failed!");
    }
}
