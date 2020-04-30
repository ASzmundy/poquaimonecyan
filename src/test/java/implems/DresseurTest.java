package implems;

import implems.humains.Dresseur;
import implems.uniques.Poquaidexe;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class DresseurTest {

    @Test
    public void testConstructDresseur() {
        Dresseur d = new Dresseur();
        assertNotNull("Le nom doit pas être vide",d.getNom());
        assertNotNull("Le prénom doit pas être vide",d.getPrenom());
    }

    @Test
    public void testAjoutPoque() {
        Dresseur d = new Dresseur();
        Poquaidexe p = new Poquaidexe();
        d.ajouterPoquaimone(20,p);
        Logger l = Logger.getLogger("Log_test");
        assertNotNull(d.getEquipe().get(0));
        assertFalse("Le poquaimone ne doit pas être une evolution", p.poquaidexe.get(d.getEquipe().get(0).getId()-1).isEvoluable());
        l.info(d.getEquipe().get(0).toString());
        d.ajouterPoquaimone(16,p);
        assertFalse("Le poquaimone ne doit pas être une evolution", p.poquaidexe.get(d.getEquipe().get(1).getId()-1).isEvoluable());
        l.info(d.getEquipe().get(1).toString());
    }


}