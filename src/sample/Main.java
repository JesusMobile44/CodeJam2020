package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    private static Stage stage= new Stage();

    public static int numeroMode;

    private static Scene[] scenes = new Scene[3];

    public static ArrayList<Image> imagesContainer = new ArrayList();
    static Stage optStage = new Stage();


    @Override
    public void start(Stage primaryStage) throws Exception{         //On utilise pas primaryStage, juste stage
        getScenes()[0] = FXMLLoader.load(getClass().getResource("menu.fxml"));
        getScenes()[1] = FXMLLoader.load(getClass().getResource("sample.fxml"));
        getScenes()[2] = FXMLLoader.load(getClass().getResource("sample720p.fxml"));

        optStage.setScene(FXMLLoader.load(getClass().getResource("options.fxml")));


        getScenes()[0].getStylesheets().add("modena_dark.css");
        getScenes()[1].getStylesheets().add("modena_dark.css");
        primaryStage.setTitle("Déneigement et Pollution");

        initializeImage();

        numeroMode = 0;
        stage.setScene(getScenes()[numeroMode]);

        stage.setTitle("Déneigement et Pollution");
        stage.setResizable(true);
        stage.setMaximized(false);
        stage.setMinHeight(650);
        stage.setMinWidth(650);

        stage.show();
    }

    public static void initializeImage(){
        imagesContainer.add(new Image("image/imageNode.png"));
        imagesContainer.add(new Image("image/imageNodeBleu.png"));
        imagesContainer.add(new Image("image/imageNodeRouge.png"));
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Scene[] getScenes() {
        return scenes;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void changerDeMode(int mode){
        stage.setScene(Main.getScenes()[mode]);
        stage.setResizable(true);

        numeroMode = mode;

        stage.hide();
        stage.show();
    }

    public static void startOptions(){
        optStage.show();
    }

}
