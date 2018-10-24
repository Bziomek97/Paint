package MVC;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;

import java.io.File;

public class View {

    @FXML private VBox wind;
    @FXML private Canvas ground;
    @FXML private ColorPicker fillColor;
    @FXML private Slider thickSlider;
    @FXML private Label sliderCounter;
    @FXML private AnchorPane lineSelect,circleSelect,rectSelect;
    private GraphicsContext gc;
    private Model model;
    private double tmpX,tmpY;

    @FXML
    public void initialize() {
        gc=ground.getGraphicsContext2D();
        model=new Model(this);

        startDrag();
        endDrag();
    }

    //Set state to draw
    @FXML
    public void lineState(){
        circleSelect.setStyle("");
        rectSelect.setStyle("");
        lineSelect.setStyle("-fx-background-color: lightslategrey;");
        model.setState(0);
    }

    @FXML
    public void circleState(){
        lineSelect.setStyle("");
        rectSelect.setStyle("");
        circleSelect.setStyle("-fx-background-color: lightslategrey;");
        model.setState(1);
    }

    @FXML
    public void rectState(){
        lineSelect.setStyle("");
        circleSelect.setStyle("");
        rectSelect.setStyle("-fx-background-color: lightslategrey;");
        model.setState(2);
    }

    @FXML
    public void actuator(){
        sliderCounter.setText(String.valueOf(thickSlider.getValue()));
    }

    @FXML
    public void clean(){
        model.clean();
        gc.clearRect(0,0,10000,10000);
    }

    @FXML
    public void saveMethod(){
        FileChooser file = new FileChooser();
        File selectedFile = null;

        file.setTitle("Choose location To Save ");
        file.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON","*.json"));
        try {
            selectedFile=file.showOpenDialog(wind.getScene().getWindow());
            model.saving(selectedFile.getAbsolutePath());
        } catch(Exception ignored){
        }
    }

    @FXML
    public void loadMethod(){
        this.clean();
        FileChooser fileChooser = new FileChooser();
        File selectedFile = null;

        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON","*.json"));
        try {
            selectedFile = fileChooser.showOpenDialog(wind.getScene().getWindow());
            model.loading(selectedFile.getAbsolutePath());
        } catch(Exception ignored){

        }
    }

    public void startDrag(){
        ground.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tmpX=event.getX();
                tmpY=event.getY();
            }
        });
    }

    public void endDrag(){
        ground.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x,y;
                x=event.getX();
                y=event.getY();
                model.createShape(tmpX,tmpY,x,y, String.valueOf(fillColor.getValue()),thickSlider.getValue());
            }
        });
    }

    public void drawLine(double x0,double y0,double x1, double y1){
        gc.setStroke(fillColor.getValue());
        gc.setLineWidth(thickSlider.getValue());
        gc.strokeLine(x0,y0,x1,y1);
    }

    public void drawCircle(double x0, double y0, double x1,double y1){
        gc.setFill(fillColor.getValue());
        double radius=Math.sqrt(Math.pow(x0-x1,2)+Math.pow(y0-y0,2));
        gc.fillOval(x0-radius,y0-radius,2*Math.sqrt(Math.pow(x0-x1,2)+Math.pow(y0-y0,2)),2*Math.sqrt(Math.pow(x1-x1,2)+Math.pow(y0-y1,2)));
    }

    public void drawRectangle(double x0, double y0, double x1,double y1){
        gc.setFill(fillColor.getValue());
        gc.fillRect(x0,y0,Math.sqrt(Math.pow(x0-x1,2)+Math.pow(y0-y0,2)),
                Math.sqrt(Math.pow(x1-x1,2)+Math.pow(y0-y1,2)));
    }

    public void redrawCircle(double x0, double y0, double radius, String color){
        gc.setFill(Paint.valueOf(color));
        gc.fillOval(x0-radius,y0-radius,2*radius,2*radius);
    }

    public void redrawRectangle(double x0, double y0, double width, double height, String color){
        gc.setFill(Paint.valueOf(color));
        gc.fillRect(x0,y0,width, height);
    }

    public void redrawLine(double x0,double y0,double x1, double y1, String color){
        gc.setStroke(Paint.valueOf(color));
        gc.setLineWidth(thickSlider.getValue());
        gc.strokeLine(x0,y0,x1,y1);
    }

}
