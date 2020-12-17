package modele.deplaceur;

import modele.entite.Entite;


public class Deplaceur {

    protected int pas = 7;

    public void deplacerHaut(Entite e){ e.setPPerso(e.getX(), e.getY()-pas); }
    public void deplacerBas(Entite e){e.setPPerso(e.getX(), e.getY()+pas);}
    public void deplacerGauche(Entite e){e.setPPerso(e.getX()-pas, e.getY());}
    public void deplacerDroit(Entite e){e.setPPerso(e.getX()+pas, e.getY());}
}
