package modele.carte;

import modele.entite.Rocher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Carte {
    private int nbRochers;
    private final List<Rocher> rocher = new ArrayList<Rocher>();

    public Carte(int nivDifficulte){
        Random rand = new Random();
        switch (nivDifficulte){
            case 1:
                nbRochers= rand.nextInt(5);
            case 2:
                nbRochers = rand.nextInt(5)+5;
            case 3:
                nbRochers = rand.nextInt(10)+10;
        }

        for(int i=0; i<nbRochers; i++)
        {
            rocher.set(i, new Rocher());
        }
    }
}
