package Shapes;

import Shapes.Abstract_classes.Shape2D;

public class Rectangle extends Shape2D {

    private Point point;
    private double width, heigth;
    private String color;

    public Rectangle(Point point, double width, double heigth) {
        this.heigth = heigth;
        this.point = point;
        this.heigth = heigth;
    }

    @Override
    public double perimeter() {
        return 2*(width+heigth);
    }

    @Override
    public double area() {
        return width*heigth;
    }

    @Override
    public void color(String color) {
        this.color=color;
    }

}
