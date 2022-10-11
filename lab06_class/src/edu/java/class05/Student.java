package edu.java.class05;

public class Student {
    // field
    int stuNo; // 학번
    String stuName; // 학생 이름
    Score score; //국,영,수 점수

    //constructor
    // (1) 기본 생성자
    public Student() {}
    // (2) argument: int, String, score
    public Student(int stuNo, String stuName, Score score) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.score = score;
    }
    // (3) argument: int, String, int, int, int
    public Student(int stuNo, String stuName, int korean, int english, int math) {
//        this.stuNo = stuNo;
//        this.stuName = stuName;
//        this.score = new Score(korean, english, math);
        this(stuNo, stuName, new Score(korean, english, math));
        
    }
    // method - 학생 정보(학번, 이름, 각 과목 점수, 총점, 평균)를 출력
    public void stuinfo() {
        System.out.println("학번: " + this.stuNo + "\n" + "이름: " + this.stuName);
        if(score != null) {
            score.printSco();
            System.out.println("총점: " + score.sumSco() + "\n" + "평균: " + score.avgSco());
        }else {
            System.out.println("점수: null\n"
                    + "총점: null\n"
                    + "평균: null");
        }
        
        
    }

}
