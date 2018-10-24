package Parse;

import Shapes.Abstract_classes.Shape;

import java.util.ArrayList;

public class Repository {
    private ArrayList<Shape> shape;

    public Repository(){
        shape =new ArrayList<>();
    }

    public void addItem(Shape item){
        shape.add(item);
    }

    public void clean(){
        shape.clear();
    }

    public ArrayList<Shape> getAll(){
        return shape;
    }

    public void setAll(ArrayList<Shape> data){
        this.shape=data;
    }

    public void setShape(ArrayList<Shape> shape) {
        this.shape = shape;
    }

    public Shape getByCode(){
        return null;
    }
}
