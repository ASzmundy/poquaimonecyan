package Classes;

import org.junit.Test;

import static org.junit.Assert.*;

public class DresseurTest {

    @Test
    public void testConstructDresseur() {
        Dresseur d = new Dresseur();
        assertNotNull("Le nom doit pas être vide",d.getNom());
        assertNotNull("Le prénom doit pas être vide",d.getPrenom());
    }

    @Test
    public void setEquipe() {
    }

    @Test
    public void getNb_defaite() {
    }

    @Test
    public void getNb_victoire() {
    }

    @Test
    public void incrementNb_victoire() {
    }

    @Test
    public void incrementNb_defaite() {
    }

    @Test
    public void inviterAmi() {
    }

    @Test
    public void evoluer() {
    }
}