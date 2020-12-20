package modele.createur;

import modele.Carte;
import modele.entite.personnages.PersoPrincipal;

import java.util.Random;

public abstract class CreateurEntite {
    protected Random alea = new Random();

    public abstract PersoPrincipal creerPersoPrincipal(Carte carte);
    public abstract void creerIA(Carte carte);
    public abstract void creerRocher(Carte carte);
    public abstract void creerArme(Carte carte);
    public abstract void creerCombinaison(Carte carte);
    public abstract void creerMasque(Carte carte);
    public abstract void creerVisiere(Carte carte);

}
