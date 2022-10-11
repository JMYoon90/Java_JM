package edu.java.condition05;

import java.util.Random; // Ctrl + Shift + 0 : optimize import(import문 최적화)

public class ConditionMain05 {

    public static void main(String[] args) {
        // Random 타입 변수를 선언하고, 초기화
        // Java 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        // SQL 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        // JSP 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        // 세 과목의 평균을 계산.
        // 모든 과목의 점수가 40점 이상이고, 평균이 60점 이상이면 "합격",
        // 그렇지 않으면 "불합격" 출력
        
        Random random = new Random();
        int java = random.nextInt(101);
        int sql = random.nextInt(101);
        int jsp = random.nextInt(101);
        double avg = ((java + sql + jsp) / 3.0);
        System.out.println("Java = " + java + "점");
        System.out.println("SQL = " + sql + "점");
        System.out.println("JSP = " + jsp + "점");
        System.out.println("avg = " + avg + "점");
        
        String pass = (java>=40) && (sql>=40) && (jsp>=40) && (avg>=60) ? "합격" : "불합격" ;
        System.out.println("귀하는 " + pass + "입니다");
    }
}
