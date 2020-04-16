package Classes;

import java.io.Serializable;

public class Attaque implements Serializable {
    String nom_attaque;
    String cri_attaque;

    public Attaque(){
    }

    public Attaque(String nom_attaque, String cri_attaque){
        this.nom_attaque=nom_attaque;
        this.cri_attaque=cri_attaque;
    }

    public String getCri_attaque() {
        return cri_attaque;
    }

    public String getNom_attaque() {
        return nom_attaque;
    }

    public void setCri_attaque(String cri_attaque) {
        this.cri_attaque = cri_attaque;
    }
}
