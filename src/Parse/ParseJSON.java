package Parse;

import Shapes.Abstract_classes.Shape;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ParseJSON {

    private String file;

    public ParseJSON(String file){
        this.file=file;
    }

    public ArrayList<Shape> parseFrom(){
        ArrayList<Shape> tmp = null;


        ObjectMapper objectMapper=new ObjectMapper();

        try {
            objectMapper.enableDefaultTyping();
            tmp=objectMapper.readValue(new File(file),new TypeReference<ArrayList<Shape>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    public void parseTo(ArrayList<Shape> data) {
        ObjectMapper objectMapper=new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {

            objectMapper.writerFor(new TypeReference<ArrayList<Shape>>() {}).writeValue(new File(file), data);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
