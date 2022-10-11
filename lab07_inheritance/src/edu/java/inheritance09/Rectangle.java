package edu.java.inheritance09;

public class Rectangle extends Shape{
    private double width;
    private double height;
    
    public Rectangle(double width, double height, String type) {
        super(type);
        this.width = width;
        this.height = height;
    }
    @Override
    public double area() {
        double result = this.width * this.height;
        return result;
    }
    @Override
    public double perimeter() {
        double result = 2 * (this.width + this.height);
        return result;
    }
    
}
