package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class ControllerOptions {

    @FXML
    ToggleButton FHD;
    ToggleButton HD;
    ToggleButton lightTheme;
    ToggleButton darkTheme;
    ToggleGroup resolution;

    //résolution
    public void toggleFhd(){
        Main.setNumeroRes(1);
    }
    public void toggleHd(){
        Main.setNumeroRes(2);
    }
    //couleur
    public void toggleLight(){
        for(int i = 0; i<Main.getScenes().length; i++)
            Main.getScenes()[i].getStylesheets().setAll("modena.css");
    }
    public void toggleDark(){
        for(int i = 0; i<Main.getScenes().length; i++)
            Main.getScenes()[i].getStylesheets().setAll("modena_dark.css");
    }
}
