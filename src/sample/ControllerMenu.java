package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ControllerMenu {
    @FXML
    Button StartButton, OptionButton, QuitterButton;

    public void setStart(){
        Main.changerDeMode(Main.getNumeroRes());
    }
    public void setQuit(){
        System.exit(0);
    }


    public void optionsAction(){
        Main.startOptions();
    }

}
