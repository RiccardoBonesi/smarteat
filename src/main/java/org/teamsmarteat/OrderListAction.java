package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OrderListAction extends ActionSupport {

    public String execute () {
        EntityManager em;
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("unit1");
        em = factory.createEntityManager();
        return SUCCESS;
    }
}
