package edu.java.array08;

import java.util.Random;

public class ArrayMain08 {

    public static void main(String[] args) {
        // Ch. 6-2 Ex. 5(p201)
        // 1차원 정수 배열 3개를 갖는 2차원 배열을 선언.
        // 첫번째 배열에는 난수 2개, 두번째 배열에는 난수 3개, 세번째 배열에는 난수 4개를 저장.
        // 난수의 범위는 [70, 100). == 70 이상 100 미만
        // 2차원 배열 array의 모든 원소들 합(sum)을 계산하고 출력.
        // 2차원 배열 array의 모든 원소들의 평균을 계산하고 출력.
        
        Random random = new Random();
        int[][] array = new int[3][];
        int sum = 0, a = 0;
        double avg = 0;
        for(int i = 0; i < array.length; i++) {
            array[i] = new int[i+2];
            a += (array[i].length);
            for(int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(70,100);
                sum += array[i][j];
                avg = (double)sum / a;
            }
        }
        for(int[] arr : array) {
            for(int ar : arr) {
                System.out.print(ar + " ");
            }
            System.out.println();
        }
        System.out.println("------------");
        System.out.println("sum = " + sum);
        System.out.println("avg = " + avg);

    }

}
