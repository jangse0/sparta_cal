package com.example.calculator.lv3;

import java.util.*;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private List<Double> results = new ArrayList<>();

    public double calculate(T x, T y, OperatorType operator) {
        double a = x.doubleValue();
        double b = y.doubleValue();
        double result;

        switch (operator) {
            case ADD:
                result = a + b;
                break;
            case SUB:
                result = a - b;
                break;
            case MUL:
                result = a * b;
                break;
            case DIV:
                if (b == 0)
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("올바른 연산자(+, -, *, /)를 입력해주세요.");
        }
        results.add(result);
        return result;
    }

    //특정 값보다 큰 결과만 출력
    public List<Double> GreaterFilter(double threshold) {
        return results.stream().filter(r-> r>threshold).collect(Collectors.toList());
    }

    // Getter
    public List<Double> getResults() {
        return results;
    }

    //Setter
    public void setResults(List<Double> results){
        this.results = results;
    }

    public Double removeOldResult() {
        if (results.isEmpty())
            return null;
        return results.remove(0);
    }

}
