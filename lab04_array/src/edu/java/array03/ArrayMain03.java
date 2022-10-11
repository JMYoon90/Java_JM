package edu.java.array03;

import java.util.Random;

public class ArrayMain03 {

    public static void main(String[] args) {
        // Random 객체를 선언, 생성.
        // 정수 10개를 저장할 수 있는 배열(scores)을 선언.
        // 배열 scores에 0 이상 10이하의 정수 난수 10개를 저장.
        // 배열 scores에 저장된 모든 정수들의 합계를 계산하고 출력.
        // 배열 scores에 저장된 모든 정수들의 평균을 소수점까지 계산해서 출력.
        Random random = new Random();
        int[] scores = new int[10];
        int sum = 0;
        double avg = 0;
        
        for(int n = 0; n < scores.length; n++) {
            scores[n] = random.nextInt(11);
            sum = sum + scores[n];
            avg = (double)sum / scores.length;
        }
        for(int n : scores) {
            System.out.print(n + ", ");
        }
        System.out.println();
        System.out.println("sum = " + sum);
        System.out.println("avg = " + avg);
    }

}
