package com.petar.asistent.dao;

import com.petar.asistent.data.Obaveze;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ObavezeDao {

    public static ObavezeDao instance = new ObavezeDao();

    public ObavezeDao() {
    }

    public static ObavezeDao getInstance() {
        return instance;
    }
    
    public List<Obaveze> findAll(EntityManager em){
        TypedQuery<Obaveze> query = em.createQuery("Select c From Obaveze c",Obaveze.class);
        return query.getResultList();
    }
    
    public void add(EntityManager em, Obaveze obaveze){
        em.persist(obaveze);
    }
    
    public void edit(EntityManager em , Obaveze obaveze){
        em.merge(obaveze);
    }
    
    public void delete(EntityManager em, Obaveze obaveze){
        Obaveze managedObaveze = em.merge(obaveze);
        em.remove(managedObaveze);
    }
    
}
