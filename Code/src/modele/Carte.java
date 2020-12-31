package modele;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.entite.Entite;
import modele.entite.personnages.IA;

public class Carte {


    private ObservableList<Entite> lesEntites = FXCollections.observableArrayList();
    private ObservableList<IA> lesIA = FXCollections.observableArrayList();


    public ObservableList<Entite> getLesEntites() {return FXCollections.unmodifiableObservableList(lesEntites);}
    public ObservableList<IA> getLesIA() {return FXCollections.unmodifiableObservableList(lesIA);}
    public void ajouterEntites(Entite e){
        lesEntites.add(e);
        if (e instanceof IA){
            lesIA.add((IA) e);
        }
    }
    public void supprimerEntites(Entite e){lesEntites.remove(e);}

}
