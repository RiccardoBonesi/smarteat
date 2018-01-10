package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.teamsmarteat.model.OrderEntity;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrderListAction extends ActionSupport {

    private static Logger logger = LogManager.getLogger(OrderListAction.class);

    private List<OrderEntity> result;

    public String execute () {
        result = new ArrayList<>();
        EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        Query query= em.createQuery("SELECT o from OrderEntity o");
        List<OrderEntity> orders = query.getResultList();
        Calendar calendar = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        for (OrderEntity order: orders) {
            calendar.setTime(order.getDate());
            boolean sameDay = calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                    calendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR);
            if (order.getOrderLines().size()!=0 && sameDay && !order.isCheckout())
                result.add(order);
        }

        return SUCCESS;
    }

    public List getResult() {
        return result;
    }



}
