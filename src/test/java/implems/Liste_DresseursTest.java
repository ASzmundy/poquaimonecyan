package implems;

import implems.humains.Dresseur;
import implems.uniques.Liste_Dresseurs;
import implems.uniques.Poquaidexe;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class Liste_DresseursTest {


    @Test
    public void testajouterDresseur() {
        Poquaidexe p = new Poquaidexe();
        Liste_Dresseurs ld = new Liste_Dresseurs();
        Dresseur d = new Dresseur("Testman","Test",ld);
        d.ajouterPoquaimone(4,p);
        ld.ajouterDresseur(d);
        Iterator<Dresseur> i= ld.liste_dresseurs.iterator();
        assertNotEquals("Le dresseur doit être dans la liste",false,i.hasNext());
        assertNotNull("Le dresseur doit avoir un poquaimone",i.next().getEquipe().get(0));
    }

    @Test
    public void testafficherDresseurs() {
        Liste_Dresseurs ld = new Liste_Dresseurs();
        Poquaidexe p = new Poquaidexe();
        Dresseur d = new Dresseur("Testman","Test",ld);
        d.ajouterPoquaimone(4,p);
        d.ajouterPoquaimone(13,p);
        d.ajouterPoquaimone(20,p);
        d = new Dresseur("Jérôman","Jérôme",ld);
        d.ajouterPoquaimone(1,p);
        d.ajouterPoquaimone(10,p);
        d.ajouterPoquaimone(14,p);
        ld.afficherDresseursTrie();
    }

    @Test
    public void TestSauvegarde() {
        Liste_Dresseurs ld = new Liste_Dresseurs();
        Poquaidexe p = new Poquaidexe();
        Dresseur d = new Dresseur("Kensington", "Charles",ld);
        d.ajouterPoquaimone(1,p);
        d.ajouterPoquaimone(11,p);
        ld.afficherDresseursTrie();
        ld.sauvegarderDresseurs();
    }

    @Test
    public void TestChargement(){
        Liste_Dresseurs ld = new Liste_Dresseurs();
        ld.chargerDresseurs();
        assertNotNull("Échec du chargement : Liste_Dresseurs = null !",ld.liste_dresseurs);
        ld.afficherDresseursTrie();

    }
}