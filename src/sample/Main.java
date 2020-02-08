package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {



    private static Scene[] scenes = new Scene[2];

    @Override
    public void start(Stage primaryStage) throws Exception{
        getScenes()[0] = new Scene(FXMLLoader.load(getClass().getResource("menu.fxml")));
        getScenes()[1] = new Scene(FXMLLoader.load(getClass().getResource("sample.fxml")));

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Déneigement et Pollution");
        primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.setResizable(true);
        primaryStage.setMaximized(false);
        primaryStage.setMinHeight(650);
        primaryStage.setMinWidth(650);

        
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static Scene[] getScenes() {
        return scenes;
    }

    public static void setScenes(Scene[] scenes) {
        Main.scenes = scenes;
    }
}
