import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rpn_calculator.CalculatorService;
import rpn_calculator.DefaultOperatorsBuilderService;

public class CalculatorServiceTest {
    private CalculatorService calculatorService;
    private DefaultOperatorsBuilderService builderService;

    @Test
    public void CalculatorServiceFirstInputTest() {
        this.builderService = new DefaultOperatorsBuilderService();
        this.builderService.build();
        this.calculatorService = new CalculatorService();
        this.calculatorService.setOperatorsBuilderService(this.builderService);
        String input = "3 4 5 SUM 3 + .";
        try {
            Double res = this.calculatorService.calculate(input);
            Double expected = Double.NaN;
            Assertions.assertEquals(expected, res, "Calculate (3+4+5) + 3 . failure! ");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }

    @Test
    public void CalculatorServiceSecondInputTest() {
        this.builderService = new DefaultOperatorsBuilderService();
        this.builderService.build();
        this.calculatorService = new CalculatorService();
        this.calculatorService.setOperatorsBuilderService(this.builderService);
        String input = "4 5 7 8 AVG 2 / .";
        try {
            Double res = this.calculatorService.calculate(input);
            Double expected = Double.NaN;
            Assertions.assertEquals(expected, res, "Calculate (3+4+5) + 3 . failure! ");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }

    @Test
    public void CalculatorServiceThirdInputTest() {
        this.builderService = new DefaultOperatorsBuilderService();
        this.builderService.build();
        this.calculatorService = new CalculatorService();
        this.calculatorService.setOperatorsBuilderService(this.builderService);
        String input = "1 2 + 8 6 MIN 10 * .";
        try {
            Double res = this.calculatorService.calculate(input);
            Double expected = Double.NaN;
            Assertions.assertEquals(expected, res, "Calculate (3+4+5) + 3 . failure! ");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }

    @Test
    public void CalculatorServiceFourthInputTest() {
        this.builderService = new DefaultOperatorsBuilderService();
        this.builderService.build();
        this.calculatorService = new CalculatorService();
        this.calculatorService.setOperatorsBuilderService(this.builderService);
        String input = "2 3 ^ 5 + .";
        try {
            Double res = this.calculatorService.calculate(input);
            Double expected = Double.NaN;
            Assertions.assertEquals(expected, res, "Calculate (3+4+5) + 3 . failure! ");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }
}
