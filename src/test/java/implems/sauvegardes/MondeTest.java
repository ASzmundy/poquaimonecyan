package implems.sauvegardes;
import exceptions.combat.ExceptionDresseursIdentiques;
import exceptions.poquai.ExceptionPoquaiIntrouvable;
import implems.humains.Arbitre;
import implems.humains.Dresseur;
import implems.uniques.Liste_Combats;
import implems.uniques.Liste_Dresseurs;
import implems.uniques.Poquaidexe;
import org.junit.Test;

import static org.junit.Assert.*;

public class MondeTest {

    @Test
    public void sauvegarderMonde() {
        Liste_Dresseurs ld = new Liste_Dresseurs();
        Dresseur d1=new Dresseur("Testman","Georges",ld);
        Dresseur d2=new Dresseur("Testwoman","Helena",ld);
        Dresseur d3=new Dresseur("Palareff","Michel",ld);
        Poquaidexe p = new Poquaidexe();
        try {
            d1.ajouterPoquaimone(4, p);
            d1.ajouterPoquaimone(17, p);
            d1.ajouterPoquaimone(12, p);

            d2.ajouterPoquaimone(2, p);
            d2.ajouterPoquaimone(20, p);
            d2.ajouterPoquaimone(7, p);

            d3.ajouterPoquaimone(8, p);
            d3.ajouterPoquaimone(18, p);
        }
        catch (ExceptionPoquaiIntrouvable e){
            e.printStackTrace();
        }
        ld.afficherDresseursTrie();
        Arbitre a =new Arbitre("Larbitre","Stéphane");
        Liste_Combats lc = new Liste_Combats();
        try {
            lc.organiserCombat(d1,d2,a);
            lc.organiserCombat(d1,d3,a);
            lc.organiserCombat(d2,d3,a);
            assertNotNull(lc.combats_programmes.peek());
            lc.afficherListe();
        }catch (ExceptionDresseursIdentiques e){
            e.printStackTrace();
        }
        Monde m = new Monde(lc,ld,p);
        m.sauvegarderMonde("mondetest");
        }


    @Test
    public void chargerMonde() {
        Monde m=Monde.chargerMonde("mondetest");
        assertNotNull("Monde chargé incorrectement",m);
        assertNotNull("Liste combat chargé incorrectement",m.liste_combats);
        assertNotNull("Liste dresseurs chargé incorrectement",m.liste_dresseurs);
        m.liste_dresseurs.afficherDresseursTrie();
        m.liste_combats.afficherListe();
    }
}