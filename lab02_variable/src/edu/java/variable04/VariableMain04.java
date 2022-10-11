package edu.java.variable04;

import java.util.Scanner;

public class VariableMain04 {

    public static void main(String[] args) {
        // 콘솔 창에서 키보드로 숫자를 입력받아서 변수에 저장.
        // 1. Scanner 타입의 변수를 선언하고 초기화.
        Scanner scanner = new Scanner(System.in);

        System.out.println("정수를 입력>>>");

        // 2. Scanner 객체를 사용해서 콘솔 창에서 정수를 입력받고 저장.
        int number = scanner.nextInt();
        System.out.println("number = " + number);

        // java 시험 점수(정수)를 입력
        // SQL 시험 점수를 입력
        // JSP 시험 점수를 입력
        // 세 과목의 총점(정수)을 계산하고 출력
        // 세 과목의 평균(실수)을 계산하고 출력

        Scanner javasco = new Scanner(System.in);
        System.out.println("java 시험 점수를 입력하세요.");
        Scanner sqlsco = new Scanner(System.in);
        System.out.println("sql 시험 점수를 입력하세요.");
        Scanner jspsco = new Scanner(System.in);
        System.out.println("jsp 시험 점수를 입력하세요.");

        // Ctrl+Shift+F: 소스 코드 포맷팅(자동 정렬)

    }

}
