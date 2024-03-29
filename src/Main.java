import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));


        primaryStage.setTitle("Painted");
        primaryStage.setScene(new Scene(root, 789, 510));
        primaryStage.show();
    }

    @FXML

    public static void main(String[] args) {
        launch(args);
    }
}
