package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.Order;
import org.teamsmarteat.model.OrderEntity;

import javax.persistence.EntityManager;


public class OrderLineAction extends ActionSupport {
    private static Logger logger = LogManager.getLogger(OrderLineAction.class);

    private int orderId;
    private OrderEntity order;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public OrderLineAction() {}

    public String execute() {
        EntityManager entityManager = PersistenceManager.getInstance().getEntityManagerFactory("unit1").createEntityManager();
        if (orderId != 0) {
            order = entityManager.find(OrderEntity.class, orderId);
            logger.debug(order.toString());
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
}
