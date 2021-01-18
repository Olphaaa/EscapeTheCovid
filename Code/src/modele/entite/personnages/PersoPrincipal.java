package modele.entite.personnages;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import modele.entite.equipements.Equipement;
import modele.entite.equipements.protections.Combinaison;
import modele.entite.equipements.protections.Masque;
import modele.entite.equipements.protections.Protection;
import modele.entite.equipements.protections.Visiere;
import view.PartieVue;

import java.util.ArrayList;
import java.util.List;

public class PersoPrincipal extends Personnage implements Observable{
    private Protection p;
    private boolean isEquiped;
    public List<InvalidationListener> lesObservateurPerso = new ArrayList<>();


    public PersoPrincipal(){
        this.p = null;
        this.setEquiped(false);
        this.setImage("/images/perso/ppArme.png");
        this.setX(45);
        this.setY(375);
    }

    public void ajouterEquipement(Equipement e){
        switch (e.getNom()){
          case "Masque":
              Masque masque = (Masque) e;
              this.setImage("/images/perso/ppMasque.png");
              this.setProtection(masque);
              this.setEquiped(true);
              break;

            case "Visiere":
                Visiere visiere = (Visiere) e;
                this.setImage("/images/perso/ppVisiere.png");

                this.setProtection(visiere);
                this.setEquiped(true);
                break;

            case "Combinaison":
                Combinaison combinaison = (Combinaison) e;
                this.setImage("/images/perso/ppCombi.png");
                this.setProtection(combinaison);
                this.setEquiped(true);
                break;

            default:
                break;
        }
        lesObservateurPerso.forEach(o -> Platform.runLater(() -> o.invalidated( this)));
    }


    public void setEquiped(boolean bool){
        this.isEquiped = bool;
    }
    public void setProtection(Protection p){
        this.p = p;
    }
    public Protection getProtection(){return p;}


    public void attaquer(IA ia){
        ia.setIsDead(true);
        PartieVue.m.supprIA(ia);
    }

    public boolean isEquiped() {
        return isEquiped;
    }


    public void desequipe() {
        this.setImage("/images/perso/ppRien.png");
        this.setProtection(null);
        this.setEquiped(false);
        lesObservateurPerso.forEach(o -> Platform.runLater(() -> o.invalidated(this)));
    }

    public void addListener(InvalidationListener invalidationListener) {
        lesObservateurPerso.add(invalidationListener);
    }

    public void removeListener(InvalidationListener invalidationListener) {
        lesObservateurPerso.remove(invalidationListener);
    }
}
