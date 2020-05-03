package implems.uniques;

import implems.humains.Arbitre;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Liste_Arbitres {

    private Set<Arbitre> liste_arbitres= new HashSet<>();

    public Set<Arbitre> getListe_arbitres() {
        return liste_arbitres;
    }

    public void ajouterArbitre(Arbitre a_ajouter) {
        liste_arbitres.add(a_ajouter);
    }

    public Arbitre getArbitre(String nom, String prenom){
        Iterator<Arbitre> i = this.liste_arbitres.iterator();
        while (i.hasNext()){
            Arbitre a = i.next();
            if(a.getNom().equals(nom)&&a.getPrenom().equals(prenom)){
                return a;
            }
        }
        return null;
    }
}
