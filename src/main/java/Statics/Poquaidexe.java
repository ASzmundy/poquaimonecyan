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
        temp_att = new Attaque("Pioche en pierre","oof");
        poquaidexe.put(10,new Poquaimone(10,"Minestive","Roche","un personnage d’un célèbre jeu vidéo",true,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque()),11,9));
        temp_att = new Attaque("Pioche en acier","NEIN");
        poquaidexe.put(11,new Poquaimone(11,"Minekraft","Combat","un personnage d’un célèbre jeu vidéo avec une moustache et un certain accent",false,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque())));
        temp_att = new Attaque("Sursaut nul","bouh");
        poquaidexe.put(12,new Poquaimone(12,"Spookelette","Spectre","un squelette fantôme",true,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque()),12,8));
        temp_att = new Attaque("AAAA UN FANTOME","BOUHAHAHAHA");
        poquaidexe.put(13,new Poquaimone(13,"Spooktergeist","Spectre","un crâne géant pas content",false,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque())));
        temp_att = new Attaque("Écope","KOUIIIIYEEEERE");
        poquaidexe.put(14,new Poquaimone(14,"Kouiyère","Inox","une cuillère qui parle",true,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque()),14,6));
        temp_att = new Attaque("Pique","ARTOURRRR");
        poquaidexe.put(15,new Poquaimone(15,"Fourshet","Inox","une fourchette qui parle",true,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque())));
        temp_att = new Attaque("Sortez couverts","INTEEERRRRPLAAATE");
        poquaidexe.put(16,new Poquaimone(16,"Interplate","Porcelaine","une assiette qui parle",false,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque())));
        temp_att = new Attaque("Câlin de patate","Patapatate :3");
        poquaidexe.put(17,new Poquaimone(17,"Patate","Purée","une patate trop mignone",true,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque()),14,6));
        temp_att = new Attaque("Écrasement de tubercules","SPROUTCH");
        poquaidexe.put(18,new Poquaimone(18,"Mousselinex","Purée/Sol","de la purée en flocons",false,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque())));
        temp_att = new Attaque("Rire énervant","ISSOUHAHAHAHAHA");
        poquaidexe.put(19,new Poquaimone(19,"Issoule","Ténèbres","un homme en surpoids avec des dents en moins",true,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque()),12,8));
        temp_att = new Attaque("Suicide par tongs dans le dos","C'est lashankla");
        poquaidexe.put(20,new Poquaimone(20,"Lashankla","Ténèbres","un homme obèse lançant des tongs",true,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque())));
        temp_att = new Attaque("Purification par l'atome","AAAAAAAAHAHAHAHA BOOOOOM");
        poquaidexe.put(21,new Poquaimone(21,"Yatangakill","Ténèbres","un homme frêle portant une bombe atomique",false,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque())));
        temp_att = new Attaque("Amuse-bouche","Mmm ça à l’air bon !");
        poquaidexe.put(22,new Poquaimone(22,"Entretard","Fée","un petit plat",true,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque()),13,7));
        temp_att = new Attaque("Plein la panse","Miam c’était délicieux !");
        poquaidexe.put(23,new Poquaimone(23,"Plalavance","Fée","un bon gros repas",true,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque())));
        temp_att = new Attaque("Un dernier pour la route","J’en peux plus…");
        poquaidexe.put(24,new Poquaimone(24,"Desserto","Fée","un joli dessert",false,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque())));
        temp_att = new Attaque("90kg sur 300m","GRAOOOU SHLONCK");
        poquaidexe.put(25,new Poquaimone(25,"Dinobuchet","Dinosaure","un Tyrannosaure avec un trébuchet sur le dos",false,
                new Attaque(temp_att.getNom_attaque(),temp_att.getCri_attaque()),150,75));
    }
}
