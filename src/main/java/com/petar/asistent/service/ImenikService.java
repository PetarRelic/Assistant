package com.petar.asistent.service;

import com.petar.asistent.dao.EntityManagerWrapper;
import com.petar.asistent.dao.ImenikDao;
import com.petar.asistent.data.Imenik;
import com.petar.asistent.exception.AsistentException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class ImenikService {

    public static final ImenikService instance = new ImenikService();

    public ImenikService() {
    }

    public static ImenikService getInstance() {
        return instance;
    }
    
    public List<Imenik> findAll(){
        EntityManager em = EntityManagerWrapper.createEntityManager();
        try{
            return ImenikDao.getInstance().findAll(em);
        }finally{
            em.close();
        }
    }
    
    private void validate(Imenik imenik) throws AsistentException {
        
        List<String> errors = new ArrayList<>();

        if (imenik.getImePrezime()== null || imenik.getImePrezime().trim().isEmpty()) {
            errors.add("Parametar ime i prezime je obavezan.");
        } else if (imenik.getImePrezime().length() > 45) {
            errors.add("Parametar ime i prezime ne sme biti duzi od 45 karaktera");
        }

        if (imenik.getBrojTelefona()== null) {
            errors.add("Parametar broj telefona je obavezan.");
        }
        
        if (!errors.isEmpty()) {
            throw new AsistentException(errors);
        }
    }
    
    public void add(Imenik imenik) throws AsistentException{
        
        validate(imenik);
        
        EntityManager em = EntityManagerWrapper.createEntityManager();
        
        try{
            em.getTransaction().begin();
            ImenikDao.getInstance().add(em, imenik);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    public void edit(Imenik imenik) throws AsistentException{
        
        validate(imenik);
        
        EntityManager em = EntityManagerWrapper.createEntityManager();
        
        try{
            em.getTransaction().begin();
            ImenikDao.getInstance().edit(em, imenik);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    public void delete(Imenik imenik) throws AsistentException{
        
        if (imenik.getIdImenik()== null) {
            throw new AsistentException("Nepoznat ID imenika.");
        }
        
        EntityManager em = EntityManagerWrapper.createEntityManager();
        
        try{
            em.getTransaction().begin();
            ImenikDao.getInstance().delete(em, imenik);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
}
