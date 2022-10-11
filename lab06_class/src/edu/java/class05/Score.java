package edu.java.class05;

public class Score {
    // field
    int korean;
    int english;
    int math;
    
    // constructor - 기본 생성자, argument를 갖는 생성자.
    public Score() {}
    public Score(int korean, int english, int math) {
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
    // method
    // 세 과목의 점수를 출력
    public void printSco() {
        System.out.println("국어: " + this.korean);
        System.out.println("영어: " + this.english);
        System.out.println("수학: " + this.math);
    }
    // 세 과목의 총점을 리턴
    public int sumSco() {
        return this.korean + this.english + this.math ;
    }
    // 세 과목의 평균을(소수점까지 계산)을 리턴 
    public double avgSco() {
        return (double) sumSco() / 3 ;
    }
    

}
