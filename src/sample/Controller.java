package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.stage.FileChooser;
import java.io.File;
import javafx.event.Event;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Controller {

    @FXML
    public ImageView iv;

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
    public ToggleGroup toggles = new ToggleGroup();
    public StackPane tempoMap;
    public ToggleButton buttonTogglRoad;
    public ToggleButton buttonToggleNode;
    public Pane pane;

    private int nbNoeudSelect = 0;


    public void mouseClickNode(MouseEvent event){
        if (event.getButton().equals(MouseButton.PRIMARY)){
            if(buttonToggleNode.isSelected()) {
                Noeud noeud = new Noeud(buttonToggleNode,buttonTogglRoad,pane);
                noeud.setX(event.getX()-16);
                noeud.setY(event.getY()-16);
                noeud.setImage(Main.imagesContainer.get(1));
                pane.getChildren().add(noeud);
            }
        }
    }

    public void toggleRoadSelec(){
        if(buttonToggleNode.isSelected())
            buttonToggleNode.setSelected(false);
    }
    public void toggleNodeSelect(){
        if(buttonTogglRoad.isSelected())
            buttonTogglRoad.setSelected(false);
    }

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

}
