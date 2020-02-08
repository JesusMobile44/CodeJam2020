package sample;

import java.util.ArrayList;

public class Rue {
    double longueur;
    String nom;
    ArrayList<Maison> maisons = new ArrayList<>();

    public double getLongueur() {return longueur;}
    public void setLongueur(double longueur) {this.longueur = longueur;}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    public ArrayList<Maison> getMaisons() {return maisons;}
    public void setMaisons(ArrayList<Maison> maisons) {this.maisons = maisons;}
}
