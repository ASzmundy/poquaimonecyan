package implems.humains;

import exceptions.humains.ExceptionAmiNonTrouve;
import exceptions.combat.ExceptionCombatNonTrouve;
import implems.uniques.Liste_Dresseurs;
import implems.uniques.Poquaidexe;
import implems.poquai.Poquaimone;
import implems.combat.Attaque;
import implems.combat.Combat;
import interfaces.combat.Peut_Inviter;


import java.io.Serializable;
import java.util.ArrayList;

public class Dresseur extends Humain implements Peut_Inviter, Serializable {
    private Integer nb_victoire, nb_defaite;
    private ArrayList<Poquaimone> equipe = new ArrayList<>();

    public Dresseur() {
        super();
        nb_victoire = 0;
        nb_defaite = 0;
    }

    public Dresseur(Liste_Dresseurs ld) {
        super();
        nb_victoire = 0;
        nb_defaite = 0;
        ld.ajouterDresseur(this);
    }

    public Dresseur(String nom, String prenom, Liste_Dresseurs ld) {
        super(nom, prenom);
        nb_victoire = 0;
        nb_defaite = 0;
        ld.ajouterDresseur(this);
    }

    public ArrayList<Poquaimone> getEquipe() {
        return equipe;
    }

    public void setEquipe(ArrayList<Poquaimone> equipe) {
        this.equipe = equipe;
    }

    public Integer getNb_defaite() {
        return nb_defaite;
    }

    public Integer getNb_victoire() {
        return nb_victoire;
    }

    public void incrementNb_victoire() {
        this.nb_victoire++;
    }

    public void incrementNb_defaite() {
        this.nb_defaite++;
    }

    public void ajouterPoquaimone(int id_poque, Poquaidexe px) {
        if (px.poquaidexe.get(1) == null) {
            px = new Poquaidexe();
        }
        if (id_poque != 1) {
            while (px.poquaidexe.get(id_poque - 1).isEvoluable() && id_poque > 2) {
                id_poque--; //permet de prendre le poque de base si l'id d'une évolution est entrée en paramètre
            }
        }
        Poquaimone p = new Poquaimone(
                id_poque, px.poquaidexe.get(id_poque).getNom(), px.poquaidexe.get(id_poque).getType(), px.poquaidexe.get(id_poque).getDescription(),
                px.poquaidexe.get(id_poque).isEvoluable(), px.poquaidexe.get(id_poque).getAttaques(), px.poquaidexe.get(id_poque).getPv(),
                px.poquaidexe.get(id_poque).getPa(),px
        );
        this.equipe.add(p);
    }

    @Override
    public String toString() {
        return "Nom :" + this.getNom() + " Prénom :" + this.getPrenom() + " Nombre de victoires :" + this.getNb_victoire() + "\n";
    }

    @Override
    public void inviterAmi(Humain ami, Combat combat) throws ExceptionAmiNonTrouve, ExceptionCombatNonTrouve {
        if (combat != null && (combat.getDresseur1() == this || combat.getDresseur2() == this)) {
            if (this.amis.contains(ami)) {
                combat.addSpectateur(ami);
            } else throw new ExceptionAmiNonTrouve();
        } else throw new ExceptionCombatNonTrouve();
    }

    public void evoluer(int place_poquai) {
        Poquaimone ancien = this.equipe.get(place_poquai);
        if (ancien != null) { //sécurité si le poquaimone existe bien dans l'équipe
            if (ancien.isEvoluable()) { //sécurité pour voir si il a bien une évolution
                Poquaidexe px = ancien.getPoquaidexe();
                if ((px.poquaidexe.get(ancien.getId() + 1).isEvoluable() && this.equipe.get(place_poquai).getPv() >= 50) ||
                        (!(px.poquaidexe.get(ancien.getId() + 1).isEvoluable()) && ancien.getPv() >= 100)) {
                        //si le poquaimone est de base, il a besoin de 50pv pour évoluer, si c'est une évolution évoluable il a besoin de 100
                    int nouveau_id = ancien.getId() + 1;
                    if (px.poquaidexe.get(nouveau_id) != null) { //si son évolution existe dans le poquaidexe
                        String nouveau_nom = px.poquaidexe.get(nouveau_id).getNom();
                        String nouveau_type = px.poquaidexe.get(nouveau_id).getType();
                        String nouvelle_desc = px.poquaidexe.get(nouveau_id).getDescription();
                        boolean evoluable = px.poquaidexe.get(nouveau_id).isEvoluable();
                        Attaque[] nouveau_attaques = new Attaque[3];
                        Attaque nouvelle_attaque = px.poquaidexe.get(nouveau_id).getAttaques()[0];
                        int i = 0;
                        while (ancien.getAttaques()[i] != null) {
                            nouveau_attaques[i] = ancien.getAttaques()[i];
                            i++;
                        }
                        nouveau_attaques[i] = nouvelle_attaque;
                        Poquaimone nouveau = new Poquaimone(nouveau_id, nouveau_nom, nouveau_type, nouvelle_desc,
                                evoluable, nouveau_attaques, ancien.getPv(), ancien.getPa() + 20, px);
                        this.equipe.remove(place_poquai);
                        this.equipe.add(place_poquai, nouveau);
                    }
                }
            }
        }
    }
}
