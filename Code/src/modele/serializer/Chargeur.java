package modele.serializer;

import modele.score.TableauScore;

/**
 * Première classe de notre serializer
 * C'est un point d'extension à plusieur type de sérialisation tel que Xml, JSON ou encore binaire.
 * Elle permet de récupérer les données d'un fichier pour s'en servir ensuite dans l'application.
 */
public abstract class Chargeur {

    public TableauScore chargerDonnee() {return null;}

}
