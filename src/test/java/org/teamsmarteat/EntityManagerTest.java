package org.teamsmarteat;

import junit.framework.TestCase;
import org.teamsmarteat.model.MenuEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerTest extends TestCase {

    EntityManager em;

    public void testFind() {
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("unit1");
        em = factory.createEntityManager();
        assertEquals(MenuEntity.class, em.find(MenuEntity.class,1).getClass());
    }
}
