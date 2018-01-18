package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.teamsmarteat.model.DishEntity;
import org.teamsmarteat.model.OrderEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.Map;

public class CheckoutAction extends ActionSupport {
    Map sessionMap;
    private int orderId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    private CheckoutAction() {
    }

    public String execute() {

        if (sessionMap == null || sessionMap.isEmpty()) {
            return "noParameter";
        }
        EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();

        OrderEntity orderEntity = em.find(OrderEntity.class, orderId);

        em.getTransaction().begin();
        orderEntity.setCheckout(true);
        em.getTransaction().commit();

        return SUCCESS;
    }
}
