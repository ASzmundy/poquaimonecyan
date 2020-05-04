package implems.sauvegardes;
import exceptions.combat.ExceptionDresseursIdentiques;
import exceptions.poquai.ExceptionPoquaiIntrouvable;
import implems.humains.Arbitre;
import implems.humains.Dresseur;
import implems.listes.Liste_Combats;
import implems.listes.Liste_Dresseurs;
import implems.listes.Poquaidexe;
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
            d1.ajouterPoquaimone(4);
            d1.ajouterPoquaimone(17);
            d1.ajouterPoquaimone(12);

            d2.ajouterPoquaimone(2);
            d2.ajouterPoquaimone(20);
            d2.ajouterPoquaimone(7);

            d3.ajouterPoquaimone(8);
            d3.ajouterPoquaimone(18);
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
        Monde m = new Monde(lc,ld);
        m.sauvegarderMonde("mondetest");
        }


    @Test
    public void chargerMonde() {
        Monde m=Monde.chargerMonde("mondetest");
        assertNotNull("Monde chargé incorrectement",m);
        assertNotNull("Liste combat chargé incorrectement",m.getListe_combats());
        assertNotNull("Liste dresseurs chargé incorrectement",m.getListe_dresseurs());
        m.getListe_dresseurs().afficherDresseursTrie();
        m.getListe_combats().afficherListe();
    }
}