package modele.collisionneur;

import modele.Carte;
import modele.Manager;
import modele.entite.Entite;
import modele.entite.equipements.Equipement;
import modele.entite.equipements.protections.Protection;
import modele.entite.personnages.IA;
import modele.entite.personnages.PersoPrincipal;
import modele.entite.personnages.Personnage;

import java.util.Iterator;

public class CollisionneurSimple extends Collisionneur {

    public CollisionneurSimple(Carte laCarte, Manager m) {
        super(laCarte,m);
    }

    @Override
    public boolean canMove(double x, double y) {
        if (x>24 && x<=getWidth()-84 && y>24 && y<=getHeight()-105 && isPresent(x,y))
            return true;
        return false;
    }


    @Override
    public boolean isPresent(double x, double y) {
        Iterator<Entite> it = laCarte.getLesEntites().iterator();
        while (it.hasNext()){
            Entite e = it.next();
            if (e instanceof PersoPrincipal)
                continue;
            if (x > e.getX()-40 && x < e.getX()+40 && y>e.getY()-40 && y<e.getY()+40){
                if (e instanceof Protection){
                    PersoPrincipal pp = ((PersoPrincipal)  laCarte.getLesEntites().get(0));
                    pp.ajouterEquipement((Equipement) e);
                    pp.setPv(pp.getPv()+pp.getProtection().niveauProtection);
                    leManager.setVie(String.valueOf(pp.getPv()+pp.getProtection().niveauProtection));
                    laCarte.supprimerEntites(e);
                    return true;
                }
                if (e instanceof IA /*&& ((IA) e).isInfect()*/){ // si on rencontre une IA alors... todo enlever le /**/ une fois la contamination faite
                    PersoPrincipal pp = ((PersoPrincipal)  laCarte.getLesEntites().get(0));
                    pp.seFaireToucher();
                    pp.setX(45);
                    pp.setY(375);
                }
                return false;
            }
        }
        return true;
    }
}
