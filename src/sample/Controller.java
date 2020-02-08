package sample;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

public class Controller {


    //UTILISER LE MOUSEDRAG

    @FXML
    public StackPane mapMove;
    public ToggleGroup toggles = new ToggleGroup();
    public StackPane tempoMap;
    public ToggleButton buttonTogglRoad;
    public ToggleButton buttonToggleNode;
    public Pane pane;

    private int nbNoeudSelect = 0;

    public void importMap(){}

    public void mouseClickNode(MouseEvent event){
        if (event.getButton().equals(MouseButton.PRIMARY)){
            if(buttonToggleNode.isSelected()) {
                Noeud noeud = new Noeud(buttonToggleNode,buttonTogglRoad,pane);
                noeud.setX(event.getX()-16);
                noeud.setY(event.getY()-16);
                noeud.setImage(Main.imagesContainer.get(0));
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
    public void initialize(){
    }
}
