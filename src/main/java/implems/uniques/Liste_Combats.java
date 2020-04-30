package implems.uniques;

import exceptions.combat.ExceptionAucunCombatProgramme;
import exceptions.combat.ExceptionDresseursIdentiques;
import exceptions.combat.ExceptionPasDArbitre;
import exceptions.combat.ExceptionPasDeDresseur;
import exceptions.combat.ExceptionPasDePoque;
import implems.combat.Combat;
import implems.humains.Arbitre;
import implems.humains.Dresseur;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

public class Liste_Combats implements Serializable{
    public Queue<Combat> combats_programmes;

    public Liste_Combats(){
        combats_programmes = new ConcurrentLinkedQueue<>();
    }

    public void ajouterCombat(Combat a_ajouter){
            combats_programmes.add(a_ajouter);
    }

    public void afficherListe(){
        Logger l = Logger.getLogger("log_liste_combats");
        String a_afficher="\n";
        for (Combat combat : combats_programmes) {
            a_afficher+=combat.nomCombat()+"\n";
        }
        if(!a_afficher.equals("\n")) {
            l.info(a_afficher);
        }else l.warning("Liste vide");
    }

    public void organiserCombat(Dresseur dresseur1, Dresseur dresseur2, Arbitre arbitre) throws ExceptionDresseursIdentiques{
        if(dresseur1!=dresseur2) {
            Combat nouveau_combat = new Combat(dresseur1, dresseur2, arbitre, this);
        }else throw new ExceptionDresseursIdentiques();
    }

    public void lancerCombat() throws ExceptionAucunCombatProgramme{
        Logger l = Logger.getLogger("Log_Lancercombat");
        if(combats_programmes.peek()!=null){
            try {
                combats_programmes.poll().commencerCombat();
            }catch (ExceptionPasDArbitre epa){
                l.severe("Pas d'arbitre dans ce combat !");
            }catch (ExceptionPasDeDresseur epd){
                l.severe("Pas ou pas assez de dresseur(s) dans ce combat !");
            }catch (ExceptionPasDePoque epp){
                l.severe("Un des dresseurs n'a pas de poque");
            }
        }else throw new ExceptionAucunCombatProgramme();
    }

    public void listerCombatDresseur(Dresseur dresseur){
        Iterator<Combat> i=combats_programmes.iterator();
        Logger l = Logger.getLogger("Log_ListeCombatDresseur");
        while (i.hasNext()) {
            Combat suivant=i.next();
            if(suivant.getDresseur1()==dresseur||suivant.getDresseur2()==dresseur) {
                l.info(suivant.toString());
            }
        }
    }
}
