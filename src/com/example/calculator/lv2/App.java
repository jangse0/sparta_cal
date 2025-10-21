package com.example.calculator.lv2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Calculator cal2 = new Calculator();

        while (true){ //exit이 입력되면 break
            try{
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = scanner.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = scanner.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = scanner.next().charAt(0);

                double result = cal2.calculate(num1, num2, operator);
                System.out.println("----------------\n결과는 " + result);
            }catch(InputMismatchException e){   //잘못된 입력 처리
                System.out.println("양의 정수(0포함)를 입력하세요.");
                scanner.nextLine();
                continue;
            }
            catch (IllegalArgumentException | ArithmeticException e){
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("더 계산하시겠습니까? 계속 하시려면 Enter키\n(exit: 종료/del: 가장 오래된 결과 삭제/edit: 저장된 결과 수정/list: 결과 목록)");
            scanner.nextLine();
            String answer = scanner.nextLine();

            if (answer.equals("exit")){
                System.out.println("계산기를 종료합니다");
                break;
            }
            else if (answer.equals("del")){
                Double remove = cal2.removeOldResult();
                if(remove == null)
                    System.out.println("삭제할 결과가 없습니다.");
                else
                    System.out.println("삭제 완료");

            }
            else if (answer.equals("edit")){
                List<Double> resultList = cal2.getResults();

                if (resultList.isEmpty()){
                    System.out.println("수정할 결과가 없습니다.");
                    continue;
                }
                System.out.println("현재 저장된 값: "+resultList);
                System.out.print("몇 번째 결과 값을 수정할까요?(1~" +  resultList.size() + "):");
                int i = scanner.nextInt() - 1; //인덱스 값
                if (i < 0 || i >= resultList.size()){ // 범위 밖인 경우
                    System.out.println("잘못된 번호입니다.");
                    continue;
                }

                System.out.println("새로운 결과 값을 입력하세요.");
                double newValue = scanner.nextDouble();

                resultList.set(i, newValue);
                cal2.setResults(resultList);

                System.out.println("수정 완료");


            }
            else if (answer.equals("list")){
                System.out.println("저장된 결과 목록 :" + cal2.getResults());
            }
        }

        scanner.close();
    }

}
