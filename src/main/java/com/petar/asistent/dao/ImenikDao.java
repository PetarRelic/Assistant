package com.petar.asistent.dao;

import com.petar.asistent.data.Imenik;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ImenikDao {

    private static ImenikDao instance = new ImenikDao();

    public ImenikDao() {
    }

    public static ImenikDao getInstance() {
        return instance;
    }
    
    public List<Imenik> findAll(EntityManager em){
        TypedQuery<Imenik> query = em.createQuery("Select c From Imenik c",Imenik.class);
        return query.getResultList();
    }
    
    public void add(EntityManager em, Imenik imenik){
        em.persist(imenik);
    }
    
    public void edit(EntityManager em, Imenik imenik){
        em.merge(imenik);
    }
    
    public void delete(EntityManager em,Imenik imenik){
        Imenik managedImenik = em.merge(imenik);
        em.remove(managedImenik);
    }
    
}
