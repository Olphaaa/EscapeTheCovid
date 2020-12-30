package modele.ramasseur;

import modele.Carte;
import modele.entite.Entite;
import modele.entite.Rocher;
import modele.entite.equipements.Equipement;
import modele.entite.equipements.protections.Protection;
import modele.entite.personnages.IA;
import modele.entite.personnages.PersoPrincipal;

import java.util.Iterator;

public class RamasseurSimple extends Ramasseur{

    public RamasseurSimple(Carte laCarte) {
        super(laCarte);
    }

    @Override
    public boolean isPresent(double x, double y) {
        Iterator<Entite> it = laCarte.getLesEntites().iterator();
        while (it.hasNext()){
            Entite e = it.next();
            if (e instanceof PersoPrincipal || e instanceof IA || e instanceof Rocher)
                continue;

            if (x > e.getX()-40 && x < e.getX()+40 && y>e.getY()-40 && y<e.getY()+40){
                PersoPrincipal pp = ((PersoPrincipal)  laCarte.getLesEntites().get(0));
                pp.ajouterEquipement((Equipement) e);
                pp.setX(45);
                pp.setY(375);

                return e instanceof Protection;
            }
        }
        return true;
    }

    @Override
    public void Ramasser() {
    }
}
