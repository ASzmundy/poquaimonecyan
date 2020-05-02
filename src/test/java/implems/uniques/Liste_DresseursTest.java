package implems.uniques;

import exceptions.poquai.ExceptionPoquaiIntrouvable;
import implems.humains.Dresseur;
import org.junit.Test;

import java.util.Iterator;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class Liste_DresseursTest {


    @Test
    public void testajouterDresseur() {
        Poquaidexe p = new Poquaidexe();
        Liste_Dresseurs ld = new Liste_Dresseurs();
        Dresseur d = new Dresseur("Testman","Test",ld);
        try {
            d.ajouterPoquaimone(4);
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
            d1.ajouterPoquaimone(4);
            d1.ajouterPoquaimone(13);
            d1.ajouterPoquaimone(20);

            d2.ajouterPoquaimone(1);
            d2.ajouterPoquaimone(10);
            d2.ajouterPoquaimone(14);
        }catch (ExceptionPoquaiIntrouvable e){
            e.printStackTrace();
        }
        ld.afficherDresseursTrie();
    }

    @Test
    public void TestJson() {
        Liste_Dresseurs ld = new Liste_Dresseurs();
        Dresseur d1 = new Dresseur(ld);
        Dresseur d2 = new Dresseur("Jérôman","Jérôme",ld);
        assertNotNull(d1);
        try {
            d1.ajouterPoquaimone(4);
            d1.ajouterPoquaimone(13);
            d1.ajouterPoquaimone(20);

            d2.ajouterPoquaimone(1);
            d2.ajouterPoquaimone(10);
            d2.ajouterPoquaimone(14);
        }catch (ExceptionPoquaiIntrouvable e){
            e.printStackTrace();
        }
        String json =ld.sauvegarderDresseursJSON();
        Logger l = Logger.getLogger("Log_json");
        l.info(json);
    }
}