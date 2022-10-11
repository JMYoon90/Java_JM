package edu.java.class03;

public class ClassMain03 {

    public static void main(String[] args) {
        // Rectangle 타입 변수 선언, Rectangle 객체 생성 저장.
        
        // Rectangle 객체의 메서드 테스트
        
        double x = 3;
        double y = 4;

        Rectangle rect1 = new Rectangle();
        System.out.println("rect1 가로 = " + rect1.horizontal);
        System.out.println("rect1 세로 = " + rect1.vertical);
        System.out.println("rect1 둘레 = " + rect1.circumference());
        System.out.println("rect1 넓이 = " + rect1.area());
                
        System.out.println(("----------------"));
        Rectangle rect2 = new Rectangle(x, y);
        
        System.out.println("rect2 가로 = " + rect2.horizontal);
        System.out.println("rect2 세로 = " + rect2.vertical);
        System.out.println("rect2 둘레 = " + rect2.circumference());
        System.out.println("rect2 넓이 = " + rect2.area());
        

    }

}
