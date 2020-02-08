package sample;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.HashMap;

public class Noeud extends ImageView{
    HashMap<String,Rue> rues = new HashMap<>();

    Tooltip tooltip;
    Boolean selected = false;

    public ArrayList<Rue> ruesParNoeud = new ArrayList<>();

    public ArrayList<Rue> getRuesParNoeud() {
        return ruesParNoeud;
    }

    public void setRuesParNoeud(ArrayList<Rue> ruesParNoeud) {
        this.ruesParNoeud = ruesParNoeud;
    }

    public void setRues(HashMap<String, Rue> rues) {
        this.rues = rues;
    }

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }
    public double longueurDeLigne(Line trait){
        double longueur = Math.sqrt(Math.pow(trait.getEndX()-trait.getStartX(),2)+Math.pow(trait.getEndY()-trait.getStartY(),2));
        return longueur;
    }

    Noeud(ToggleButton buttonToggleNode,ToggleButton buttonToggleRoad, Pane paneN, Pane paneR){
        this.setOnMouseClicked(event -> {
            if (buttonToggleNode.isSelected() && event.getButton().equals(MouseButton.SECONDARY)){
                paneN.getChildren().remove(this);
            }
            else if (buttonToggleRoad.isSelected()){
                if (!this.selected){
                    this.selected = true;
                    this.setImage(Main.imagesContainer.get(2));
                    if (Main.oneSelected){
                        Line trait = new Line();
                        trait.setStartX(Main.x+16);
                        trait.setStartY(Main.y+16);
                        trait.setEndX(this.getX()+16);
                        trait.setEndY(this.getY()+16);
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

                    }
                    else{
                        Main.oneSelected = true;
                        Main.x = this.getX();
                        Main.y = this.getY();
                        Main.tempNode = this;
                    }
                }
                else{
                    this.selected = false;
                    this.setImage(Main.imagesContainer.get(1));
                    Main.oneSelected = false;
                    Main.x = 0;
                    Main.y = 0;
                }

    public void delete(Pane pane){
        pane.getChildren().remove(this);
    }

    public void select(){
        if (!this.selected){
            this.selected = true;
            this.setImage(Main.imagesContainer.get(2));
        }
        else{
            this.selected = false;
            this.setImage(Main.imagesContainer.get(1));
        }
    }

    Noeud(ToggleButton buttonToggleNode,ToggleButton buttonToggleRoad, Pane pane){

        ContextMenu contextMenu = new ContextMenu();
        MenuItem delete = new MenuItem();
        MenuItem select = new MenuItem();
        delete.setOnAction(event -> delete(pane));
        delete.setText("Delete");
        select.setOnAction(event -> select());
        select.setText("Select");
        contextMenu.getItems().addAll(select,delete);

        this.setOnContextMenuRequested(event -> {
            contextMenu.show(this, event.getX(),event.getY());
        });

        this.setOnMouseClicked(event -> {
            if (buttonToggleNode.isSelected() && event.getButton().equals(MouseButton.SECONDARY)){
                contextMenu.show(this,this.getX(),this.getY());
            }
            else if (buttonToggleRoad.isSelected()){
                select();
            }
        });
    }

}
