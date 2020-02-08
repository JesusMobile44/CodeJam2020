package sample;

import java.util.HashMap;

public class Noeud {
    HashMap<String,Rue> rues = new HashMap<>();

    public HashMap<String, Rue> getRues() {return rues;}
    public void setRues(HashMap<String, Rue> rues) {this.rues = rues;}
}
