package modele.entite.personnages;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modele.Position;
import modele.entite.equipements.armes.Arme;
import modele.entite.equipements.protections.Protection;

import java.io.InputStream;

public class PersoPrincipal extends Personnage{
    private Arme a;
    private Protection p;


    public PersoPrincipal(){
        this.a = null;
        this.p= null;
        this.setImage("perso");
        Class<?> cl = this.getClass();
        InputStream is = cl.getResourceAsStream(getImage());
        Image im = new Image(is,50,50,true,true);
        this.setImView(new ImageView(im));
    }



    private void setArme(Arme a){
        this.a = a;
    }
    private void setProtection(Protection p){
        this.p = p;
    }


    public void attaquer(Arme a, IA ia){
        int pdvAdvers = ia.getPv();
        pdvAdvers -= a.getPdd();
        if(pdvAdvers <= 0){ia.setIsDead(true); ia.disparition();}
        else ia.setPv(pdvAdvers);
    }
}
