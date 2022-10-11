package edu.java.array09;

import java.util.Scanner;

public class ArrayMain09 {

    public static void main(String[] args) {
        boolean run = true; //프로그램을 계속 실행할 지, 종료할 지를 결정하기 위한 변수.
        int studentNum = 0; // 입력받은 학생수를 저장할 변수.
        int[] scores = null; // 학생들의 점수를 저장할 변수. Null : 배열이 아직 만들어지지 않음.
        Scanner scanner = new Scanner(System.in);
        
        while(run) {
            System.out.println("-------------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4. 분석 | 5.종료");
            System.out.println("-------------------------------------------------------");
            System.out.print("선택> ");
            
            // 콘솔창에서 문자열을 입력받아서 int로 변환.
            int selectNo = Integer.parseInt(scanner.nextLine());
            
            if(selectNo == 1) {
                System.out.print("학생수> ");
              studentNum = Integer.parseInt(scanner.nextLine());
              scores = new int[studentNum];
              System.out.printf("입력된 학생수 : %d명"+ "\n", studentNum);
            } else if(selectNo == 2) {
                if(scores != null) {
                    for(int i = 0; i < scores.length; i++) {
                        System.out.printf("scores[%d]> ", i);
                        scores[i] = Integer.parseInt(scanner.nextLine());
                    }
                } else {
                    System.out.println("     학생수를 먼저 작성해주세요." + "\n" + "     초기 메뉴로 돌아갑니다");
                }
                
                /* if(Scores == null){
                 * System.out.println("     학생수를 먼저 작성해주세요." + "\n" + "     초기 메뉴로 돌아갑니다");
                 * continue;
                 * }
                 * for(int i = 0; i < scores.length; i++) {
                 *     System.out.printf("scores[%d]> ", i);
                 *     scores[i] = Integer.parseInt(scanner.nextLine());
                 */
            } else if(selectNo == 3) {
                if(scores != null) {
                    for(int i = 0; i < scores.length; i++) {
                        System.out.println("scores[" + i + "]> " + scores[i]);
                    }
                    System.out.println();
                } else { 
                    System.out.println("     학생수를 먼저 작성해주세요." + "\n" + "     초기 메뉴로 돌아갑니다");
                }
            } else if(selectNo == 4) {
                if(scores != null) {
                    int max = scores[0];
                    double sum = 0, avg = 0;
                    
                    for(int n : scores) {
                        max = (max < n) ? n : max;
                        sum += n; 
                    }
                    avg = sum / studentNum;
                    System.out.println("최고 점수: " + max);
                    System.out.println("평균 점수: " + avg);
                } else { 
                    System.out.println("     학생수를 먼저 작성해주세요." + "\n" + "     초기 메뉴로 돌아갑니다");
                }
            } else if(selectNo == 5) {
                run = false;
            } else { 
                System.out.println("     1 - 5번 메뉴를 입력해주세요.");
            }
        }
        System.out.println("프로그램 종료");
    }

}
