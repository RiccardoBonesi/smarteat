package org.teamsmarteat;

import junit.framework.TestCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 */
public class PersistenceTest extends TestCase {

    private static final Logger logger = LogManager.getLogger(PersistenceTest.class);
    public void testConnection() throws Exception {
        assertTrue(connectDB());
    }

    private boolean connectDB () {
        EntityManagerFactory factory;
        EntityManager em;
        factory = Persistence.createEntityManagerFactory("unit1");
        em = factory.createEntityManager();
        return true;
    }
}

