package edu.java.condition03;

import java.util.Scanner;

public class ConditionMain03 {

    public static void main(String[] args) {
        //Scanner 타입의 변수 선언, 초기화
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("점수를 입력하세요.");
        int sco = scanner.nextInt();
        
        if (sco >=90) {
            System.out.println("A학점");
        } else if(sco >=80) {
            System.out.println("B학점");
        } else if(sco >=70) {
            System.out.println("C학점");
        } else if(sco >=60) {
            System.out.println("D학점");
        } else {
            System.out.println("F학점");
        }
        
        
    }
}
