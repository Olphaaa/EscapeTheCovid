package modele.spawner;

import modele.Carte;
import modele.createur.CreateurSimple;
import modele.entite.Entite;

public abstract class Spawner {
    public abstract void spanwProtection(CreateurSimple cs, Carte carte);
    public abstract void spanwRocher(CreateurSimple cs, Carte carte, int difficulte);
}
