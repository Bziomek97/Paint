package Shapes;

import Shapes.Abstract_classes.Shape2D;

public class Circle extends Shape2D {

    private Point center;
    private double radius;
    private String color;

    public Circle(Point center, double radius){
        this.center=center;
        this.radius=radius;
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*this.radius;
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(this.radius,2);
    }

    @Override
    public void color(String color) {
        this.color=color;
    }
}
