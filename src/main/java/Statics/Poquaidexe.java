package Statics;

import Classes.Poquaimone;
import Classes.Attaque;

import java.util.HashMap;

public class Poquaidexe {
    public static HashMap<Integer, Poquaimone> poquaidexe;

    public static void remplirPoquaidexe(){ // à utiliser au début du main
        Attaque temp_att;
        temp_att = new Attaque("Petit pincement","heeeeh");
        poquaidexe.put(1,new Poquaimone(1,"Tortitire","Eau","une petite tortue trop mimi",true,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque()),12,8));
        temp_att = new Attaque("Morsure douloureuse","Heeeeeeeeh");
        poquaidexe.put(2,new Poquaimone(2,"Koopatable","Eau","une grosse tortue avec un bavoir",true,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque())));
        temp_att = new Attaque("CHOMP","HOOOOOH");
        poquaidexe.put(3,new Poquaimone(3,"Degustortue","Eau","un peu comme Bowser mais tenant des couverts et un bavoir",false,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque())));
        temp_att = new Attaque("Brûlure au premier degré","coin");
        poquaidexe.put(4,new Poquaimone(4,"Briquaneton","Feu","un caneton avec une petite flamme au bout de la queue",true,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque()),9,11));
        temp_att = new Attaque("Magret de molotov","coincoin !");
        poquaidexe.put(5,new Poquaimone(5,"Jérricanne","Feu","un canard avec la tête en feu",true,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque())));
        temp_att = new Attaque("Méditation flambée","ooooooooooooooooooooo");
        poquaidexe.put(6,new Poquaimone(6,"Tibécoincoin","Feu/Psy","un canard entièrement en feu en pleine méditation",false,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque())));
        temp_att = new Attaque("Lancer de caillou","niklabak");
        poquaidexe.put(7,new Poquaimone(7,"Racayarbre","Plante","un petit homme-arbre en survêt",true,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque()),13,7));
        temp_att = new Attaque("Abordage naturel","YARRRR gros t'as pas une feuille ?");
        poquaidexe.put(8,new Poquaimone(8,"Hipirate","Feu","un hippie avec un cache-oeil",true,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque())));
        temp_att = new Attaque("Monsieur, Fraudons !","Je n'ai pas de compte en suisse.");
        poquaidexe.put(9,new Poquaimone(9,"Balkanuisson","Plante/Vol","un buisson avec la tête de Patrick Balkany",false,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque())));
    }
}
