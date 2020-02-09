package sample;

import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

public class Noeud extends ImageView{
    public static AtomicLong additionneur = new AtomicLong();
    public static Text textadd = new Text();
    Boolean selected = false;

    public ArrayList<Rue> ruesParNoeud = new ArrayList<>();

    public ArrayList<Rue> getRuesParNoeud() {
        return ruesParNoeud;
    }


    public long longueurDeLigne(Line trait){
        long longueur = (long)(Math.sqrt(Math.pow(trait.getEndX()-trait.getStartX(),2)+Math.pow(trait.getEndY()-trait.getStartY(),2)));
        additionneur.set(additionneur.get()+longueur);
        return longueur;
    }

    Noeud(ToggleButton buttonToggleNode,ToggleButton buttonToggleRoad, Pane paneN, Pane paneR){
        this.setOnMouseClicked(event -> {
            if (buttonToggleNode.isSelected() && event.getButton().equals(MouseButton.SECONDARY)) {
                delete(paneN);
            }
            else if (buttonToggleRoad.isSelected()&& event.getButton().equals(MouseButton.PRIMARY)) {
                select(paneR);
            }
        });
    }

    public void delete(Pane paneN){
        paneN.getChildren().remove(this);
    }

    public void select(Pane paneR){
        if (!this.selected) {
            this.selected = true;
            this.setImage(Main.imagesContainer.get(2));
            if (Main.oneSelected) {
                Line trait = new Line();
                trait.setStartX(Main.x + 16);
                trait.setStartY(Main.y + 16);
                trait.setEndX(this.getX() + 16);
                trait.setEndY(this.getY() + 16);
                trait.setStrokeWidth(8);

                Rue road = new Rue();
                road.setLongueur(longueurDeLigne(trait));
                road.setTrait(trait);
                paneR.getChildren().add(road.trait);
                this.getRuesParNoeud().add(road);
                Main.oneSelected = false;
                Main.x = 0;
                Main.y = 0;
                this.setImage(Main.imagesContainer.get(1));
                this.selected = false;
                Main.tempNode.setImage(Main.imagesContainer.get(1));
                Main.tempNode.selected = false;

            } else {
                Main.oneSelected = true;
                Main.x = this.getX();
                Main.y = this.getY();
                Main.tempNode = this;
            }
        } else {
            this.selected = false;
            this.setImage(Main.imagesContainer.get(1));
            Main.oneSelected = false;
            Main.x = 0;
            Main.y = 0;
        }
    }
}
