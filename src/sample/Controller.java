package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import java.io.File;
import javafx.event.Event;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Controller {

    @FXML
    public ImageView iv;
    @FXML
    public ImageView imageGratte;

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
    public Pane paneNoeuds;
    public Pane paneRues;

    private int nbNoeudSelect = 0;


    public void mouseClickNode(MouseEvent event){
        if (event.getButton().equals(MouseButton.PRIMARY)){
            if(buttonToggleNode.isSelected()) {
                Noeud noeud = new Noeud(buttonToggleNode,buttonTogglRoad,paneNoeuds,paneRues);
                noeud.setX(event.getX()-16);
                noeud.setY(event.getY()-16);
                noeud.setImage(Main.imagesContainer.get(1));
                paneNoeuds.getChildren().add(noeud);
            }
        }
    }

    public void toggleRoadSelec(){
        if(buttonToggleNode.isSelected()){
            buttonToggleNode.setSelected(false);
        }
    }
    public void toggleNodeSelect(){
        if(buttonTogglRoad.isSelected()){
            buttonTogglRoad.setSelected(false);
        }
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
    public void changerGratte(){
        ImageView i1 = new ImageView(new Image("image/chevaux deneigeur.jpg"));
        ImageView i2 = new ImageView(new Image("image/gratte.png"));
        ImageView i3 = new ImageView(new Image("image/grosse gratte.png"));
        ImageView i4 = new ImageView(new Image("image/mini gratte.png"));
        ImageView i5 = new ImageView(new Image("image/souffleur.png"));
        ChoiceDialog<ImageView> alerte = new ChoiceDialog<ImageView>(i1,  i2, i3, i4,i5);
        alerte.setTitle("Information importante");
        alerte.setHeaderText("Veuillez choisir");
        alerte.setContentText("Votre choix: ");
        imageGratte.setImage(alerte.showAndWait().get().getImage());

    }

}
