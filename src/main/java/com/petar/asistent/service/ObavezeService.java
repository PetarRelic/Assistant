package com.petar.asistent.service;

import com.petar.asistent.dao.EntityManagerWrapper;
import com.petar.asistent.dao.ObavezeDao;
import com.petar.asistent.data.Obaveze;
import com.petar.asistent.exception.AsistentException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class ObavezeService {

    public static final ObavezeService instance = new ObavezeService();

    public ObavezeService() {
    }

    public static ObavezeService getInstance() {
        return instance;
    }
    
    public List<Obaveze> findAll(){
        EntityManager em = EntityManagerWrapper.createEntityManager();
        try{
            return ObavezeDao.getInstance().findAll(em);
        }finally{
            em.close();
        }
    }
    
    private void validate(Obaveze obaveze) throws AsistentException {
        
        List<String> errors = new ArrayList<>();

        if (obaveze.getNazivObaveze()== null || obaveze.getNazivObaveze().trim().isEmpty()) {
            errors.add("Parametar naziv obaveze je obavezan.");
        } else if (obaveze.getNazivObaveze().length() > 45) {
            errors.add("Parametar naziv obaveze ne sme biti duzi od 45 karaktera");
        }

        if (obaveze.getDatumObaveze()== null || obaveze.getDatumObaveze().trim().isEmpty()) {
            errors.add("Parametar datum obaveze je obavezan.");
        }else if (obaveze.getDatumObaveze().length() > 45) {
            errors.add("Parametar datum obaveze ne sme biti duzi od 45 karaktera");
        }
        
        if (obaveze.getVremeObaveze()== null || obaveze.getVremeObaveze().trim().isEmpty()) {
            errors.add("Parametar vreme obaveze je obavezan.");
        }else if (obaveze.getVremeObaveze().length() > 45) {
            errors.add("Parametar vreme obaveze ne sme biti duzi od 45 karaktera");
        }
        
        if (!errors.isEmpty()) {
            throw new AsistentException(errors);
        }
    }
    
    public void add(Obaveze obaveze) throws AsistentException{
        
        validate(obaveze);
        
        EntityManager em = EntityManagerWrapper.createEntityManager();
        
        try{
            em.getTransaction().begin();
            ObavezeDao.getInstance().add(em, obaveze);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    public void edit(Obaveze obaveze) throws AsistentException{
        
        validate(obaveze);
        
        EntityManager em = EntityManagerWrapper.createEntityManager();
        
        try{
            em.getTransaction().begin();
            ObavezeDao.getInstance().edit(em, obaveze);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    public void delete(Obaveze obaveze) throws AsistentException{
        
        if (obaveze.getIdObaveze()== null) {
            throw new AsistentException("Nepoznat ID obaveze.");
        }
        
        EntityManager em = EntityManagerWrapper.createEntityManager();
        
        try{
            em.getTransaction().begin();
            ObavezeDao.getInstance().delete(em, obaveze);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
}
