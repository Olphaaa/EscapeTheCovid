package modele;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.entite.Entite;
import modele.entite.personnages.IA;

import java.util.Iterator;

/**
 * Carte.
 */
public class Carte {


    private ObservableList<Entite> lesEntites = FXCollections.observableArrayList();
    private ObservableList<IA> lesIA = FXCollections.observableArrayList();


    /**
     * Gets les entites.
     *
     * @return the les entites
     */
    public ObservableList<Entite> getLesEntites() {return FXCollections.unmodifiableObservableList(lesEntites);}

    /**
     * Gets les ia.
     *
     * @return the les ia
     */
    public ObservableList<IA> getLesIA() {return FXCollections.unmodifiableObservableList(lesIA);}

    /**
     * Ajouter entites.
     *
     * @param e entite a ajouter
     */
    public void ajouterEntites(Entite e){
        lesEntites.add(e);
        if (e instanceof IA){
            lesIA.add((IA) e);
        }
    }

    /**
     * Supprimer entites.
     *
     * @param e entite a supprimer
     */
    public void supprimerEntites(Entite e){
        lesEntites.remove(e);
        if (e instanceof IA){
            lesIA.remove(e);
        }
    }

    /**
     * Supprime toutes les IA et Entites lors de la fin de partie
     */
    public void supprimerToutEntites(){
        Iterator<Entite> it1 = lesEntites.iterator();
        while(it1.hasNext()){
            Entite e = it1.next();
            it1.remove();
        }
        Iterator<IA> it2 = lesIA.iterator();
        while(it2.hasNext()){
            Entite e = it2.next();
            it2.remove();
        }
    }

}
