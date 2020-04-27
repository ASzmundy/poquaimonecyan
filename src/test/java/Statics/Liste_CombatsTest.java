package Statics;

import Classes.Dresseur;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class Liste_CombatsTest {


    @BeforeClass
    public static void initialisation(){
        Dresseur d1=new Dresseur("Testman","Georges");
        d1.ajouterPoquaimone(4);
        d1.ajouterPoquaimone(17);
    }
    @Test
    public void testajouterCombat() {
    }

    @Test
    public void organiserCombat() {
    }

    @Test
    public void lancerCombat() {
    }

    @Test
    public void listerCombatDresseur() {
    }
}