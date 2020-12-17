package modele.spawner;

import modele.Carte;
import modele.createur.CreateurSimple;
import modele.entite.Entite;

public abstract class Spawner {
    public abstract void spanw(CreateurSimple cs, Carte carte);
}
