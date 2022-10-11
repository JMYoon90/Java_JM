package edu.java.class04;

public class Circle {
    // field - 반지름
    
    // constructor - 기본 생성자, argument를 갖는 생성자
    
    // method - 둘레 길이( 2 3.14 r), 넓이 (3.14r^2)
        
    double r;
    
    public Circle() {}
    public Circle(double r){
        this.r = r;
    }
    
    public double circumference() { // 변수가 1개이므로 this가 생략가능
        double cf = 2 * 3.14 * this.r; // 2 * Math.PI * this.r; 로도 사용가능
        return cf;
    }
    public double area() {
        double ar = 3.14 * (this.r * this.r);
        return ar;
    }
}
