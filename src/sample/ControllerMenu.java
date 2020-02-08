package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerMenu {
    @FXML
    Button StartButton, OptionButton, QuitterButton;

    public void setStart(){
        Main.changerDeMode(1);
    }
    public void setQuit(){
        System.exit(0);
    }

    Stage selectionResolution = new Stage();

    public void optionsAction(){

    }
}
