package implems;

import exceptions.humains.ExceptionAmiNonTrouve;
import exceptions.combat.ExceptionAucunCombatProgramme;
import exceptions.combat.ExceptionCombatNonTrouve;
import exceptions.combat.ExceptionDresseursIdentiques;
import implems.combat.Combat;
import implems.humains.Arbitre;
import implems.humains.Dresseur;
import implems.humains.Humain;
import implems.uniques.Liste_Combats;
import implems.uniques.Liste_Dresseurs;
import implems.uniques.Poquaidexe;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class CombatTest {

    @Test
    public void testCombat() { //Pour tester la classe combat
        Poquaidexe p = new Poquaidexe();
        Liste_Dresseurs ld = new Liste_Dresseurs();
        Logger l = Logger.getLogger("log_erreurs");
        Dresseur d1 = new Dresseur("Testman","Test",ld);
        d1.ajouterPoquaimone(4,p);
        Dresseur d2 = new Dresseur();
        d2.ajouterPoquaimone(1,p);
        d2.ajouterPoquaimone(17,p);
        Arbitre a = new Arbitre("Larbitre","Luc");
        Combat c = null;
        Liste_Combats lc = new Liste_Combats();
        try {
            c = new Combat(d1, d2, a,lc);
        }catch (ExceptionDresseursIdentiques e){
            e.printStackTrace();
        }
        assertNotNull("Combat inexistant !",c);
        assertNotNull("Le combat doit avoir un dresseur 1",c.getDresseur1());
        assertNotNull("Le combat doit avoir un dresseur 2",c.getDresseur2());
        assertNotNull("Le combat doit avoir un arbitre",c.getArbitre());
        assertNotNull("Le dresseur 1 doit avoir au moins un poquaimone",c.getDresseur1().getEquipe().get(0));
        assertNotNull("Le dresseur 2 doit avoir au moins un poquaimone",c.getDresseur2().getEquipe().get(0));
        Humain h1 = new Humain("Lesuisse","Jean");
        d1.ajouterAmi(h1);
        try {
            d1.inviterAmi(h1,c);
            lc.lancerCombat();
        }catch (ExceptionAmiNonTrouve eant){
            l.severe("Ami non trouvé");
        }catch (ExceptionCombatNonTrouve ecnt){
            l.severe("L'ami est invité à un combat inexistant");
        }catch (ExceptionAucunCombatProgramme eacp){
            l.severe("Aucun combat programmé");
        }
    }
}