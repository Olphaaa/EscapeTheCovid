package modele;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.entite.Entite;

public class Carte {


    private ObservableList<Entite> lesEntites = FXCollections.observableArrayList();

    public ObservableList<Entite> getLesEntites() {return FXCollections.unmodifiableObservableList(lesEntites);}
    public void ajouterEntites(Entite e){lesEntites.add(e);}
    public void supprimerEntites(Entite e){lesEntites.remove(e);}

}
