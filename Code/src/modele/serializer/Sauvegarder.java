package modele.serializer;

import modele.score.Score;

public abstract class Sauvegarder {
    /**
     * Seconde classe de notre serializer
     * C'est un point d'extension à plusieur type de sérialisation tel que Xml, JSON ou encore binaire.
     * Elle permet de sauvegarder un tableau de score dans un fichier.
     */
    public void SauvegarderDonnee(Score score){}

}
