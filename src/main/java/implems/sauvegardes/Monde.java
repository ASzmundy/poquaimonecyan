package implems.sauvegardes;

import implems.listes.Liste_Arbitres;
import implems.listes.Liste_Combats;
import implems.listes.Liste_Dresseurs;
import implems.listes.Liste_Humains;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Monde implements Serializable {
    private Liste_Combats liste_combats;
    private Liste_Dresseurs liste_dresseurs;
    private Liste_Arbitres liste_arbitres;
    private Liste_Humains liste_humains;


    public Monde(Liste_Combats lc, Liste_Dresseurs ld) {
        this.liste_combats=lc;
        this.liste_dresseurs=ld;
    }

    public Liste_Combats getListe_combats() {
        return liste_combats;
    }

    public Liste_Dresseurs getListe_dresseurs() {
        return liste_dresseurs;
    }

    public Liste_Arbitres getListe_arbitres() {
        return liste_arbitres;
    }

    public Liste_Humains getListe_humains() {
        return liste_humains;
    }

    public void sauvegarderMonde(String nomdumonde){
        nomdumonde+=".pwsf";//.pwsf = Poquaimone World Save File
        File f = new File(nomdumonde);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Monde chargerMonde(String nomdumonde){
        nomdumonde+=".pwsf";
        File f = new File(nomdumonde);
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Monde charge;
            charge = (Monde)ois.readObject();
            return charge;
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
