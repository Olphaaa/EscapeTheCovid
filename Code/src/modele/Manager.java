package modele;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.PointLight;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modele.entite.Rocher;
import modele.entite.personnages.PersoPrincipal;
import javafx.scene.image.ImageView;
import modele.entite.personnages.Personnage;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Manager {
    public float temps;
    public int nivDifficulte;
    public int nbKill;
    public PersoPrincipal perso;
    private Rocher r;
    public List<ImageView> imVRocherList = new ArrayList<>();
    public List<Rocher> listRocher = new ArrayList<>();
    public ImageView imVPerso;
    public ImageView imVRocher;

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

    public void touche(KeyEvent keyEvent){
        Deplaceur d = new Deplaceur();
        switch (keyEvent.getCode()){
            case Z:
                d.deplacerHaut(perso);
                break;
            case Q:
                d.deplacerGauche(perso);
                break;
            case D:
                d.deplacerDroit(perso);
                break;
            case S:
                d.deplacerBas(perso);
                break;
            default:
                System.out.printf("mauvaise touche");
                break;
        }
    }
}
