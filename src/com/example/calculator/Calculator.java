package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1, n2;

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            n1 = scanner.nextInt();
            if (n1<=0){
                System.out.print("양의 정수(0포함)를 입력하세요.\n");
            }
            else
                break;
        }

        System.out.print("두 번째 숫자를 입력하세요: ");
        n2 = scanner.nextInt();

        System.out.print("사칙연산 기호를 입력하세요: ");
        char simbol = scanner.next().charAt(0);

        switch (simbol) {
            case '+':
                System.out.println(n1 + n2);
                break;
            case '-':
                System.out.println(n1 - n2);
                break;
            case '*':
                System.out.println(n1 * n2);
                break;
            case '/':
                System.out.println(n1 / n2);
                break;
            default:
                System.out.println("+, -, *, / 중 하나를 입력하세요");
        }
    }
}