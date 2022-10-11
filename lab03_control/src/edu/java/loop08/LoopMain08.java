package edu.java.loop08;

public class LoopMain08 {

    public static void main(String[] args) {
        // 중첩 반복문
        for(int m = 2; m < 10; m++) {
            for(int n = 1; n < 10; n++) {
                System.out.println(m + " x " + n + " = " + (m*n));
            }
            System.out.println("----------");
        }
        
        int m = 2, n = 1;
        while (m < 10) {
            System.out.println("--- " + m + "단 ---");
            n = 1;
            while (n < 10) {
                System.out.println(m + " x " + n + " = " + m*n);
                n++;
            }
            m++;
        }
        
        System.out.println();
        
        // 2단은 2x2까지만, 3단은 3x3까지만..9x9까지
        // for 반복문
        for (int a = 2; a < 10; a++) {
            System.out.println("--- " + a + "단 ---");
            for(int b = 1; b <= a; b++) {
                System.out.println(a + " x " + b + " = " + a*b);
            }
        }
        
        System.out.println();
        // while 반복문
        int a = 2, b = 1;
        while (a < 10) {
            System.out.println("--- " + a + "단 ---");
            b = 1;
            while (b <= a) {
                System.out.println(a + " x " + b + " = " + a*b);
                b++;
            }
            a++;
        }
        // break 사용시
        for(a = 2; a < 10; a++) {
            System.out.println("--- " + a + "단 ---");
            for(b = 1; b < 10; b++) {
                System.out.println(a + " x " + b + " = " + a*b);
            if (a == b) {
                break;
                }
            }
        }
        
        a = 2;
        while (a < 10) {
            System.out.println("--- " + a + "단 ---");
            b = 1;
            while(b < 10) {
                System.out.println(a + " x " + b + " = " + a*b);
                if (a == b) {
                    break;
                }
                b++;
                
            }
            a++;
            
        }
        
    }

}
