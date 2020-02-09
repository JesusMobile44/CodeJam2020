package sample;

import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class Rue {
    long longueur;
    String nom;
    Line trait = new Line();

    public Line getTrait() {
        return trait;
    }
    public void setTrait(Line trait) {
        this.trait = trait;
    }

    //ArrayList<Maison> maisons = new ArrayList<>();

    public long getLongueur() {return longueur;}
    public void setLongueur(long longueur) {this.longueur = longueur;}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    //public ArrayList<Maison> getMaisons() {return maisons;}
    //public void setMaisons(ArrayList<Maison> maisons) {this.maisons = maisons;}
}
