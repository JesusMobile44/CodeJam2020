package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ControllerMenu {
    @FXML
    Button StartButton, OptionButton, QuitterButton;

    ObservableList<String> resolutions = FXCollections.observableArrayList("1920x1080", "1280x800");
    ObservableList<String> theme = FXCollections.observableArrayList("Dark","Light");

    @FXML
    ChoiceBox resolutionsList;
    ChoiceBox themesList;

    public void setStart(){
        Main.changerDeMode(1);
    }
    public void setQuit(){
        System.exit(0);
    }

    Stage selectionResolution = new Stage();

    public void optionsAction(){
        Main.startOptions();
        resolutionsList.setItems(FXCollections.observableArrayList("1920x1080", "1280x800"));
        themesList.setItems(FXCollections.observableArrayList("Dark","Light"));


    }
}
