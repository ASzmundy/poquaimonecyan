package entry_point;

import exceptions.combat.ExceptionAucunCombatProgramme;
import exceptions.combat.ExceptionDresseursIdentiques;
import exceptions.poquai.ExceptionPoquaiIntrouvable;
import implems.humains.Arbitre;
import implems.humains.Dresseur;
import implems.humains.Humain;
import implems.sauvegardes.Monde;
import implems.uniques.Liste_Arbitres;
import implems.uniques.Liste_Combats;
import implems.uniques.Liste_Dresseurs;
import implems.uniques.Liste_Humains;

import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger l = Logger.getLogger("main");
        int choix = -1;
        Liste_Dresseurs ld = new Liste_Dresseurs();
        Liste_Combats lc = new Liste_Combats();
        Dresseur d; Scanner s = new Scanner(System.in);
        Liste_Humains lh = new Liste_Humains();
        Liste_Arbitres la = new Liste_Arbitres();
        String nom,prenom,nommonde;
        Monde m;


        while (choix != 0) {
            l.info("\n1: Ajouter un dresseur\n" +
                    "2: Ajouter un poquaimone à un dresseur\n" +
                    "3: Ajouter un humain\n"+
                    "4: Ajouter un arbitre\n"+
                    "5: Organiser un combat\n" +
                    "6: Afficher tout les dresseurs par combats gagnés\n" +
                    "7: Afficher tout les combats prévus\n" +
                    "8: Afficher tout les combats d'un dresseur\n" +
                    "9: Lancer un combat\n" +
                    "10: Sauvegarder\n"+
                    "11: Charger\n"+
                    "0: Quitter");
            choix = s.nextInt();
            switch (choix){
                case 1:
                    l.info("Entrez le nom du dresseur :");
                    nom=s.next();
                    l.info("Entrez le prénom du dresseur :");
                    prenom=s.next();
                    new Dresseur(nom,prenom,ld);
                    break;

                case 2:
                    int num_poquai; Dresseur ajoutpd;
                    Iterator<Dresseur> i = ld.liste_dresseurs.iterator();
                    l.info("Entrez le nom puis le prénom du dresseur :");
                    nom=s.next();
                    prenom=s.next();
                    ajoutpd=ld.getDresseur(nom,prenom);
                    if(ajoutpd==null){
                        l.warning("Dresseur introuvable");
                        break;
                    }
                    l.info("Entrez l'ID Poquaidexe du poquaimone à ajouter :");
                    num_poquai=s.nextInt();
                    try {
                        ajoutpd.ajouterPoquaimone(num_poquai);
                    }catch (ExceptionPoquaiIntrouvable e){
                        l.severe("Poquaimone introuvable dans le poquaidexe !");
                        break;
                    }
                    break;

                case 3:
                    l.info("Entrez le nom :");
                    nom=s.next();
                    l.info("Entrez le prénom :");
                    prenom=s.next();
                    Humain h= new Humain(nom,prenom,lh);
                    break;

                case 4:
                    l.info("Entrez le nom de l'arbitre :");
                    nom=s.next();
                    l.info("Entrez le prénom de l'arbitre:");
                    prenom=s.next();
                    Arbitre a=new Arbitre(nom,prenom,la);
                    la.ajouterArbitre(a);
                    break;

                case 5:
                    Dresseur d1,d2;
                    l.info("Entrez le nom du dresseur 1 :");
                    nom=s.next();
                    l.info("Entrez le prénom du dresseur 1:");
                    prenom=s.next();
                    d1=ld.getDresseur(nom,prenom);
                    if(d1==null){
                        l.warning("Dresseur introuvable");
                        break;
                    }
                    l.info("Entrez le nom du dresseur 2 :");
                    nom=s.next();
                    l.info("Entrez le prénom du dresseur 2:");
                    prenom=s.next();
                    d2=ld.getDresseur(nom,prenom);
                    if(d2==null){
                        l.warning("Dresseur introuvable");
                        break;
                    }
                    l.info("Entrez le nom de l'arbitre :");
                    nom=s.next();
                    l.info("Entrez le prénom de l'arbitre:");
                    prenom=s.next();
                    a=la.getArbitre(nom,prenom);
                    if(a==null){
                        l.warning("Arbitre introuvable");
                        break;
                    }
                    try {
                        lc.organiserCombat(d1, d2, a);
                    }catch (ExceptionDresseursIdentiques e){
                        l.severe("Les dressseurs sont identiques !");
                        break;
                    }
                    break;

                case 6:
                    ld.afficherDresseursTrie();
                    break;

                case 7:
                    lc.afficherListe();
                    break;

                case 8:
                    l.info("Entrez le nom du dresseur :");
                    nom=s.next();
                    l.info("Entrez le prénom du dresseur :");
                    prenom=s.next();
                    d=ld.getDresseur(nom,prenom);
                    if(d==null){
                        l.warning("Dresseur introuvable");
                        break;
                    }
                    lc.listerCombatDresseur(d);
                    break;

                case 9:
                    try {
                        lc.lancerCombat();
                    }catch (ExceptionAucunCombatProgramme e){
                        l.warning("Aucun combat sur la liste !");
                        break;
                    }
                    break;

                case 10:
                    l.info("Entrez le nom du monde :");
                    nommonde = s.next();
                    m = new Monde(lc,ld);
                    m.sauvegarderMonde(nommonde);
                    break;

                case 11:
                    l.info("Entrez le nom du monde :");
                    nommonde = s.next();
                    m = Monde.chargerMonde(nommonde);
                    if(m!=null) {
                        lc = m.getListe_combats();
                        ld = m.getListe_dresseurs();
                    }else{
                        l.severe("Echec du chargement du monde");
                    }
                    break;
            }
        }
    }
}
