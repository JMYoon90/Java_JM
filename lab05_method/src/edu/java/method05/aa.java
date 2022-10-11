package edu.java.method05;

public class aa {

    public static void main(String[] args) {
        int[] scores = {70, 60, 100, 50, 80};
        
        int sum = 0;
        for(int i : scores) {
            sum += i;
        }
        int mean = sum / scores.length;
        int a= 0;
        for(int i = 0; i < scores.length; i++) {
             a += (scores[i] - mean) * (scores[i] - mean);  
        }
        double b = (double) a / scores.length;
        System.out.println(b);
    }

}
