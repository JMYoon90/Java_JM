package edu.java.method05;

public class MethodMain05 {

    public static void main(String[] args) {
        // 메서드 작성 연습
        
        int[] scores = {70, 60, 100, 50, 80, };
        
        int sum = sum(scores);
        System.out.println("총점 = " + sum); // 360
        
        double avg = mean(scores);
        System.out.println("평균 = " + avg); // 72.0
        
        int max = max(scores);
        System.out.println("최대값 = " + max); // 100
        
        int min = min(scores);
        System.out.println("최소값 = " + min); // 50
        
        double variance = variance(scores);
        System.out.println("분산값 = " + variance); 

        double std = std(scores);
        System.out.println("표준편차 = " + std);
    }
    public static int sum(int[] n) {
        int sum = 0;
        for(int a : n) {
            sum += a;
        }
        return sum;
    }
    public static double mean(int[] n) {
        int sum = sum(n);
        double mean = (double)sum / n.length ;
        return mean;
    }
    public static int max(int[] n) {
        int max = n[0];
        for(int i : n) {
            max = max < i ? i : max;
        }
        return max;
    }
    public static int min(int[] n) {
        int min = n[0];
        for(int i : n) {
            min = min > i ? i : min;
        }
        return min;
    }
    public static double variance(int[] n) {
        double avg = mean(n);
        double a = 0;
        for(int i = 0; i < n.length; i++) {
            a += (n[i] - avg) * (n[i] - avg);  
       }    
       double b = (double) a / n.length;
        return b ;
    }
    public static double std(int[] n) {
        return Math.sqrt(variance(n));
    }

}
