package modele.createur;

import modele.Carte;
import modele.entite.Rocher;
import modele.entite.equipements.protections.Combinaison;
import modele.entite.equipements.protections.Masque;
import modele.entite.equipements.protections.Visiere;
import modele.entite.personnages.IA;
import modele.entite.personnages.PersoPrincipal;

public class CreateurSimple extends CreateurEntite{
    @Override
    public PersoPrincipal creerPersoPrincipal(Carte carte) {
        PersoPrincipal perso = new PersoPrincipal();
        carte.ajouterEntites(perso);
        return perso;
    }

    @Override
    public void creerIA(Carte carte) {carte.ajouterEntites(new IA()); }

    @Override
    public void creerRocher(Carte carte) {carte.ajouterEntites(new Rocher());}

    @Override
    public void creerArme(Carte carte) {}

    @Override
    public void creerCombinaison(Carte carte) {carte.ajouterEntites(new Combinaison());}

    @Override
    public void creerMasque(Carte carte) {carte.ajouterEntites(new Masque());}

    @Override
    public void creerVisiere(Carte carte) {carte.ajouterEntites(new Visiere());}
}
