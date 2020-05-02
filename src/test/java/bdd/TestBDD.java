package bdd;

import implems.humains.Dresseur;
import implems.uniques.Liste_Dresseurs;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestBDD {

    @Test
    public void testAjout(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DresseursBDD");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Dresseur d = new Dresseur("Dupont","Jean",new Liste_Dresseurs());
        em.persist(d);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
