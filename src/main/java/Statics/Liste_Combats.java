package Statics;

import Classes.Arbitre;
import Classes.Combat;
import Classes.Dresseur;
import Exceptions.ExceptionAucunCombatProgramme;
import Exceptions.ExceptionPasDArbitre;
import Exceptions.ExceptionPasDeDresseur;
import Exceptions.ExceptionPasDePoque;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

public class Liste_Combats implements Serializable {
    public static Queue<Combat> combats_programmes= new ConcurrentLinkedQueue<>();

    public static void ajouterCombat(Combat a_ajouter){
            combats_programmes.add(a_ajouter);
    }

    public static void combatTermine(){
        combats_programmes.poll();
    }
    public static String afficherListe(){
        return combats_programmes.toString();
    }

    public static void organiserCombat(Dresseur dresseur1, Dresseur dresseur2, Arbitre arbitre) throws ExceptionPasDeDresseur{
        if(dresseur1!=dresseur2) {
            Combat nouveau_combat = new Combat(dresseur1, dresseur2, arbitre);
            Liste_Combats.ajouterCombat(nouveau_combat);
        }else throw new ExceptionPasDeDresseur();
    }

    public static void lancerCombat() throws ExceptionAucunCombatProgramme{
        Logger l = Logger.getLogger("Log_Lancercombat");
        if(combats_programmes.peek()!=null){
            try {
                combats_programmes.peek().commencerCombat();
            }catch (ExceptionPasDArbitre epa){
                l.severe("Pas d'arbitre dans ce combat !");
            }catch (ExceptionPasDeDresseur epd){
                l.severe("Pas ou pas assez de dresseur(s) dans ce combat !");
            }catch (ExceptionPasDePoque epp){
                l.severe("Un des dresseurs n'a pas de poque");
            }
            combatTermine();
        }else throw new ExceptionAucunCombatProgramme();
    }

    public static void listerCombatDresseur(Dresseur dresseur){
        Iterator<Combat> i=combats_programmes.iterator();
        Logger l = Logger.getLogger("Log_ListeCombatDresseur");
        while (i.hasNext()) {
            if(i.next().getDresseur1()==dresseur||i.next().getDresseur2()==dresseur) {
                l.info(i.next().toString());
            }
        }
    }
}
