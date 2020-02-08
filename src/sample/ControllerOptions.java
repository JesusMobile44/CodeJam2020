package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ControllerOptions {

    ObservableList<String> resolutions = FXCollections.observableArrayList("1920x1080", "1280x800");
    ObservableList<String> theme = FXCollections.observableArrayList("Dark","Light");

    @FXML
    ChoiceBox resolutionsList;
    ChoiceBox themesList;

    

}
