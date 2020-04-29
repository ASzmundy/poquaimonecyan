package Statics;

import Classes.Dresseur;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class Liste_DresseursTest {


    @Test
    public void testajouterDresseur() {
        Poquaidexe.remplirPoquaidexe();
        Dresseur d = new Dresseur("Testman","Test");
        d.ajouterPoquaimone(4);
        Liste_Dresseurs.ajouterDresseur(d);
        Iterator<Dresseur> i= Liste_Dresseurs.liste_dresseurs.iterator();
        assertNotEquals("Le dresseur doit être dans la liste",false,i.hasNext());
        assertNotNull("Le dresseur doit avoir un poquaimone",i.next().getEquipe().get(0));
    }

    @Test
    public void testafficherDresseurs() {
        Dresseur d = new Dresseur("Testman","Test");
        d.ajouterPoquaimone(4);
        d.ajouterPoquaimone(13);
        d.ajouterPoquaimone(20);
        Liste_Dresseurs.ajouterDresseur(d);
        d = new Dresseur("Jérôman","Jérôme");
        d.ajouterPoquaimone(1);
        d.ajouterPoquaimone(10);
        d.ajouterPoquaimone(14);
        Liste_Dresseurs.ajouterDresseur(d);
        Liste_Dresseurs.afficherDresseursTrie();
    }

    @Test
    public void testSauvegarde(){
        Dresseur d = new Dresseur("Testman","Test");
        d.ajouterPoquaimone(4);
        d.ajouterPoquaimone(9);
        d.ajouterPoquaimone(8);
    }
}