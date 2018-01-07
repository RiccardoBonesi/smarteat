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
    public String execute () {
        EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        Query query= em.createQuery("select o from OrderEntity o");
        List<OrderEntity> result = query.getResultList();
        for (OrderEntity res: result) {
            logger.debug(res);
        }
        return SUCCESS;
    }
}
