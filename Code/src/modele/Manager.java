package modele;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modele.entite.Rocher;
import modele.entite.personnages.PersoPrincipal;
import javafx.scene.image.ImageView;
import java.io.InputStream;

public class Manager {
    public float temps;
    public int nivDifficulte;
    public int nbKill;
    private PersoPrincipal perso;
    public ImageView imV;

    public Manager(){

    }

    public void spawnPerso() {
        perso = new PersoPrincipal("jean");
        perso.setImage("perso");

        Class<?> cl = this.getClass();
        InputStream is = cl.getResourceAsStream(perso.getImage());
        Image im = new Image(is,50,50,true,true);
        imV = new ImageView(im);
        imV.setX(100);
        imV.setY(100);
        Position p = new Position(100,100);
        perso.setP(p);
    }

    public void touche(KeyEvent keyEvent){
        Deplaceur d = new Deplaceur();
        if(keyEvent.getCode() == KeyCode.Z || keyEvent.getCode() == KeyCode.UP){
            d.deplacerHaut(perso,imV);
        }
    }
}
