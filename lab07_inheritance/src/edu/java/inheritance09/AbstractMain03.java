package edu.java.inheritance09;

public class AbstractMain03 {

    public static void main(String[] args) {
        // Rectangle, Circle 클래스를 구현(implement)
        // Rectangle, Circle 타입의 객체에서 draw() 메서드 동작 여부 테스트
        
       Shape cir = new Circle(10, "Circle");
       
       cir.draw();
       
       Shape rec = new Rectangle(5, 10, "Rectangle");
       
       rec.draw();
       
       Square square = new Square(5, "Rectangle");
       
       square.draw();

    }

}
