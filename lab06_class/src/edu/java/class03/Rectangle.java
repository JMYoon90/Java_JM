package edu.java.class03;

// class = field + constructor + method ==> data type
public class Rectangle {
    // field - 가로, 세로
    // constructor - 기본 생성자, argument 2개를 갖는 생성자.
    // method - 둘레 길이, 넓이를 리턴하는 메소드.
    
    double horizontal; 
    double vertical; 
    
    public Rectangle() {}

    public Rectangle(double horizontal, double vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }
    
    public double circumference() {
        double cv = 2 * (this.horizontal + this.vertical);
        return cv;
    }
    
    public double area() {
        double ar = this.horizontal * this.vertical;
        return ar;
    }
}