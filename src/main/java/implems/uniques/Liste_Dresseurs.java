package implems.uniques;

import implems.humains.Dresseur;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class Liste_Dresseurs implements Serializable {
    public Set<Dresseur> liste_dresseurs;

    public Liste_Dresseurs(){
        liste_dresseurs = new HashSet<>();
    }

    public void ajouterDresseur(Dresseur a_ajouter) {
        liste_dresseurs.add(a_ajouter);
    }

    public void afficherDresseursTrie() {
        List<Dresseur> liste_trie = new ArrayList<>(liste_dresseurs);
        String a_afficher="\n";
        liste_trie.sort(new Comparator<>() {
            @Override
            public int compare(Dresseur dresseur, Dresseur t1) {
                return dresseur.getNb_victoire().compareTo(t1.getNb_victoire());
            }
        });
        Logger l = Logger.getLogger("Dresseurs_par_victoires");
        for (Dresseur dresseur : liste_trie) {
            a_afficher=a_afficher+dresseur.toString()+"\n";
        }
        if(!a_afficher.equals("\n")) {
            l.info(a_afficher);
        }else l.warning("Liste vide");
    }

    public void sauvegarderDresseursJSON() {

    }

    public void chargerDresseursJSON() {

    }



}
