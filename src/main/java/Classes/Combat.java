package Classes;

import Exceptions.ExceptionPasDArbitre;
import Exceptions.ExceptionPasDeDresseur;
import Exceptions.ExceptionPasDePoque;
import Statics.Liste_Combats;
import Statics.Poquaidexe;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

public class Combat {
    private Dresseur dresseur1,dresseur2;
    private Arbitre arbitre;
    private Dresseur vainqueur,perdant;
    private Set<Humain> spectateurs;

    public Combat(Dresseur dresseur1,Dresseur dresseur2, Arbitre arbitre){
        this.dresseur1=dresseur1;
        this.dresseur2=dresseur2;
        this.arbitre=arbitre;
        this.spectateurs=new HashSet<>();
        Liste_Combats.ajouterCombat(this);
    }

    public void setDresseur1(Dresseur dresseur1) {
        this.dresseur1 = dresseur1;
    }

    public void setDresseur2(Dresseur dresseur2) {
        this.dresseur2 = dresseur2;
    }

    public void setArbitre(Arbitre arbitre) {
        this.arbitre = arbitre;
    }

    public Dresseur getDresseur1() {
        return dresseur1;
    }

    public Dresseur getDresseur2() {
        return dresseur2;
    }

    public Arbitre getArbitre() {
        return arbitre;
    }

    public Dresseur getVainqueur() {
        return vainqueur;
    }

    public Dresseur getPerdant() {
        return perdant;
    }

    public void addSpectateur(Humain nouveau){
        this.spectateurs.add(nouveau);
    }

    @Override
    public String toString() {
        return dresseur1.getPrenom()+" "+dresseur1.getNom()+" VS "+dresseur2.getPrenom()+" "+dresseur2.getNom();
    }

    public void commencerCombat() throws ExceptionPasDeDresseur, ExceptionPasDArbitre, ExceptionPasDePoque {
        if(this.dresseur1!=null&&this.dresseur2!=null){
            if(arbitre!=null){
                if(dresseur1.getEquipe().get(0)!=null&&dresseur2.getEquipe().get(0)!=null){
                    Random random = new Random();
                    int num_poque1 = random.nextInt(dresseur1.getEquipe().size()); // selectionne la place du premier poquemone choisi au hasard
                    int num_poque2 = random.nextInt(dresseur2.getEquipe().size()); // selectionne la place du second poquemone choisi au hasard
                    Poquaimone poque1 = dresseur1.getEquipe().get(num_poque1);
                    Poquaimone poque2 = dresseur2.getEquipe().get(num_poque2);
                    Logger l = Logger.getLogger("Log_combat");
                    for (Humain spectateur : spectateurs) {
                        l.info(spectateur.getNom() + " encourage son ami !");
                    }
                    l.info(dresseur1.getNom() + " envoie " + poque1.getNom() + " ! Il ressemble à " + poque1.getDescription() + " et est de type " + poque1.getType() + " !");
                    l.info(dresseur2.getNom() + " envoie " + poque2.getNom() + " ! Il ressemble à " + poque2.getDescription() + " et est de type " + poque2.getType() + " !");
                    int i = 0;
                    while (poque1.getAttaques()[i] != null && i <= 2) {
                        l.info(poque1.getNom() + " utilise " + poque1.getAttaques()[i].getNom_attaque());
                        l.info(poque1.getAttaques()[i].getCri_attaque());
                        i++;
                    }
                    i = 0;
                    while (poque1.getAttaques()[i] != null && i <= 2) {
                        l.info(poque2.getNom() + " utilise " + poque2.getAttaques()[i].getNom_attaque());
                        l.info(poque2.getAttaques()[i].getCri_attaque());
                        i++;
                    }
                    if (poque1.getPa() > poque2.getPv()) {
                        vainqueur = dresseur1;
                        perdant = dresseur2;
                    } else if (poque2.getPa() > poque1.getPv()) {
                        vainqueur = dresseur2;
                        perdant = dresseur1;
                    } else {
                        int diff_pa = poque1.getPa() - poque2.getPa();
                        int D100 = 1 + random.nextInt(99);

                        if (poque1.getPa() == poque2.getPa()) { //poque1 a 50% de chance de gagner
                            if (D100 >= 50) {
                                vainqueur = dresseur2;
                                perdant = dresseur1;
                            } else {
                                vainqueur = dresseur1;
                                perdant = dresseur2;
                            }
                        } else if (poque1.getPa() > poque2.getPa()) {
                            if (D100 >= diff_pa + 50) {
                                vainqueur = dresseur2;
                                perdant = dresseur1;
                            } else {
                                vainqueur = dresseur1;
                                perdant = dresseur2;
                            }
                        } else {
                            if (D100 >= -diff_pa - 50) {
                                vainqueur = dresseur2;
                                perdant = dresseur1;
                            } else {
                                vainqueur = dresseur1;
                                perdant = dresseur2;
                            }
                        }
                    }
                    //fin du combat
                    if (vainqueur == dresseur1) {
                        l.info("Le vainqueur est " + vainqueur.getNom() + " avec " + poque1.getNom() + " !");
                        poque1.setPv(poque1.getPv() + 3);
                        poque2.setPv(poque2.getPv() - 3);
                        if (poque1.isEvoluable()) {
                            if (Poquaidexe.poquaidexe.get(poque1.getId() + 1).isEvoluable()) {
                                if (poque1.getPv() >= 50) vainqueur.evoluer(num_poque1);
                            } else {
                                if (poque1.getPv() >= 100) vainqueur.evoluer(num_poque1);
                            }
                        }
                    } else {
                        l.info("Le vainqueur est " + vainqueur.getNom() + " avec " + poque2.getNom() + " !");
                        poque2.setPv(poque2.getPv() + 3);
                        poque1.setPv(poque1.getPv() - 3);
                        if (poque2.isEvoluable()) {
                            if (Poquaidexe.poquaidexe.get(poque2.getId() + 1).isEvoluable()) {
                                if (poque2.getPv() >= 50) vainqueur.evoluer(num_poque2);
                            } else {
                                if (poque2.getPv() >= 100) vainqueur.evoluer(num_poque2);
                            }
                        }
                    }
                    vainqueur.incrementNb_victoire();
                    perdant.incrementNb_defaite();
                    arbitre.IncrementNb_combat_arbitres();
                    Liste_Combats.combatTermine();
                }else throw new ExceptionPasDePoque();
            }else throw new ExceptionPasDArbitre();
        }else throw new ExceptionPasDeDresseur();
    }
}
