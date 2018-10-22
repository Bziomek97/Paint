package Parse;


import org.json.JSONObject;

public class ParseFrom implements ParseInterface{

    private String file;

    public ParseFrom(String file) {
        this.file=file;
    }


    @Override
    public void Parse() {

        String tmp;

        // 1. Plik
        FileServices file = new FileServices("ok");
        tmp=file.fromFile();

        // 2. Analiza stringu
        JSONObject obj = new JSONObject();

        // 3. Tworzenie repo



    }


}
