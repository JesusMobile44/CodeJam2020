package sample;


import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.io.File;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class Controller {
    @FXML
    public ImageView iv;
    @FXML
    public Circle node1;
    @FXML
    public Circle node2;

    public void importMap(){
        FileChooser fc = new FileChooser();
        fc.setTitle("Veuillez sélectionner un fichier");
        File fichier = fc.showOpenDialog(null);
        Image map = new Image(fichier.toURI().toString());
        iv.setImage(map);
    }



    //UTILISER LE MOUSEDRAG

    @FXML
    public StackPane mapMove;
    public StackPane tempoMap;

    public void dragDetectMap(Event event){
        Dragboard dragboard = mapMove.startDragAndDrop(TransferMode.MOVE);
        dragboard.setDragView(null);
    }

    public void dragDoneMap(){

    }

    public void dragDropMap(){

    }

    public void dragEnteredMap(){


    }

    public void dragExitMap(){


    }
    public void inputStreet(){


    }
    public void clicNode(MouseEvent event){
        Circle circle = (Circle)event.getSource();
        circle.setFill(Color.RED);
    }
}
