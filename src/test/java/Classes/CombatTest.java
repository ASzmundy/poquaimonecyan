package Classes;

import Exceptions.*;
import Statics.Liste_Combats;
import Statics.Poquaidexe;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class CombatTest {

    @Test
    public void testCombat() { //Pour tester la classe combat
        Poquaidexe.remplirPoquaidexe();
        Logger l = Logger.getLogger("log_erreurs");
        Dresseur d1 = new Dresseur("Testman","Test");
        d1.ajouterPoquaimone(4);
        Dresseur d2 = new Dresseur();
        d2.ajouterPoquaimone(1);
        d2.ajouterPoquaimone(17);
        Arbitre a = new Arbitre("Larbitre","Luc");
        Combat c = null;
        try {
            c = new Combat(d1, d2, a);
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
            Liste_Combats.lancerCombat();
        }catch (ExceptionAmiNonTrouve eant){
            l.severe("Ami non trouvé");
        }catch (ExceptionCombatNonTrouve ecnt){
            l.severe("L'ami est invité à un combat inexistant");
        }catch (ExceptionAucunCombatProgramme eacp){
            l.severe("Aucun combat programmé");
        }
    }
}