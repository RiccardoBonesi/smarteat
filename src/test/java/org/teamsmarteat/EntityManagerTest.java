package org.teamsmarteat;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.teamsmarteat.model.MenuEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerTest {

    private static EntityManager em;

    @BeforeClass
    public static void setup() {
        EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
        em = factory.createEntityManager();
    }

    @Test
    public void testFind() {
        Assert.assertEquals(MenuEntity.class, em.find(MenuEntity.class, 1).getClass());
    }
}
