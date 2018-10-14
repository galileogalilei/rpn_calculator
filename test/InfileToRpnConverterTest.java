import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rpn_calculator.CalculatorService;
import rpn_calculator.DefaultOperatorsBuilderService;

public class InfileToRpnConverterTest {
    private CalculatorService calculatorService;
    private DefaultOperatorsBuilderService builderService;

    @Test
    public void CalculatorServiceFirstInputTest() {
        this.builderService = new DefaultOperatorsBuilderService();
        this.builderService.build();
        this.calculatorService = new CalculatorService();
        this.calculatorService.setOperatorsBuilderService(this.builderService);
        String input = "1 + 99";
        try {
            String res = this.calculatorService.convertInfileToRpn(input);
            String expected = "1 99 +";
            Assertions.assertEquals(expected, res, "Calculate (3+4+5) + 3 . failure! ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail(e.getMessage());
        }

    }
}
