package Statics;

import Classes.Dresseur;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Logger;

public class Liste_Dresseurs implements Serializable {
    public static HashSet<Dresseur> liste_dresseurs = new HashSet<>();

    public static void ajouterDresseur(Dresseur a_ajouter){
        liste_dresseurs.add(a_ajouter);
    }

    public static void afficherDresseurs(){
        SortedSet<Dresseur> liste_trie = new TreeSet<>(new Comparator<>() {
            @Override
            public int compare(Dresseur dresseur, Dresseur t1) {
                if(dresseur.getNb_victoire()>t1.getNb_victoire()) return 1;
                else return 0;
            }
        });
        liste_trie.addAll(liste_dresseurs);
        Logger l = Logger.getLogger("Dresseurs_par_victoires");
        for (Dresseur dresseur : liste_trie) {
            l.info(dresseur.toString());
        }
    }

}
