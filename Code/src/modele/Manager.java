package modele;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modele.entite.Rocher;
import modele.entite.personnages.PersoPrincipal;
import javafx.scene.image.ImageView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Manager {
    public float temps;
    public int nivDifficulte;
    public int nbKill;
    private PersoPrincipal perso;
    private Rocher r;
    public List<ImageView> imVRocherList = new ArrayList<>();
    public ImageView imVPerso;
    public ImageView imVRocher;

    public Manager(){

    }

    public void spawnPerso() {
        perso = new PersoPrincipal("jean");
        perso.setImage("perso");
        Class<?> cl = this.getClass();
        InputStream is = cl.getResourceAsStream(perso.getImage());
        Image im = new Image(is,50,50,true,true);
        imVPerso = new ImageView(im);
        imVPerso.setX(200);
        imVPerso.setY(200);
        //Position p = new Position(100,100);
        //perso.setP(p);
    }

    public void spawnRocher(int nivDifficulte){
        //Image im;
        //System.out.println(r.getpositionX()+","+r.getpositionY());
        for (int i = 0 ; i < nivDifficulte ; i++){
            r = new Rocher();
            Class<?> cl = this.getClass();
            InputStream is = cl.getResourceAsStream(r.getImage());
            Image im = new Image(is,50,50,true,true);
            imVRocher = new ImageView(im);
            imVRocher.setX(r.getpositionX());
            imVRocher.setY(r.getpositionY());
            imVRocherList.add(imVRocher);
            //todo ↑ voir si il faut ajouter les imageView dans une liste pour pouvoir afficher cette liste plus tard dans la fenêtre de la partie
        }
    }

    public void touche(KeyEvent keyEvent){
        Deplaceur d = new Deplaceur();
        if(keyEvent.getCode() == KeyCode.Z || keyEvent.getCode() == KeyCode.UP){
            d.deplacerHaut(perso,imVPerso);
            System.out.println("hello world");
        }
    }

}
