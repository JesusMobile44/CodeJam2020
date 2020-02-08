package sample;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.HashMap;

public class Noeud extends ImageView{
    HashMap<String,Rue> rues = new HashMap<>();

    Tooltip tooltip;
    Boolean selected = false;

    public HashMap<String, Rue> getRues() {return rues;}

    public void setRues(HashMap<String, Rue> rues) {
        this.rues = rues;
    }

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }

    Noeud(ToggleButton buttonToggleNode,ToggleButton buttonToggleRoad, Pane pane){
        this.setOnMouseClicked(event -> {
            if (buttonToggleNode.isSelected() && event.getButton().equals(MouseButton.SECONDARY)){
                pane.getChildren().remove(this);
            }
            else if (buttonToggleRoad.isSelected()){
                if (!this.selected){
                    this.selected = true;
                    this.setImage(Main.imagesContainer.get(2));
                    if (Main.oneSelected){
                        Line rue = new Line();
                        rue.setStartX(Main.x+16);
                        rue.setStartY(Main.y+16);
                        rue.setEndX(this.getX()+16);
                        rue.setEndY(this.getY()+16);
                        rue.setStrokeWidth(8);
                        rue.setFill(Color.WHITE);
                        pane.getChildren().add(rue);
                        Main.oneSelected = false;
                        Main.x = 0;
                        Main.y = 0;
                        this.setImage(Main.imagesContainer.get(1));
                        Main.tempNode.setImage(Main.imagesContainer.get(1));
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
            }
        });
    }

}
