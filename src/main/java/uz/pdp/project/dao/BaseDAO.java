package uz.pdp.project.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.validation.constraints.NotNull;
import uz.pdp.project.entity.Auditable;
import uz.pdp.project.entity.User;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseDAO <T extends Auditable, ID extends Serializable> {
    protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("g58");
    protected static final EntityManager em = emf.createEntityManager();

    private final Class<T> persistenceClass;

    @SuppressWarnings("unchecked")
    protected BaseDAO() {
        this.persistenceClass = (Class<T>)
                (((ParameterizedType)getClass().getGenericSuperclass())
                .getActualTypeArguments()[0]);
    }

    protected void begin(){
        em.getTransaction().begin();
    }

    protected void commit(){
        em.getTransaction().commit();
    }

    protected void rollback(){
        em.getTransaction().rollback();
    }

    public T save(T entity){
        begin();
        em.persist(entity);
        commit();
        return entity;
    }

    public boolean update(T entity){
        begin();
        em.merge(entity);
        commit();
        return true;
    }

    public boolean deleteById(@NotNull ID id){
        begin();
        em.createQuery("delete from "+persistenceClass.getSimpleName()+" where id = :id")
                .setParameter("id", id)
                .executeUpdate();
        commit();
        return true;
    }

    public T findById(@NotNull ID id){
        begin();
        T user = em.find(persistenceClass, id);
        commit();
        return user;
    }

    public List<T> findAll(){
        begin();
        List<T> entities = em.createQuery("from "+persistenceClass.getSimpleName(),persistenceClass).getResultList();
        commit();
        return entities;
    }
}
