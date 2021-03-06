package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {

    public static Stage stage= new Stage();

    public static int numeroMode;

    public static int numeroRes;

    private static Scene[] scenes = new Scene[3];

    public static ArrayList<Image> imagesContainer = new ArrayList();
    static Stage optStage = new Stage();

    public static boolean oneSelected = false;
    public static double x = 0;
    public static double y = 0;
    public static Noeud tempNode;


    @Override
    public void start(Stage primaryStage) throws Exception{         //On utilise pas primaryStage, juste stage
        getScenes()[0] = FXMLLoader.load(getClass().getResource("menu.fxml"));
        getScenes()[1] = FXMLLoader.load(getClass().getResource("sample.fxml"));
        getScenes()[2] = FXMLLoader.load(getClass().getResource("sample720p.fxml"));

        Scene options = FXMLLoader.load(getClass().getResource("options.fxml"));
        optStage.setScene(options);
        numeroRes = 1;


        getScenes()[0].getStylesheets().add("modena_dark.css");
        getScenes()[1].getStylesheets().add("modena_dark.css");
        getScenes()[2].getStylesheets().add("modena_dark.css");
        options.getStylesheets().add("modena_dark.css");
        primaryStage.setTitle("Pelle-T");

        initializeImage();

        numeroMode = 0;
        stage.setScene(getScenes()[numeroMode]);

        stage.setTitle("Pelle-T");
        stage.setResizable(true);
        stage.setMaximized(true);
        stage.setMinHeight(650);
        stage.setMinWidth(650);

        stage.show();
    }

    public static void initializeImage(){
        imagesContainer.add(new Image("image/imageNode.png"));
        imagesContainer.add(new Image("image/imageNodeBleu.png"));
        imagesContainer.add(new Image("image/imageNodeRouge.png"));
        imagesContainer.add(new Image("image/chevaux deneigeur.png"));
        imagesContainer.add(new Image("image/gratte.png"));
        imagesContainer.add(new Image("image/grosse gratte.png"));
        imagesContainer.add(new Image("image/mini gratte.png"));
        imagesContainer.add(new Image("image/souffleur.png"));
    }
    public static void main(String[] args) {
        launch(args);
    }
    public static Scene[] getScenes() {
        return scenes;
    }
    //changer de mode
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
    public static void setNumeroRes(int numeroRes) {
        Main.numeroRes = numeroRes;
    }
    public static int getNumeroRes() {
        return numeroRes;
    }
}
