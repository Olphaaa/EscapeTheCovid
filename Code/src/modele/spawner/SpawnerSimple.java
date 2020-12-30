package modele.spawner;

import modele.Carte;
import modele.createur.CreateurSimple;

import java.util.Random;

public class SpawnerSimple extends Spawner {

    @Override
    public void spawnProtection(CreateurSimple cs, Carte carte) {
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

    @Override
    public void spawnRocher(CreateurSimple cs, Carte carte, int difficulte) {
        for (int i = 0 ; i < 7*difficulte ; i++)
        {
            cs.creerRocher(carte);
        }
    }
}
