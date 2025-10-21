package com.example.calculator.lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Double> results = new ArrayList<>();

    public double calculate(int a, int b, char operator)
    {
        if(a<0 || b<0){ //음수 입력 시
            throw new IllegalArgumentException("양의 정수(0포함)를 입력하세요.\n");
        }

        double c;

        switch (operator){
            case '+': c = a+b; break;
            case '-': c = a-b; break;
            case '*': c = a*b; break;
            case '/':
                if (b==0){ //분모가 0일 때
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                c=(double)a/b; break;
            default: //연산자 외에 다른 입력이 들어왔을 때
                throw new IllegalArgumentException("올바른 연산자(+, -, *, /)를 입력해주세요.");

        }

        results.add(c);
        return c;
    }
    
    //가장 오래된 결과 삭제
    public Double removeOldResult()
    {
        if (results.isEmpty()) return null;
        return results.remove(0);
    }

    //Getter
    public List<Double> getResults()
    {
        return results;
    }

    //Setter
    public  void setResults(List<Double> results)
    {
        this.results = results;
    }
}
