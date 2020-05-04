package implems.humains;

import exceptions.humains.ExceptionAmiNonTrouve;
import exceptions.combat.ExceptionCombatNonTrouve;
import implems.combat.Combat;
import implems.listes.Liste_Arbitres;
import interfaces.combat.Peut_Inviter;

public class Arbitre extends Humain implements Peut_Inviter {
    private int nb_combats_arbitres;

    public Arbitre() {
        super();
        nb_combats_arbitres = 0;
    }

    public Arbitre(String nom, String prenom) {
        super(nom, prenom);
        nb_combats_arbitres = 0;
    }

    public Arbitre(String nom, String prenom, Liste_Arbitres la) {
        super(nom, prenom);
        nb_combats_arbitres = 0;
        la.ajouterArbitre(this);
    }

    public int getNb_combats_arbitres() {
        return nb_combats_arbitres;
    }

    public void IncrementNb_combat_arbitres() {
        this.nb_combats_arbitres++;
    }

    @Override
    public void inviterAmi(Humain ami, Combat combat) throws ExceptionAmiNonTrouve, ExceptionCombatNonTrouve {
        if(combat!=null&&combat.getArbitre()==this) {
            if (this.amis.contains(ami)) {
                combat.addSpectateur(ami);
            } else throw new ExceptionAmiNonTrouve();
        }else throw new ExceptionCombatNonTrouve();
    }
}
