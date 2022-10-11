package edu.java.loop05;

public class LoopMain05 {

    public static void main(String[] args) {
        int n;
        for(n=1; n<=100; n++) {
        if(n % 10 == 1) {
            System.out.println();
        }
            int n10 = n / 10;
            int n1 = n % 10;
                if(n10 == 3 || n10 == 6 || n10 == 9) {
                    if (n1 == 3 || n1 == 6 || n1 == 9) {
                        System.out.print("**\t");
                        continue;
                    }
                    System.out.print("*\t");
                }else if (n1 ==3 || n1 == 6 || n1 == 9) {
                    System.out.print("*\t");
                }else {
                    System.out.print(n + "\t");
                }
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println();
        

        for(int i = 1; i <=100; i++) {
            int i1 = i % 10;
            int i10 = i / 10;
            
            boolean b1 = (i1 == 3)|| (i1 == 6) || (i1 == 9);
            boolean b10 = (i10 == 3 ) || (i10 == 6) || (i10 == 9);
            
            if(b1 && b10) { // 만약에 1의 자릿수가 3,6,9이고, 10의 자리수가 3,6,9이면
                System.out.print("**\t");
            }else if (b1 || b10) { // 만약에 1의 자릿수 또는 10의 자리수가 3,6,9이면
                System.out.print("*\t");
            }else {
                System.out.print(i + "\t");
            }
            if(i % 10 == 0) {
                System.out.println();
            }
        }
    }

}
