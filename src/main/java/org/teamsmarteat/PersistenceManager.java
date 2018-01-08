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

    public EntityManagerFactory getEntityManagerFactory(String persistenceUnitName) {
        if (emf == null)
            createEntityManagerFactory(persistenceUnitName);
        return emf;
    }

    public void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
            emf = null;
        }
    }

    private void createEntityManagerFactory(String persistenceUnitName) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

}