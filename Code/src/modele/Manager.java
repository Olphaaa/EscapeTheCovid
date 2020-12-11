package modele;

import javafx.scene.input.KeyEvent;
import modele.entite.Rocher;
import modele.entite.equipements.protections.Combinaison;
import modele.entite.equipements.protections.Masque;
import modele.entite.equipements.protections.Protection;
import modele.entite.equipements.protections.Visiere;
import modele.entite.personnages.PersoPrincipal;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Manager {
    public float temps;
    public int nivDifficulte;
    public int nbKill;
    public PersoPrincipal perso;
    private Rocher r;
    public List<ImageView> imVRocherList = new ArrayList<>();
    public List<Rocher> listRocher = new ArrayList<>();
    public List<Protection> listProtection = new ArrayList<>();
    public Protection protection;
    public ImageView imVPerso;
    public ImageView imVRocher;

    private Boolean up,down,left, right;

    public Manager(){

    }

    public void spawnPerso(){
        perso = new PersoPrincipal("jean");
        perso.setPPerso(new Position(45,315)); // point de départ du personnage
        Deplaceur d = new Deplaceur();
    }

    public void spawnRocher(int nivDifficulte){
        for (int i = 0 ; i < nivDifficulte ; i++)
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
    public void touche(KeyEvent keyEvent){
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
                System.out.printf("mauvaise touche");
                break;
        }

    }



}
