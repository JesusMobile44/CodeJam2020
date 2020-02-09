package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
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
    public void changerGratte(){
        /*
        ImageView i1 = new ImageView(Main.imagesContainer.get(3));
        i1.setScaleX(0.5);
        i1.setScaleY(0.5);
        ImageView i2 = new ImageView(Main.imagesContainer.get(4));
        i2.setScaleX(0.5);
        i2.setScaleY(0.5);
        ImageView i3 = new ImageView(Main.imagesContainer.get(5));
        i3.setScaleX(0.5);
        i3.setScaleY(0.5);
        ImageView i4 = new ImageView(Main.imagesContainer.get(6));
        i4.setScaleX(0.5);
        i4.setScaleY(0.5);
        ImageView i5 = new ImageView(Main.imagesContainer.get(7));
        i5.setScaleX(0.5);
        i5.setScaleY(0.5);
        ImageView[] iv = {i1,i2,i3,i4,i5};
        ChoiceDialog<ImageView> alerte = new ChoiceDialog<ImageView>(iv[1],iv);
        */
        Label choix1 = new Label("Chevaux deneigeur");
        Label choix2 = new Label("Gratte");
        Label choix3 = new Label("Grosse gratte");
        Label choix4 = new Label("Mini gratte");
        Label choix5 = new Label("Souffleur");
        Label[] labels = {choix1,choix2,choix3,choix4,choix5};
        ChoiceDialog<Label> alerte = new ChoiceDialog(labels[1],labels);

        alerte.setTitle("Information importante");
        alerte.setHeaderText("Veuillez choisir");
        alerte.setContentText("Votre choix: ");
        alerte.setResizable(true);
        Image gratte = WhichGratte(alerte.showAndWait().get());
        imageGratte.setImage(gratte);

    }
    public Image WhichGratte(Label label) {
        Image image = Main.imagesContainer.get(3);
        switch(label.getText()) {
            case "Chevaux deneigeur":
                image = Main.imagesContainer.get(3);
                distanceText1.setText("0 L/100Km");
                break;
            case "Gratte":
                image = Main.imagesContainer.get(4);
                distanceText1.setText("10 L/100Km");
                break;
            case "Grosse gratte":
                image = Main.imagesContainer.get(5);
                distanceText1.setText("20 L/100Km");
                break;
            case "Mini gratte":
                image = Main.imagesContainer.get(6);
                distanceText1.setText("30 L/100Km");
                break;
            case "Souffleur":
                image = Main.imagesContainer.get(7);
                distanceText1.setText("40 L/100Km");
                break;
        }
        return image;
    }
    public void Simuler() {
        float var = 0;
        if (!tf.getText().equals("")) {
            var = Float.parseFloat(tf.getText());
            float distance = (var * additionneur.get() / 1600);
            if (additionneur.get() != 0) {
                String ok1 = toString().valueOf(distance);
                distanceText.setText(ok1);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Veuillez entrer la distance de votre map svp!");
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
