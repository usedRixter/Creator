package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {
    private static EntityManager em = null;
    
    JPAUtil(){}
    
    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA2.0");
        em = emf.createEntityManager();
        return em;
    }
}