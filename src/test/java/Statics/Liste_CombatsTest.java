package Statics;

import Classes.Arbitre;
import Classes.Dresseur;
import Exceptions.ExceptionAucunCombatProgramme;
import Exceptions.ExceptionDresseursIdentiques;
import org.junit.Test;

import static org.junit.Assert.*;

public class Liste_CombatsTest {



    @Test
    public void testListeCombat() { //test des méthodes de Liste_Combat
        Dresseur d1=new Dresseur("Testman","Georges");
        d1.ajouterPoquaimone(4);
        d1.ajouterPoquaimone(17);
        d1.ajouterPoquaimone(12);
        Dresseur d2=new Dresseur("Testwoman","Helena");
        d2.ajouterPoquaimone(2);
        d2.ajouterPoquaimone(20);
        d2.ajouterPoquaimone(7);
        Dresseur d3=new Dresseur("Palareff","Michel");
        d3.ajouterPoquaimone(8);
        d3.ajouterPoquaimone(18);
        Arbitre a =new Arbitre("Larbitre","Stéphane");
        try {
            Liste_Combats.organiserCombat(d1,d2,a);
            Liste_Combats.organiserCombat(d1,d3,a);
            Liste_Combats.organiserCombat(d2,d3,a);
            assertNotNull(Liste_Combats.combats_programmes.peek());
            Liste_Combats.afficherListe();
        }catch (ExceptionDresseursIdentiques e){
            e.printStackTrace();
        }
        Liste_Combats.listerCombatDresseur(d1);
        try {
            Liste_Combats.lancerCombat();
            Liste_Combats.listerCombatDresseur(d1);
        }catch (ExceptionAucunCombatProgramme e){
            e.printStackTrace();
        }
    }

}