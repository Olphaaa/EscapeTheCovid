package modele.collisionneur;

import modele.Carte;
import modele.Manager;
import modele.entite.Entite;
import modele.entite.Rocher;
import modele.entite.equipements.Equipement;
import modele.entite.equipements.protections.Protection;
import modele.entite.personnages.IA;
import modele.entite.personnages.PersoPrincipal;

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


    public IA isPresentAttaq(double x, double y){
        Iterator<Entite> it = laCarte.getLesEntites().iterator();
        while (it.hasNext()){
            Entite e = it.next();
            if (e instanceof PersoPrincipal)
                continue;

            if (x > e.getX()-100 && x < e.getX()+100 && y>e.getY()-100 && y<e.getY()+100) {
                if (e instanceof Rocher || e instanceof Protection){
                    continue;
                }else{return (IA) e;}
            }
        }
        return null;
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
                    PersoPrincipal pp = super.leManager.perso;
                    //pp.retirerEquipement();//todo les images se superposent (je pense que c'est pour ca qu'au bout d'un moment le jeu lag)
                    pp.ajouterEquipement((Equipement) e);
                    pp.setPv(pp.getPv()+pp.getProtection().niveauProtection);
                    leManager.setVie(String.valueOf(pp.getPv()+pp.getProtection().niveauProtection));
                    laCarte.supprimerEntites(e);
                    return true;
                }
                if (e instanceof IA && ((IA) e).isInfect()){
                    //PersoPrincipal pp = ((PersoPrincipal)  laCarte.getLesEntites().get(0));
                    PersoPrincipal pp = super.leManager.perso;
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
