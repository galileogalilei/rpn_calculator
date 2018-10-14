package app;

import rpn_calculator.CalculatorService;
import rpn_calculator.DefaultOperatorsBuilderService;

public class App {
    public static void main(String[] args) {
        CalculatorService calculator = new CalculatorService();
        DefaultOperatorsBuilderService builderService = new DefaultOperatorsBuilderService();
        builderService.build();
        calculator.setOperatorsBuilderService(builderService);
        try {
            calculator.calculate("3 1 2 + * .");
            calculator.calculate("3 4 5 SUM 3 + .");
            calculator.calculate("4 5 7 8 AVG 2 / .");
            calculator.calculate("1 2 + 8 6 MIN 10 * .");
            calculator.calculate("2 3 ^ 5 + .");
            String infileToRpnInput = calculator.convertInfileToRpn("1 + 99");
            System.out.println(infileToRpnInput);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
