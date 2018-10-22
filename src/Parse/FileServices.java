package Parse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileServices {

    String path;

    public FileServices(String name){
        // tworzenie reader po sciezce po stworzeniu filechooser

    }

    public String fromFile(){

        StringBuffer tmp = new StringBuffer();

        try {
            FileReader file = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(file);
            String line=null;
            while((line = bufferedReader.readLine()) != null) {
                tmp.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return tmp.toString();
    }

    public void toFile(String data){

        try {
            FileWriter file = new FileWriter(path);
            file.write(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
