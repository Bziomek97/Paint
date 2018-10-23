package Shapes;

import Shapes.Abstract_classes.Shape2D;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Rectangle extends Shape2D {

    private Point point;
    private double width, heigth;
    private String color;

    @JsonCreator
    public Rectangle(@JsonProperty("point") Point point,@JsonProperty("width") double width,@JsonProperty("height") double heigth,@JsonProperty("color") String color) {
        this.heigth = heigth;
        this.point = point;
        this.heigth = heigth;
        this.color = color;
    }

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

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
