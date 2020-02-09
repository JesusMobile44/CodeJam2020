package sample;
import javafx.scene.shape.Line;


public class Rue {
    long longueur;
    Line trait = new Line();

    public void setTrait(Line trait) {
        this.trait = trait;
    }
    public void setLongueur(long longueur) {this.longueur = longueur;}
}
