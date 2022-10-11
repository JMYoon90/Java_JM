package edu.java.class04;

public class ClassMain04 {

    public static void main(String[] args) {
        
        double r = 4;
        
        Circle circle = new Circle(r);
        System.out.println("cirlce = " + circle);
        System.out.println("반지름의 길이 = " + circle.r);
        System.out.println("원의 둘레길이 = " + circle.circumference());
        System.out.println("원의 넓이 = " + circle.area());
                
        // argument를 갖는 생성자 이용.
        Circle circle2 = new Circle(10);
        System.out.println("cirlce2 = " + circle2);
        System.out.println("반지름의 길이 = " + circle2.r);
        System.out.println("원의 둘레길이 = " + circle2.circumference());
        System.out.println("원의 넓이 = " + circle2.area());
        
        // 생성자를 호출할 때마다 메모리의 다른 주소에 다른 객체가 만들어짐.
        
        Circle circle3 = new Circle(10);
        System.out.println("circle3 = " + circle3);
        
    }

}
