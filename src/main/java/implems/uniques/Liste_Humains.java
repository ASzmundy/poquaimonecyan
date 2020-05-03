package implems.uniques;

import implems.humains.Humain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Liste_Humains {
    private Set<Humain> liste_humains= new HashSet<>();

    public Set<Humain> getListe_humains() {
        return liste_humains;
    }

    public void ajouterHumain(Humain a_ajouter) {
        liste_humains.add(a_ajouter);
    }

    public Humain getHumain(String nom, String prenom){
        Iterator<Humain> i = this.liste_humains.iterator();
        while (i.hasNext()){
            Humain a = i.next();
            if(a.getNom().equals(nom)&&a.getPrenom().equals(prenom)){
                return a;
            }
        }
        return null;
    }
}
