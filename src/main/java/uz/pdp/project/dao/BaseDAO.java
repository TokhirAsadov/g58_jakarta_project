package uz.pdp.project.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import uz.pdp.project.entity.Auditable;

import java.io.Serializable;

public abstract class BaseDAO <T extends Auditable, ID extends Serializable> {
    protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("g58");
    protected static final EntityManager em = emf.createEntityManager();

    protected void begin(){
        em.getTransaction().begin();
    }

    protected void commit(){
        em.getTransaction().commit();
    }
    protected void rollback(){
        em.getTransaction().rollback();
    }
}
