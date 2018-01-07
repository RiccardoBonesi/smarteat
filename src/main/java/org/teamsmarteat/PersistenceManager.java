package org.teamsmarteat;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Getting the EntityManagerFactory from a singleton in the PersistenceManager class
public class PersistenceManager {

    private static final PersistenceManager singleton = new PersistenceManager();

    private EntityManagerFactory emf;

    public static PersistenceManager getInstance() {

        return singleton;
    }

    private PersistenceManager() {
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (emf == null)
            createEntityManagerFactory();
        return emf;
    }

    public void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
            emf = null;
        }
    }

    private void createEntityManagerFactory() {
        this.emf = Persistence.createEntityManagerFactory("unit1");
    }
}