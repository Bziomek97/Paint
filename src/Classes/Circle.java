package Classes;

public class Circle extends Shape2D {

    private Point center;
    private double radius;

    public Circle(Point center, double radius){
        this.center=center;
        this.radius=radius;
    }

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public void color() {

    }
}
