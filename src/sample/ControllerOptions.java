package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ControllerOptions {

    @FXML
    ToggleButton FHD;
    ToggleButton HD;
    ToggleButton lightTheme;
    ToggleButton darkTheme;
    ToggleGroup resolution;


    public void toggleFhd(){
        Main.setNumeroRes(1);
    }
    public void toggleHd(){
        Main.setNumeroRes(2);
    }

    public void toggleLight(){
        for(int i = 0; i<Main.getScenes().length; i++)
            Main.getScenes()[i].getStylesheets().setAll("modena.css");
    }

    public void toggleDark(){
        for(int i = 0; i<Main.getScenes().length; i++)
            Main.getScenes()[i].getStylesheets().setAll("modena_dark.css");
    }
}
