package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.swing.text.html.ImageView;

public class ControllerMenu {
    @FXML
    public Button StartButton;
    @FXML
    public Button OptionButton;
    @FXML
    public Button QuitterButton;
    public void setStartButton(Button startButton) {
        StartButton = startButton;
    }



}
