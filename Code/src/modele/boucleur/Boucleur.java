package modele.boucleur;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe mère du Boucleur:
 * Elle permet d'ajouter des obervateur à sa collections mais aussi de notifier les observateurs
 * tout les X temps.
 */

public abstract class Boucleur implements Runnable, Observable {

    //Liste d'observateurs.
    private List<InvalidationListener> lesObservateur = new ArrayList<>();

    protected boolean actif = false;

    //Permet d'arrêter le boucleur
    public void setActif(boolean actif) {this.actif = actif;}

    @Override
    public void addListener(InvalidationListener invalidationListener) {
        lesObservateur.add(invalidationListener);
    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {
        lesObservateur.remove(invalidationListener);
    }

    //Notifications de tout les observateurs.
    protected void  timeBeep(){
        lesObservateur.forEach(o -> Platform.runLater(() -> o.invalidated(this)));
    }
}
