package Shapes;

import Shapes.Abstract_classes.Shape2D;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Circle extends Shape2D {

    private Point center;
    private double radius;
    private String color;

    @JsonCreator
    public Circle(@JsonProperty("center") Point center,@JsonProperty("radius") double radius, @JsonProperty("color") String color){
        this.center=center;
        this.radius=radius;
        this.color=color;
    }

    public Circle(Point center,double radius){
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

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
