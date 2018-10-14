package rpn_calculator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;

public class DefaultOperatorsBuilderService {
    private Map<String, DoubleOperator> defaultOperatorsMap = new HashMap<>();
    private Function<LinkedList<Double>, Double> operatorImplementation;

    public Map build() {
        this._addSUMOperator();
        this._addPlusOperator();
        this._addSubstractOperator();
        this._addAVGOperator();
        this._addMinOperator();
        this._addDotOperator();
        this._addMultiplyOperator();
        this._addDivisionOperator();
        this._addPowerOperator();
        return this.defaultOperatorsMap;
    }

    private Map<String, DoubleOperator> _addPlusOperator() {
        this.operatorImplementation = (LinkedList<Double> list) -> {
            Double sum = list.get(0) + list.get(1);
            return sum;
        };
        this.defaultOperatorsMap.put("+", new DoubleOperator("+", this.operatorImplementation, 1, 2));
        return this.defaultOperatorsMap;
    }

    private Map<String, DoubleOperator> _addSubstractOperator() {
        this.operatorImplementation = (LinkedList<Double> list) -> {
            Double diff = list.get(0) - list.get(1);
            return diff;
        };
        this.defaultOperatorsMap.put("-", new DoubleOperator("-", this.operatorImplementation, 1, 2));
        return this.defaultOperatorsMap;
    }

    private Map<String, DoubleOperator> _addSUMOperator() {
        this.operatorImplementation = (LinkedList<Double> list) -> {
            Double sum = (double) 0;
            for (double i : list) {
                sum += i;
            }
            return sum;
        };
        this.defaultOperatorsMap.put("SUM", new DoubleOperator("SUM", this.operatorImplementation, 2));
        return this.defaultOperatorsMap;
    }

    private Map<String, DoubleOperator> _addAVGOperator() {
        this.operatorImplementation = (LinkedList<Double> list) -> {
            Double avg = (double) 0;
            for (Double i : list) {
                avg += i;
            }
            return (avg / list.size());
        };
        this.defaultOperatorsMap.put("AVG", new DoubleOperator("AVG", this.operatorImplementation, 2));
        return this.defaultOperatorsMap;
    }

    private Map<String, DoubleOperator> _addMinOperator() {
        this.operatorImplementation = (LinkedList<Double> list) -> {
            Double min = (double) list.getFirst();

            for (double i : list) {
                if (min > i) {
                    min = i;
                }
            }
            return min;
        };
        this.defaultOperatorsMap.put("MIN", new DoubleOperator("MIN", this.operatorImplementation, 2));
        return this.defaultOperatorsMap;
    }

    private Map<String, DoubleOperator> _addDotOperator() {
        this.operatorImplementation = (LinkedList<Double> list) -> {
            Double first = (Double) list.getFirst();
            System.out.println(first.intValue());
            return Double.NaN;
        };
        this.defaultOperatorsMap.put(".", new DoubleOperator(".", this.operatorImplementation, 3, 1));
        return this.defaultOperatorsMap;
    }

    private Map<String, DoubleOperator> _addMultiplyOperator() {
        this.operatorImplementation = (LinkedList<Double> list) -> {
            Double multiply = list.getFirst() * list.getLast();
            return multiply;
        };
        this.defaultOperatorsMap.put("*", new DoubleOperator("*", this.operatorImplementation, 2, 2));
        return this.defaultOperatorsMap;
    }

    private Map<String, DoubleOperator> _addDivisionOperator() {
        this.operatorImplementation = (LinkedList<Double> list) -> {
            if (list.getLast().equals(0.0)) {
                System.out.println("Throw DivisionByNull Exception here!");
                // have to check how to extend Function Interface and throw DivisionByNull Exception here!
                // Anyway, division by zero will be handled at the next level due to type max overflow Exception!
            }
            Double division = list.getLast() / list.getFirst();
            return division;
        };
        this.defaultOperatorsMap.put("/", new DoubleOperator("/", this.operatorImplementation, 2, 2));
        return this.defaultOperatorsMap;
    }

    private Map<String, DoubleOperator> _addPowerOperator() {
        this.operatorImplementation = (LinkedList<Double> list) -> {
            Double power = Math.pow(list.getLast(), list.getFirst());
            return power;
        };
        this.defaultOperatorsMap.put("^", new DoubleOperator("^", this.operatorImplementation, 3, 2));
        return this.defaultOperatorsMap;
    }

    public DoubleOperator getOperatorBySymbol(String symbol) {
        return this.defaultOperatorsMap.get(symbol);
    }
}
