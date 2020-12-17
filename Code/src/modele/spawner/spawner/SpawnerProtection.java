package modele.spawner.spawner;

import modele.Carte;
import modele.createur.CreateurSimple;
import modele.entite.Entite;
import modele.entite.equipements.protections.Combinaison;
import modele.entite.equipements.protections.Masque;
import modele.entite.equipements.protections.Protection;
import modele.entite.equipements.protections.Visiere;
import modele.spawner.Spawner;

import java.util.Random;

public class SpawnerProtection extends Spawner {
    @Override
    public void spanw(CreateurSimple cs, Carte carte) {
        Random rand = new Random();
        double taux = rand.nextFloat();
        if (taux > 0 && taux < 0.10){
            cs.creerCombinaison(carte);
        }else if (taux >=0.10 && taux <0.40){
            cs.creerVisiere(carte);
        }else {
            cs.creerMasque(carte);
        }
    }
}
