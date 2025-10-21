package com.example.calculator.lv1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            int n1, n2;
            double result;

            //양의 정수가 입력될 때까지 다시 입력받는다.
            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                n1 = scanner.nextInt();
                if (n1 < 0) {
                    System.out.print("양의 정수(0포함)를 입력하세요.\n");
                } else
                    break;
            }

            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                n2 = scanner.nextInt();
                if (n2 < 0) {
                    System.out.print("양의 정수(0포함)를 입력하세요.\n");
                } else
                    break;
            }


            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator= scanner.next().charAt(0);

            switch (operator) {
                case '+':
                    result = n1 + n2;
                    break;
                case '-':
                    result = n1 - n2;
                    break;
                case '*':
                    result = n1 * n2;
                    break;
                case '/':
                    if (n2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                    result = (double)n1 / n2;
                    break;
                default:
                    System.out.println("\n올바른 연산자(+, -, *, /)를 입력해주세요.\n");
                    continue;
            }


            System.out.println("---------------\n결과는 "+ result);
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) 계속 하시려면 아무키를 입력하세요.");

            if (scanner.next().equals("exit"))
                break;
        }
    }
}