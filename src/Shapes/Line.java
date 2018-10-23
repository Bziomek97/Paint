package Shapes;

import Shapes.Abstract_classes.Shape1D;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Line extends Shape1D {

    private Point start,end;
    private String color;
    private double thickness;

    @JsonCreator
    public Line(@JsonProperty("start") Point start,@JsonProperty("end") Point end,@JsonProperty("color") String color){
        this.start=start;
        this.end=end;
        this.color=color;
    }

    public Line(Point start,Point end){
        this.start=start;
        this.end=end;
    }

    @Override
    public double lenght() {
        return Math.sqrt(Math.pow(this.start.getX()-this.end.getX(),2)+Math.pow(this.start.getY()-this.end.getY(),2));
    }

    @Override
    public void thickness(double thickness) {
        this.thickness=thickness;
    }

    @Override
    public void color(String color) {
        this.color=color;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }
}
