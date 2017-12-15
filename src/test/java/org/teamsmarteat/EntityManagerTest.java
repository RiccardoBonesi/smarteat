package org.teamsmarteat;

import junit.framework.TestCase;
import org.teamsmarteat.model.Menu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerTest extends TestCase {

    EntityManager em;

    public void testFind() {
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("unit1");
        em = factory.createEntityManager();
        assertEquals(Menu.class, em.find(Menu.class,1).getClass());
    }
}
