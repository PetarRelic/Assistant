package com.petar.asistent.dao;

import com.petar.asistent.data.Korisnik;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class KorisnikDao {


    private static KorisnikDao instance = new KorisnikDao();

    public KorisnikDao() {
    }

    public static KorisnikDao getInstance() {
        return instance;
    }
    
    public List<Korisnik> findAll(EntityManager em){
        TypedQuery<Korisnik> query = em.createQuery("Select c From Korisnik c",Korisnik.class);
        return query.getResultList();
    }
    
    public void add(EntityManager em, Korisnik korisnik){
        em.persist(korisnik);
    }
    
    public void edit(EntityManager em, Korisnik korisnik){
        em.merge(korisnik);
    }
    
    public void delete(EntityManager em,Korisnik korisnik){
        Korisnik managedKorisnik = em.merge(korisnik);
        em.remove(managedKorisnik);
    }
    
    
}
