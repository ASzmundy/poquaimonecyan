package implems.uniques;

import exceptions.combat.ExceptionAucunCombatProgramme;
import exceptions.combat.ExceptionDresseursIdentiques;
import exceptions.poquai.ExceptionPoquaiIntrouvable;
import implems.humains.Arbitre;
import implems.humains.Dresseur;
import implems.uniques.Liste_Combats;
import implems.uniques.Liste_Dresseurs;
import implems.uniques.Poquaidexe;
import org.junit.Test;

import static org.junit.Assert.*;

public class Liste_CombatsTest {



    @Test
    public void testListeCombat() { //test des méthodes de Liste_Combat
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
        }catch (ExceptionPoquaiIntrouvable e){
            e.printStackTrace();
        }
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
        lc.listerCombatDresseur(d1);
        try {
            lc.lancerCombat();
            lc.listerCombatDresseur(d1);
        }catch (ExceptionAucunCombatProgramme e){
            e.printStackTrace();
        }
    }

}