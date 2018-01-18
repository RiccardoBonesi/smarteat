package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.teamsmarteat.model.OrderEntity;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrderListAction extends ActionSupport implements SessionAware {


    Map sessionMap;
    private static Logger logger = LogManager.getLogger(OrderListAction.class);

    private List<OrderEntity> result;

    public String execute() {
        if (sessionMap.isEmpty()) {
            return "noParameter";
        }

        String userId = (String) sessionMap.get("user");

        result = new ArrayList<>();
        EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT o from OrderEntity o " +
                "inner join RestaurantEntity r on o.restaurant.restaurantId = r.restaurantId " +
                "where r.username = ?");
        List<OrderEntity> orders = query.setParameter(0, userId).getResultList();
        Calendar calendar = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        for (OrderEntity order : orders) {
            calendar.setTime(order.getDate());
            boolean sameDay = calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                    calendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR);
            if (!order.getOrderLines().isEmpty() && sameDay && !order.isCheckout())
                result.add(order);
        }

        return SUCCESS;
    }

    public List getResult() {
        return result;
    }

    @Override
    public void setSession(Map session) {
        this.sessionMap = session;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {

    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {

    }

}
