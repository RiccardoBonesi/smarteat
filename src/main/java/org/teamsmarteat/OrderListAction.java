package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.Order;
import org.teamsmarteat.model.OrderEntity;
import org.teamsmarteat.model.OrderLineEntity;
import org.teamsmarteat.model.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class OrderListAction extends ActionSupport {

    private static Logger logger = LogManager.getLogger(OrderListAction.class);

    private List<OrderEntity> result;
    private List<OrderEntity> orders;
    public String execute () {
        result = new ArrayList<>();
        EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        Query query= em.createQuery("SELECT o from OrderEntity o");
        orders = query.getResultList();
        for (OrderEntity order: orders) {
            if (order.getOrderLines().size()!=0)
                result.add(order);
        }
        return SUCCESS;
    }

    public List getResult() {
        return result;
    }



}
