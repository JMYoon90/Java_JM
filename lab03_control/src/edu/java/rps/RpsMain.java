package edu.java.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsMain {

    public static void main(String[] args) {
        // 가위바위보, 369.
        
        /*
         *  int computer = 난수
         *  int user = 스캐너 입력
         *  print(computer : user)
         *  누가 이겼는 지 출력
         */

        Random random = new Random();
        int computer = random.nextInt(3);
        Scanner scanner = new Scanner(System.in);
        System.out.println("가위바위보 중 낼 것을 정하세요.(0:가위, 1:바위, 2:보)");
        int user = scanner.nextInt();
        
        System.out.println("computer = " + computer);
        System.out.println("user = " + user);
        
        
        switch( computer ) {
        case 0:
            if( user == 0 ) {
                System.out.println("비겼습니다.");
            }else if( user == 1) {
                System.out.println("이겼습니다.");
            }else {
                System.out.println("패배했습니다.");
            }
            break;
        case 1:
            if( user == 0) {
                System.out.println("패배했습니다.");
            }else if( user == 1) {
                System.out.println("비겼습니다.");
            }else {
                System.out.println("이겼습니다.");
            }
            break;
        case 2:
            if( user == 0) {
                System.out.println("이겼습니다.");
            }else if( user == 1) {
                System.out.println("패배했습니다.");
            }else {
                System.out.println("비겼습니다.");
            }
            break;
        }

        /*
         * 00 비김
         * 01 이김 
         * 02 짐 
         * 10 짐 
         * 11 비김 
         * 12 이김 
         * 20 이김 
         * 21 짐 
         * 22 비김
         */        
        if (user == computer) {
            System.out.println("비겼습니다.");
        } else if((user == 0 && computer == 2)
                ||(user == 1 && computer == 0)
                ||(user == 2 && computer == 1)) {
            System.out.println("이겼습니다.");
        } else {System.out.println("패배했습니다.");
        }
    }

}
