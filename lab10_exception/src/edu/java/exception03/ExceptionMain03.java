package edu.java.exception03;

import java.util.Scanner;

public class ExceptionMain03 {
    
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ExceptionMain03 app = new ExceptionMain03();
        
        int x = app.inputInteger();
        System.out.println("x = " + x);

    }
    
    private int inputInteger() {
        // TODO: Scanner를 사용해서 입력받은 정수를 리턴.
        // Integer.parseInt(), Scanner.nextLine() 사용.
        // NumberFormatException을 처리.
        boolean run = true;
        int number = 0;
        while(run) {
            try {
                System.out.println("정수를 입력하세요.");
                System.out.print("입력>> ");
                number = Integer.parseInt(scanner.nextLine());
                run = false;
            } catch (NumberFormatException e) {
                System.out.println("입력한 문자열은 정수로 변환 불가");
                System.out.println(e.getMessage());
            }
        }
        return number;
    }

}
