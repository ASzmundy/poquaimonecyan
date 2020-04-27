package Classes;

import Exceptions.ExceptionAmiNonTrouve;
import Exceptions.ExceptionCombatNonTrouve;
import Interfaces.Peut_Inviter;
import Statics.Poquaidexe;

import java.io.Serializable;
import java.util.ArrayList;

public class Dresseur extends Humain implements Peut_Inviter, Serializable {
    private int nb_victoire,nb_defaite;
    private ArrayList<Poquaimone> equipe;

    public Dresseur(){
        super();
        nb_victoire=0;
        nb_defaite=0;
        this.equipe=new ArrayList<>();
    }

    public Dresseur(String nom, String prenom){
        super(nom, prenom);
        nb_victoire=0;
        nb_defaite=0;
        this.equipe=new ArrayList<>();
    }

    public ArrayList<Poquaimone> getEquipe() {
        return equipe;
    }

    public void setEquipe(ArrayList<Poquaimone> equipe) {
        this.equipe = equipe;
    }

    public int getNb_defaite() {
        return nb_defaite;
    }

    public int getNb_victoire() {
        return nb_victoire;
    }

    public void incrementNb_victoire(){
        this.nb_victoire++;
    }

    public void incrementNb_defaite(){
        this.nb_defaite++;
    }

    public void ajouterPoquaimone(int id_poque){
        Poquaimone p = new Poquaimone(
                id_poque,Poquaidexe.poquaidexe.get(id_poque).getNom(),Poquaidexe.poquaidexe.get(id_poque).getType(),Poquaidexe.poquaidexe.get(id_poque).getDescription(),
                Poquaidexe.poquaidexe.get(id_poque).isEvoluable(),Poquaidexe.poquaidexe.get(id_poque).getAttaques(),Poquaidexe.poquaidexe.get(id_poque).getPv(),
                Poquaidexe.poquaidexe.get(id_poque).getPa()
        );
        this.equipe.add(p);
    }

    @Override
    public String toString() {
        return "Nom : "+this.getNom()+" Prénom : "+this.getPrenom();
    }

    @Override
    public void inviterAmi(Humain ami, Combat combat) throws ExceptionAmiNonTrouve,ExceptionCombatNonTrouve {
        if(combat!=null&&(combat.getDresseur1()==this||combat.getDresseur2()==this)) {
            if (this.amis.contains(ami)) {
                combat.addSpectateur(ami);
            } else throw new ExceptionAmiNonTrouve();
        }else throw new ExceptionCombatNonTrouve();
    }

    public void evoluer(int place_poquai) {
        if (this.equipe.get(place_poquai)!=null) { //sécurité si le poquaimone existe bien dans l'équipe
            if (this.equipe.get(place_poquai).isEvoluable()) { //sécurité pour voir si il a bien une évolution
                Poquaimone ancien = this.equipe.get(place_poquai);
                int nouveau_id = ancien.getId() + 1;

                if (Poquaidexe.poquaidexe.get(nouveau_id) != null) { //si son évolution existe dans le poquaidexe
                    String nouveau_nom = Poquaidexe.poquaidexe.get(nouveau_id).getNom();
                    String nouveau_type = Poquaidexe.poquaidexe.get(nouveau_id).getType();
                    String nouvelle_desc = Poquaidexe.poquaidexe.get(nouveau_id).getDescription();
                    boolean evoluable = Poquaidexe.poquaidexe.get(nouveau_id).isEvoluable();
                    Attaque[] nouveau_attaques = new Attaque[3];
                    Attaque nouvelle_attaque= Poquaidexe.poquaidexe.get(nouveau_id).getAttaques()[0];
                    int i=0;
                    while (ancien.getAttaques()[i]!=null){
                        nouveau_attaques[i]=ancien.getAttaques()[i];
                        i++;
                    }
                    nouveau_attaques[i]=nouvelle_attaque;
                    Poquaimone nouveau = new Poquaimone(nouveau_id,nouveau_nom,nouveau_type,nouvelle_desc,
                            evoluable,nouveau_attaques,ancien.getPv(),ancien.getPa()+20);
                    this.equipe.remove(place_poquai);
                    this.equipe.add(place_poquai,nouveau);
                }
            }
        }
    }
}
