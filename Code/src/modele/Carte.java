package modele;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.entite.Entite;
import modele.entite.personnages.IA;

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
    public void supprimerEntites(Entite e){lesEntites.remove(e);}

}
