package Classes;

public class Line extends Shape1D {

    private Point start,end;
    private String color;
    private double thickness;

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
}
