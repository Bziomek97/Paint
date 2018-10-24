package MVC;

import Parse.ParseJSON;
import Parse.Repository;
import Shapes.Abstract_classes.Shape;
import Shapes.Circle;
import Shapes.Line;
import Shapes.Point;
import Shapes.Rectangle;

public class Model {

    private int state=0;
    private Repository rep;
    private View view;

    public Model(View view){
        rep=new Repository();
        this.view=view;
    }

    public void setState(int state){
        this.state=state;
    }

    public void createShape(double x0,double y0,double x1, double y1,String color,double thick){
        Shape tmp = null;
        switch (this.state){
            case 0:
                tmp=new Line(new Point(x0,y0),new Point(x1,y1));
                ((Line) tmp).color(color);
                ((Line) tmp).thickness(thick);
                rep.addItem(tmp);
                view.drawLine(x0,y0,x1,y1);
                break;
            case 1:
                tmp=new Circle(new Point(x0,y0),Math.sqrt(Math.pow(x0-x1,2)+Math.pow(y0-y1,2)));
                tmp.color(color);
                rep.addItem(tmp);
                view.drawCircle(x0,y0,x1,y1);
                break;
            case 2:
                tmp=new Rectangle(new Point(x0,y0),Math.sqrt(Math.pow(x0-x1,2)+Math.pow(y0-y0,2)),Math.sqrt(Math.pow(x1-x1,2)+Math.pow(y0-y1,2)));
                tmp.color(color);
                rep.addItem(tmp);
                view.drawRectangle(x0,y0,x1,y1);
                break;
        }
    }

    public void clean(){
        rep.clean();
    }

    public void saving(String file){
        ParseJSON parse = new ParseJSON(file);
        parse.parseTo(rep.getAll());
    }

    public void loading(String file){
        ParseJSON parse = new ParseJSON(file);
        rep.setAll(parse.parseFrom());

        for(Shape i: rep.getAll()){
            this.drawAll(i);
        }
    }

    public void drawAll(Shape item){
        String classname = item.getClass().getSimpleName();
        if(classname.equals("Line")){
            view.redrawLine(((Line) item).getStart().getX(),((Line) item).getStart().getY(),
                    ((Line) item).getEnd().getX(),((Line) item).getEnd().getY(),((Line) item).getColor());
        }
        else if (classname.equals("Circle")) {
            view.redrawCircle(((Circle) item).getCenter().getX(),((Circle) item).getCenter().getY(),
                    ((Circle) item).getRadius(),((Circle) item).getColor());
        }else {
            view.redrawRectangle(((Rectangle) item).getPoint().getX(),((Rectangle) item).getPoint().getY(),
                    ((Rectangle) item).getWidth(),((Rectangle) item).getHeigth(),((Rectangle) item).getColor());
        }
    }

}
