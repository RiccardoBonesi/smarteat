package org.teamsmarteat;

import junit.framework.TestCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 */
public class PersistenceTest extends TestCase {

    public void testConnection() throws Exception {
        assertTrue(connectDB());
    }

    private boolean connectDB () {
        EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        return true;
    }
}

