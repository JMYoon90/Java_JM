package edu.java.loop06;

public class LoopMain06 {

    public static void main(String[] args) {
        // for 반복문
        for (int i = 1; i <=5; i++) {
        System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("---------");
        
        // while 반복문
        int n = 1;
        while(n <= 5) {
            System.out.print(n + " ");
            n++;
        }
        System.out.println();
        System.out.println("-----");
        
        // 10부터 1까지 정수들을 내림차순을 한 줄에 출력하세요.(10 9 8 7 ... 3 2 1)
        
        n = 10;
        while(n >= 1) {
            System.out.print(n + " ");
            n--;
        }
        
        System.out.println();
        
        for(n = 10; n>=1; n--) {
            System.out.print(n + " ");
        }
        
        System.out.println();
        System.out.println("-----");
        
        // 이하의 양의 홀수들을 한 줄에 출력하세요.(1 3 5 7 9)
        
        n = 1;
        while(n <=10) {
            System.out.print(n + " ");
            n += 2;
        }
        
        System.out.println();
        
        for(n = 1; n <= 10; n+=2) {
            System.out.print(n + " ");
        }
        
        System.out.println();
        
        n = 1;
        while (n < 10) {
            if(n % 2 == 1) {
                System.out.print(n + " ");
            }
            n++;
        }
        
        
        
    }

}
