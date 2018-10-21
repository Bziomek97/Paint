package Classes;

import java.util.ArrayList;

public class Repository {
    private ArrayList<Shape> shapes;

    public Repository(){
        shapes=new ArrayList<>();
    }

    public void addItem(Shape item){
        shapes.add(item);
    }

    public void clean(){
        shapes.clear();
    }

    public ArrayList<Shape> getAll(){
        return null;
    }

    public Shape getByCode(){
        return null;
    }
}
