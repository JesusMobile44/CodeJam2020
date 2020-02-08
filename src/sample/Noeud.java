package sample;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;

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
                }
                else{
                    this.selected = false;
                    this.setImage(Main.imagesContainer.get(1));
                }
            }
        });
    }

}
