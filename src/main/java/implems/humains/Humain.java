package implems.humains;

import implems.listes.Liste_Humains;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Humain implements Serializable {
    private String nom,prenom;
    @Id
    private int id;
    @Transient
    protected Set<Humain> amis=new HashSet<>();

    public Humain(){
        nom="Inconnu";
        prenom="Inconnu";
        Set<Humain> amis = new HashSet<>();
    }

    public Humain(String nom, String prenom){
        this.nom=nom;
        this.prenom=prenom;
        Set<Humain> amis = new HashSet<>();
    }
    public Humain(String nom, String prenom, Liste_Humains lh){
        this.nom=nom;
        this.prenom=prenom;
        Set<Humain> amis = new HashSet<>();
        lh.ajouterHumain(this);
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void ajouterAmi(Humain nouvel_ami){
        amis.add(nouvel_ami);
    }
    public void retirerAmi(Humain a_retirer){
        amis.remove(a_retirer);
    }
}
