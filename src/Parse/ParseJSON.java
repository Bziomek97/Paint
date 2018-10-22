package Parse;

import Shapes.Abstract_classes.Shape;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParseJSON {

    private String file;

    public ParseJSON(String file){
        this.file=file;
    }

    public ArrayList<Shape> parseFrom(){
        String tmp;

        // 1. Plik
        FileServices file = new FileServices("ok");
        tmp=file.fromFile();

        // 2. Analiza stringu
        JSONObject obj = new JSONObject();

        // 3. Tworzenie repo

        return null;
    }

    public void parseTo(ArrayList<Shape> data) {
        JSONObject obj = new JSONObject();

        for(Shape i: data){
            if(i.getClass().getSimpleName() == "Line"){

            }
            else if(i.getClass().getSimpleName() == "Circle"){

            }
            else{

            }
        }

        // 3. Plik
        FileServices file = new FileServices("ok");
        //file.toFile(data);
    }
}
