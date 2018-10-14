import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rpn_calculator.DoubleOperand;

import java.util.ArrayDeque;

public class DoubleOperandTest {
    @Test
    public void testAddToStack() {
        ArrayDeque<Double> stack = new ArrayDeque<Double>();
        DoubleOperand operand1 = new DoubleOperand(3.0);
        DoubleOperand operand2 = new DoubleOperand(4.0);
        operand1.processNode(stack);
        operand2.processNode(stack);
        Double expected = operand2.getValue();
        Double res = stack.pop();
        Assertions.assertEquals(expected, res, "Adding DoubleOperand elements in the stack failed!");
    }
}
