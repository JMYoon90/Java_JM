package edu.java.class05;

public class ClassMain05 {

    public static void main(String[] args) {
        // score 타입의 객체 생성, 메서드들을 테스트.
        Score score2 = new Score(100, 80, 90);
            score2.printSco();
            System.out.println("합계: " + score2.sumSco());
            System.out.println("평균: " + score2.avgSco());
            
            System.out.println("-------------------");
            
        // student 타입의 객체 생성, 메서드를 테스트.
        Student stu2 = new Student(1, "JM", score2);
            stu2.stuinfo();
            
            System.out.println("-------------------");
            
            Student stu3 = new Student(2, "허균", null);
            
            stu3.stuinfo();
            
            System.out.println("-------------------");
            
            Student stu4 = new Student(3, "오쌤", new Score());
            stu4.stuinfo();
            
            Student stu5 = new Student(4, "재만", 50, 60, 70);
            stu5.stuinfo();
    }

}
