package implems;

import exceptions.poquai.ExceptionPoquaiIntrouvable;
import implems.humains.Dresseur;
import implems.uniques.Liste_Dresseurs;
import implems.uniques.Poquaidexe;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class FichiertxtTest {


    @Test
    public void LecturePoquaimoneTest(){
        File f = new File("test.txt");
        Liste_Dresseurs ld = new Liste_Dresseurs();
        Poquaidexe p = new Poquaidexe();
        Dresseur d1 = new Dresseur("Testman","Test",ld);
        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String chaine_lue;
            chaine_lue = br.readLine();
            int id_charge = Integer.parseInt(chaine_lue);
            d1.ajouterPoquaimone(id_charge,p);
            br.close();
        } catch (IOException | ExceptionPoquaiIntrouvable e){
            e.printStackTrace();
        }
        assertNotNull("Erreur de chargement: Le poquaimone n'a pas été rajouté à l'équipe",d1.getEquipe().get(0));
        ld.afficherDresseursTrie();
    }


    @Test
    public void LectureTest(){

    }
}
