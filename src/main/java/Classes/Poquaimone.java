package Classes;

import java.io.Serializable;
import java.util.Arrays;

public class Poquaimone implements Serializable {
    private String nom,type,description;
    private boolean evoluable;
    private int pv,pa,id_dex;
    private Attaque[] attaques;

    public Poquaimone(){
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
    public Poquaimone(int id_dex,String nom,String type, String description,boolean evoluable,Attaque[] attaques, int pv, int pa){ //pour instancier un poque
        this.id_dex=id_dex;
        this.type=type;
        this.nom=nom;
        this.description=description;
        this.evoluable=evoluable;
        this.pv=pv;
        this.pa=pa;
        this.attaques = attaques;
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
        if(pv>=1) this.pv = pv; //plafond à 1pv
        else this.pv=1;
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

    @Override
    public String toString() {
        return "Poquaimone{" +
                ", id_dex=" + id_dex +
                "nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                ", pv=" + pv +
                ", pa=" + pa +
                '}';
    }
}
