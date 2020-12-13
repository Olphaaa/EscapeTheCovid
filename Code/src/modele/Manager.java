package modele;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modele.entite.Rocher;
import modele.entite.equipements.protections.Combinaison;
import modele.entite.equipements.protections.Masque;
import modele.entite.equipements.protections.Protection;
import modele.entite.equipements.protections.Visiere;
import modele.entite.personnages.IA;
import modele.entite.personnages.PersoPrincipal;
import modele.properties.NiveauDifficulte;
import modele.properties.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Manager {
    public float temps;
    public int nbKill;

    public PersoPrincipal perso;
    public Protection protection;
    private Rocher r;
    public IA ia;

    public List<Rocher> listRocher = new ArrayList<>();
    public List<IA> listIA = new ArrayList<>();

    private final StringProperty pseudo = new SimpleStringProperty();
    public String getPseudo(){return pseudo.get();}
    public StringProperty pseudoProperty(){return pseudo;}
    public void setPseudo(String pseudo){this.pseudo.set(pseudo);}

    public String nivDifficulte;

    public Manager(){
    }

    public void spawnPerso(){
        perso = new PersoPrincipal();
        perso.setPPerso(new Position(45,315)); // point de départ du personnage
    }

    public void spawnRocher(){
        for (int i = 0 ; i < 10 ; i++)
        {
            r = new Rocher();
            listRocher.add(r);
        }
    }

    public void spawnProtection() {
        Protection p;
        Random rand = new Random();
        double taux = rand.nextFloat();
        if (taux > 0 && taux < 0.10){
            p = new Combinaison();
        }else if (taux >=0.10 && taux <0.40){
            p = new Visiere();
        }else {
            p = new Masque();
        }
        protection = p;
    }

    public void spawnIA() {
        ia = new IA();
        listIA.add(ia);
    }



    /*public void touche(KeyEvent keyEvent){
        Deplaceur d = new Deplaceur();
        switch (keyEvent.getCode()){
            case Z:
            case UP:
                d.deplacerHaut(perso);
                break;
            case Q:
            case LEFT:
                d.deplacerGauche(perso);
                break;
            case D:
            case RIGHT:
                d.deplacerDroit(perso);
                break;
            case S:
            case DOWN:
                d.deplacerBas(perso);
                break;
            default:
                System.out.print("mauvaise touche");
                break;
        }
    }*/
    public boolean up,down,left,right;
    public void touche(KeyEvent k){
        Deplaceur d = new Deplaceur();
        if (up)
        {
            d.deplacerHaut(perso);
        }
        if (down){
            d.deplacerBas(perso);
        }
        if (left){
            d.deplacerGauche(perso);
        }
        if(right){
            d.deplacerDroit(perso);
        }
    }
    public void testRealesed(KeyEvent k){
        if(k.getCode() == KeyCode.Z) up = false;
        if(k.getCode() == KeyCode.Q) left = false;
        if(k.getCode() == KeyCode.S) down = false;
        if(k.getCode() == KeyCode.D) right = false;
        touche(k);
    }
    public void testPressed(KeyEvent k){
        if(k.getCode() == KeyCode.Z) up = true;
        if(k.getCode() == KeyCode.Q) left = true;
        if(k.getCode() == KeyCode.S) down = true;
        if(k.getCode() == KeyCode.D) right = true;
        touche(k);
    }

}
