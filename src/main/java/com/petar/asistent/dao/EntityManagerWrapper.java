package com.petar.asistent.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerWrapper {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("AsistentPU");
    
    public static EntityManager createEntityManager(){
        return emf.createEntityManager();
    }
    
}
