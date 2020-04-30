package implems.poquai;

import implems.combat.Attaque;
import implems.uniques.Poquaidexe;

import java.io.Serializable;

public class Poquaimone implements Serializable {
    private String nom,type,description;
    private boolean evoluable;
    private int pv,pa,id_dex;
    private Attaque[] attaques;
    private Poquaidexe poquaidexe;

    public Poquaimone(){
        this.id_dex=0;
        this.type="Erreur";
        this.nom="Missingniet";
        this.description="une bouillie de pixels";
        this.evoluable=false;
        this.pv=1;
        this.pa=1;
    }

    public Poquaimone(int id_dex,String nom,String type, String description,boolean evoluable,Attaque attaque, int pv, int pa){ //pour un poque de base dans le dex
        this.id_dex=id_dex;
        this.type=type;
        this.nom=nom;
        this.description=description;
        this.evoluable=evoluable;
        this.pv=pv;
        this.pa=pa;
        this.attaques=new Attaque[3];
        this.attaques[0] = attaque;
    }

    public Poquaimone(int id_dex,String nom,String type, String description,boolean evoluable,Attaque attaque){ //pour une évolution dans le dex
        this.id_dex=id_dex;
        this.type=type;
        this.nom=nom;
        this.description=description;
        this.evoluable=evoluable;
        this.attaques=new Attaque[3];
        this.attaques[0] = attaque;
    }
    public Poquaimone(int id_dex,String nom,String type, String description,boolean evoluable,Attaque[] attaques, int pv, int pa, Poquaidexe px){ //pour instancier un poque
        this.id_dex=id_dex;
        this.type=type;
        this.nom=nom;
        this.description=description;
        this.evoluable=evoluable;
        this.pv=pv;
        this.pa=pa;
        this.attaques = new Attaque[3];
        this.attaques = attaques.clone();
        this.poquaidexe=px;
    }

    public int getId() {
        return id_dex;
    }

    public String getDescription() {
        return description;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = Math.max(pv, 1); //plafond à 1pv
    }

    public int getPa() {
        return pa;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public boolean isEvoluable() {
        return evoluable;
    }

    public Attaque[] getAttaques() {
        return attaques;
    }

    public Poquaidexe getPoquaidexe() {
        return poquaidexe;
    }

    @Override
    public String toString() {
        return " id_dex=" + id_dex +
                " nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                ", pv=" + pv +
                ", pa=" + pa
                ;
    }
}
