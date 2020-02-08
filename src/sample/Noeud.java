package sample;

import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

import java.util.HashMap;

public class Noeud extends ImageView{
    HashMap<String,Rue> rues = new HashMap<>();

    Image image;
    Tooltip tooltip;

    public HashMap<String, Rue> getRues() {return rues;}
    public void etRues(HashMap<String, Rue> rues) {this.rues = rues;}

    Noeud(){
        this.tooltip.setText("Intersection");
        this.setOnMouseClicked(event -> {
            //On connecte les deux points

        });
        this.setOnMouseEntered(event -> {
            //Afficher le tooltip
        });
        this.setOnDragDetected(event -> {
            Dragboard dragboard = this.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent contenu = new ClipboardContent();
            contenu.putImage(this.getImage());
            dragboard.setContent(contenu);
        });
        this.setOnDragOver(event ->{
            event.acceptTransferModes(TransferMode.MOVE);
        });
        this.setOnDragDropped(event -> {
            relocateToPoint(new Point2D(event.getSceneX(),event.getSceneY()));
        });

    }

    public void relocateToPoint (Point2D p) {

        //relocates the object to a point that has been converted to
        //scene coordinates
        Point2D localCoords = getParent().sceneToLocal(p);

        relocate (
                (int) (localCoords.getX() - (getBoundsInLocal().getWidth() / 2)),
                (int) (localCoords.getY() - (getBoundsInLocal().getHeight() / 2))
        );
    }

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }


}
