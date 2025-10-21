package com.example.calculator.lv3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator cal3 = new ArithmeticCalculator();

        boolean running = true;

        while (running) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double num1 = scanner.nextDouble();
                System.out.print("두 번째 숫자를 입력하세요: ");
                double num2 = scanner.nextDouble();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = scanner.next().charAt(0);

                double result = cal3.calculate(num1, num2, OperatorType.valueOf(operator));
                System.out.println("----------------\n결과는 " + result);
            } catch(InputMismatchException e){
                System.out.println("실수를 입력하세요.");
                scanner.nextLine();
                continue;
            }
            catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println(e.getMessage());
                continue;
            }

            scanner.nextLine();
            boolean askAgain = true;

            while (askAgain) {
                System.out.println("더 계산하시겠습니까? 계속 하시려면 Enter키\n" +
                        "(exit: 종료/del: 가장 오래된 결과 삭제/edit: 저장된 결과 수정/list: 결과 목록/filter: 특정값 이상 결과 조회)");
                String answer = scanner.nextLine();

                if (answer.equals("exit")) {
                    running = false;
                    askAgain = false;
                    System.out.println("계산기를 종료합니다");
                    break;
                } else if (answer.equals("del")) {
                    Double remove = cal3.removeOldResult();
                    if (remove == null)
                        System.out.println("삭제할 결과가 없습니다.");
                    else
                        System.out.println("삭제 완료");
                } else if (answer.equals("edit")) {
                    List<Double> resultList = cal3.getResults();

                    if (resultList.isEmpty()) {
                        System.out.println("수정할 결과가 없습니다.");
                        continue;
                    }
                    System.out.println("현재 결과 목록: " + resultList);
                    System.out.print("몇 번째 결과 값을 수정할까요?(1~" + resultList.size() + "):");
                    int i = scanner.nextInt() - 1; //인덱스
                    if (i < 0 || i >= resultList.size()) {
                        System.out.println("잘못된 번호입니다.");
                        continue;
                    }

                    System.out.println("새로운 결과 값을 입력하세요.");
                    double newValue = scanner.nextDouble();

                    resultList.set(i, newValue);
                    cal3.setResults(resultList);

                    System.out.println("수정 완료");
                } else if (answer.equals("list")) {
                    System.out.println("저장된 결과 목록 :" + cal3.getResults());
                } else if (answer.equals("filter")) {
                    System.out.print("기준값을 입력하세요: ");
                    double threshold = scanner.nextDouble();
                    scanner.nextLine();
                    List<Double> filtered = cal3.GreaterFilter(threshold);
                    System.out.println(threshold + "보다 큰 결과: " + filtered);
                } else if (answer.isEmpty()) {
                    askAgain = false;
                } else {
                    askAgain = false;
                }
            }
        }
    }
}
