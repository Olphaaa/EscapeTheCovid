package modele;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modele.entite.personnages.PersoPrincipal;
import view.SetupPartie;

public class Manager {
    public float temps;
    public int nivDifficulte;
    public int nbKill;
    PersoPrincipal perso;

    public Manager(){
        perso = new PersoPrincipal("jean");
        perso.setImage("perso");

    }

    public static void nvllePartie() {

    }

    public void touche(KeyEvent keyEvent){
        Deplaceur d = new Deplaceur();
        if(keyEvent.getCode() == KeyCode.Z || keyEvent.getCode() == KeyCode.UP)
            d.deplacerHaut(perso);
    }
}
