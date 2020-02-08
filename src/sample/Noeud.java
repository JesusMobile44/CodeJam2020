package sample;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
