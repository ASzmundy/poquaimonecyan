package implems;

import exceptions.poquai.ExceptionPoquaiIntrouvable;
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
        try {
            d.ajouterPoquaimone(4, p);
        }catch (ExceptionPoquaiIntrouvable e){
            e.printStackTrace();
        }
        Iterator<Dresseur> i= ld.liste_dresseurs.iterator();
        assertNotEquals("La liste doit pas être vide",false,i.hasNext());
        Dresseur dl = i.next();
        assertEquals("Le dresseur doit être dans la liste",d,dl);
        assertNotNull("Le dresseur doit avoir un poquaimone",dl.getEquipe().get(0));
    }

    @Test
    public void testafficherDresseurs() {
        Liste_Dresseurs ld = new Liste_Dresseurs();
        Poquaidexe p = new Poquaidexe();
        Dresseur d1 = new Dresseur(ld);
        Dresseur d2 = new Dresseur("Jérôman","Jérôme",ld);
        assertNotNull(d1);
        try {
            d1.ajouterPoquaimone(4, p);
            d1.ajouterPoquaimone(13, p);
            d1.ajouterPoquaimone(20, p);

            d2.ajouterPoquaimone(1, p);
            d2.ajouterPoquaimone(10, p);
            d2.ajouterPoquaimone(14, p);
        }catch (ExceptionPoquaiIntrouvable e){
            e.printStackTrace();
        }
        ld.afficherDresseursTrie();
    }

    @Test
    public void TestSauvegarde() {
        Liste_Dresseurs ld = new Liste_Dresseurs();
        Poquaidexe p = new Poquaidexe();
        Dresseur d = new Dresseur("Kensington", "Charles",ld);
        assertNotNull(p.poquaidexe);
        assertNotNull(d);
        try {
            d.ajouterPoquaimone(1, p);
            d.ajouterPoquaimone(17, p);
            assertNotNull("le dresseur doit avoir des poquaimones",d.getEquipe().get(0));
            assertNotNull("le dresseur doit avoir des poquaimones",d.getEquipe().get(1));
        }catch (ExceptionPoquaiIntrouvable e){
            e.printStackTrace();
        }
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