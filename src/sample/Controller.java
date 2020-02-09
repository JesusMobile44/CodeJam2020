package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import java.io.File;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import javafx.event.Event;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import static sample.Noeud.additionneur;
import static sample.Noeud.textadd;

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
    public Pane paneNoeuds;
    public Pane paneRues;
    public Text distanceText;
    public Text distanceText1;
    public TextField tf;

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
        if(additionneur.get()!=0){
            distanceText.setText(textadd.getText());
        }
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
    public void inputStreet(){

    }
    public void Simuler(){
        float var=0;
        if(!tf.getText().equals("")){
            var = Float.parseFloat(tf.getText());
            float distance =(var* additionneur.get()/1600);
            if(additionneur.get()!=0){
                String ok1 = toString().valueOf(distance);
                distanceText.setText(ok1);
            }
            int choixVehicule=1;
            switch (choixVehicule) {
                case 1:
                    distanceText1.setText("0 L/100Km");
                    break;
                case 2:
                    distanceText1.setText("10 L/100Km");
                    break;
                case 3:
                    distanceText1.setText("20 L/100Km");
                    break;
                case 4:
                    distanceText1.setText("30 L/100Km");
                    break;
                case 5:
                    distanceText1.setText("40 L/100Km");
                    break;
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Veuillez entrer la distance de votre map svp!");
            alert.showAndWait();
        }


    }

}
