package Statics;

import Classes.Dresseur;
import javafx.collections.transformation.SortedList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Logger;

public class Liste_Dresseurs {
    public static Set<Dresseur> liste_dresseurs = new HashSet<>();

    public static void ajouterDresseur(Dresseur a_ajouter) {
        liste_dresseurs.add(a_ajouter);
    }

    public static void afficherDresseurs() {
        List<Dresseur> liste_trie = new ArrayList<>(liste_dresseurs);
        liste_trie.sort(new Comparator<Dresseur>() {
            @Override
            public int compare(Dresseur dresseur, Dresseur t1) {
                return dresseur.getNb_victoire().compareTo(t1.getNb_victoire());
            }
        });
        Logger l = Logger.getLogger("Dresseurs_par_victoires");
        for (Dresseur dresseur : liste_trie) {
            l.info(dresseur.toString());
        }
    }

    public static void sauvegarderDresseurs() {
        File output = new File("dresseurs.sav");
        try {
            FileOutputStream ofs = new FileOutputStream(output);
            ObjectOutputStream oos = new ObjectOutputStream(ofs);

            oos.writeObject(liste_dresseurs);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void chargerDresseurs() {
        File input = new File("dresseurs.sav");
        FileInputStream ifs;
        try {
            ifs = new FileInputStream(input);
            ObjectInputStream ois = new ObjectInputStream(ifs);

            Liste_Dresseurs.liste_dresseurs = (HashSet<Dresseur>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
