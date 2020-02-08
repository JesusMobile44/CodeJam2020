package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerMenu {
    @FXML
    Button StartButton, OptionButton, QuitterButton;

    public void setStart(){
        Main.changerDeMode(1);
    }
    public void setQuit(){
        System.exit(0);
    }
}
