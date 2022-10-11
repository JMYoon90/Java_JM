package edu.java.inheritance09;

public class Circle extends Shape {
    private double radius;
    public Circle(double radius, String type) {
        super("Circle");
        this.radius = radius;
    }
    @Override
    public double area() {
        double result = Math.PI * (this.radius * this.radius);
        return result;
    }
    @Override
    public double perimeter() {
        double result = 2 * Math.PI * this.radius;
        return result;
    }
    
    
}
