package modele.boucleur;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.List;

public abstract class Boucleur implements Runnable, Observable {

    private List<InvalidationListener> lesObservateur = new ArrayList<>();

    protected boolean actif = false;
    public boolean isActif() {return actif;}
    public void setActif(boolean actif) {this.actif = actif;}


    @Override
    public void addListener(InvalidationListener invalidationListener) {
        lesObservateur.add(invalidationListener);
    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {
        lesObservateur.remove(invalidationListener);
    }

    protected void  timeBeep(){
        lesObservateur.forEach(o -> Platform.runLater(() -> o.invalidated(this)));
    }
}
