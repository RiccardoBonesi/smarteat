package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.Order;
import org.teamsmarteat.model.OrderEntity;
import org.teamsmarteat.model.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class OrderListAction extends ActionSupport {

    private static Logger logger = LogManager.getLogger(OrderListAction.class);

    private List result;

    public String execute () {
        EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        Query query= em.createQuery("SELECT o,o2  from OrderEntity o join OrderLineEntity o2 ON o.orderId = o2.pk.order_idorder");
        result = query.getResultList();
        for (Object res: result) {
            logger.debug(res);
        }
        return SUCCESS;
    }

    public List getResult() {
        return result;
    }
}
