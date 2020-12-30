package modele.spawner;

import modele.Carte;
import modele.createur.CreateurSimple;
import modele.entite.Entite;

public abstract class Spawner {
    public abstract void spawnProtection(CreateurSimple cs, Carte carte);
    public abstract void spawnRocher(CreateurSimple cs, Carte carte, int difficulte);
}
