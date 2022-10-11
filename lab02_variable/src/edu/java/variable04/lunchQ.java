package edu.java.variable04;

import java.util.Scanner;

public class lunchQ {

    public static void main(String[] args) {
        Scanner sco = new Scanner(System.in);

        System.out.println("java 시험 점수를 입력하세요.");
        int javaNumber = sco.nextInt();
        System.out.println("sql 시험 점수를 입력하세요.");
        int sqlNumber = sco.nextInt();
        System.out.println("jsp 시험 점수를 입력하세요.");
        int jspNumber = sco.nextInt();

        double a, b;

        a = javaNumber + sqlNumber + jspNumber;
        b = (a / 3);

        System.out.println("세 시험 총점: " + a);
        System.out.println("세 시험 평균: " + b);

    }

}
