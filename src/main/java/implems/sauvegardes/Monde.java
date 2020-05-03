package implems.sauvegardes;

import implems.uniques.Liste_Combats;
import implems.uniques.Liste_Dresseurs;

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
