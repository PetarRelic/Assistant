package com.petar.asistent.service;

import com.petar.asistent.dao.EntityManagerWrapper;
import com.petar.asistent.dao.KorisnikDao;
import com.petar.asistent.data.Korisnik;
import com.petar.asistent.exception.AsistentException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class KorisnikService {

    public static final KorisnikService instance = new KorisnikService();

    public KorisnikService() {
    }

    public static KorisnikService getInstance() {
        return instance;
    }
    
    public List<Korisnik> findAll(){
        EntityManager em = EntityManagerWrapper.createEntityManager();
        try{
            return KorisnikDao.getInstance().findAll(em);
        }finally{
            em.close();
        }
    }
    
    private void validate(Korisnik korisnik) throws AsistentException {
        
        List<String> errors = new ArrayList<>();

        if (korisnik.getKorisnicko_ime()== null || korisnik.getKorisnicko_ime().trim().isEmpty()) {
            errors.add("Parametar korisnicko ime je obavezan.");
        } else if (korisnik.getKorisnicko_ime().length() > 45) {
            errors.add("Parametar korisnicko ime ne sme biti duzi od 45 karaktera");
        }

        if (korisnik.getLozinka() == null || korisnik.getLozinka().trim().isEmpty()) {
            errors.add("Parametar lozinka je obavezan.");
        } else if (korisnik.getLozinka().length() > 45) {
            errors.add("Parametar lozinka ne sme biti duzi od 45 karaktera");
        }

        
        if (!errors.isEmpty()) {
            throw new AsistentException(errors);
        }
    }
    
    public void add(Korisnik korisnik) throws AsistentException{
        
        validate(korisnik);
        
        EntityManager em = EntityManagerWrapper.createEntityManager();
        
        try{
            em.getTransaction().begin();
            KorisnikDao.getInstance().add(em, korisnik);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    public void edit(Korisnik korisnik) throws AsistentException{
        
        validate(korisnik);
        
        EntityManager em = EntityManagerWrapper.createEntityManager();
        
        try{
            em.getTransaction().begin();
            KorisnikDao.getInstance().edit(em, korisnik);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    public void delete(Korisnik korisnik) throws AsistentException{
        
        if (korisnik.getIdKorisnik()== null) {
            throw new AsistentException("Nepoznat ID korisnika.");
        }
        
        EntityManager em = EntityManagerWrapper.createEntityManager();
        
        try{
            em.getTransaction().begin();
            KorisnikDao.getInstance().delete(em, korisnik);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
}
