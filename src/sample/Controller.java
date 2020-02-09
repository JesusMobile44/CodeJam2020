package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import java.io.File;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import javafx.event.Event;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import jdk.nashorn.internal.ir.Labels;

import static sample.Noeud.additionneur;
import static sample.Noeud.textadd;

public class Controller {


    @FXML
    public ImageView iv;
    @FXML
    public ImageView imageGratte;

    int choix;
    public void importMap(){
        FileChooser fc = new FileChooser();
        fc.setTitle("Veuillez sélectionner un fichier");
        File fichier = fc.showOpenDialog(null);
        Image map = new Image(fichier.toURI().toString());
        iv.setImage(map);
    }

    double consommation = 0;

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
    public Text consommationTotaleText;
    public Text text;

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

    public void close(){
        Main.changerDeMode(0);
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

    public void changerGratte(){
        Label choix1 = new Label("Chevaux deneigeur");
        Label choix2 = new Label("Gratte");
        Label choix3 = new Label("Grosse gratte");
        Label choix4 = new Label("Mini gratte");
        Label choix5 = new Label("Souffleur");
        choix1.setTextFill(Color.BLACK);
        choix2.setTextFill(Color.BLACK);
        choix3.setTextFill(Color.BLACK);
        choix4.setTextFill(Color.BLACK);
        choix5.setTextFill(Color.BLACK);
        Label[] labels = {choix1,choix2,choix3,choix4,choix5};
        ChoiceDialog<Label> alerte = new ChoiceDialog(labels[1],labels);

        alerte.setTitle("Information importante");
        alerte.setHeaderText("Veuillez choisir");
        alerte.setContentText("Votre choix: ");
        alerte.setResizable(true);
        alerte.getSelectedItem().setTextFill(Color.BLACK);

        Image gratte = WhichGratte(alerte.showAndWait().get());
        imageGratte.setImage(gratte);

    }
    public Image WhichGratte(Label label) {
        Image image = Main.imagesContainer.get(3);
        switch(label.getText()) {
            case "Chevaux deneigeur":
                image = Main.imagesContainer.get(3);
                consommation = 0;
                choix=1;
                break;
            case "Gratte":
                image = Main.imagesContainer.get(4);
                consommation = 20;
                choix=2;
                break;
            case "Grosse gratte":
                image = Main.imagesContainer.get(5);
                consommation = 30;
                choix=3;
                break;
            case "Mini gratte":
                image = Main.imagesContainer.get(6);
                consommation = 10;
                choix=4;
                break;
            case "Souffleur":
                image = Main.imagesContainer.get(7);
                consommation = 20;
                choix=5;
                break;
        }
        distanceText1.setText(consommation+" L/100Km");
        return image;
    }
    public void Simuler() {
        float var = 0;
        if (!tf.getText().equals("")) {
            var = Float.parseFloat(tf.getText());
            float distance = (var * additionneur.get() / 1600);
            consommationTotaleText.setText((consommation*distance)+" mL");
            if (additionneur.get() != 0) {
                String ok1 = toString().valueOf(distance);
                distanceText.setText(ok1);
            }
            double duree=0;
            int heure=0;
            int minute=0;
            switch (choix){
                case 1:
                    duree = ((distance/1000.0000000)/2);
                    heure = (int)duree;
                    minute = (int)((duree-heure)*60);
                    break;
                case 2:
                    duree = ((distance/1000.00000)/35.00);
                    heure = (int)duree;
                    minute = (int)((duree-heure)*60);
                    break;
                case 3:
                    duree = ((distance/1000.00)/45.00);
                    heure = (int)duree;
                    minute = (int)((duree-heure)*60);
                    break;
                case 4:
                    duree = ((distance/1000.00)/15.00);
                    heure = (int)duree;
                    minute = (int)((duree-heure)*60);
                    break;
                case 5:
                    duree = ((distance/1000.00)/20.00);
                    heure = (int)duree;
                    minute = (int)((duree-heure)*60);
                    break;
            }
            text.setText("Le temps estimé est de: "+heure+"h et "+minute+" minutes.");

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Veuillez entrer l'échelle de votre carte.");
            alert.showAndWait();
        }
    }
    public void DeleteEverything(){
        paneNoeuds.getChildren().clear();
        paneRues.getChildren().clear();
        distanceText.setText("0");

        additionneur.set(0);
    }

}
