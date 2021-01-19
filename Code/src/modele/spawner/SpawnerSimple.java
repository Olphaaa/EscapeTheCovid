package modele.spawner;

import modele.Carte;
import modele.createur.CreateurSimple;

import java.util.Random;

/**
 * Spawner simple classe fille du Spawner.
 * Permet de faire spawner les rochers au début de la partie
 * Permet de faire spawner une protection en fonciton du taux d'apparition
 */
public class SpawnerSimple extends Spawner {

    /**
     * Fait spawn une protection en fonction de son taux d'appartion
     * @param cs Créateur simple
     * @param carte Carte pour la création de la protection
     */
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

    /**
     * Fait spawn un nombre de Rocher aléatoirement qui dépend du niveau de difficulté sur la carte
     * @param cs Créateur seimple
     * @param carte Carte
     * @param difficulte niveau de difficulté
     */
    @Override
    public void spawnRocher(CreateurSimple cs, Carte carte, int difficulte) {
        for (int i = 0 ; i < 7*difficulte ; i++)
        {
            cs.creerRocher(carte);
        }
    }
}
