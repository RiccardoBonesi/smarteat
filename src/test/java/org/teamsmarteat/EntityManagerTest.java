package org.teamsmarteat;

import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.teamsmarteat.model.Menu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerTest extends TestCase {

    private EntityManager em;
    private static final Logger logger = LogManager.getLogger(EntityManagerTest.class);

    public void testFind() {
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("unit1");
        em = factory.createEntityManager();
        assertEquals(Menu.class, em.find(Menu.class,1).getClass());
        assertEquals(String.class, em.find(Menu.class,1).getName().getClass());
        logger.debug(em.find(Menu.class,1).getName());
    }
}
