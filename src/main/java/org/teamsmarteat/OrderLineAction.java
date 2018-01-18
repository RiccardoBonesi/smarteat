package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.criterion.Order;
import org.teamsmarteat.model.OrderEntity;
import org.teamsmarteat.model.PromotionEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class OrderLineAction extends ActionSupport implements SessionAware {
    private static Logger logger = LogManager.getLogger(OrderLineAction.class);
    Map sessionMap;
    private int orderId;
    private OrderEntity order;
    private List<PromotionLine> resultPromos;

    public List<PromotionLine> getResultPromos() {
        return resultPromos;
    }

    public void setResultPromos(List<PromotionLine> resultPromos) {
        this.resultPromos = resultPromos;
    }

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

    public OrderLineAction() {
    }

    public String execute() {
        if (sessionMap.isEmpty()) {
            return "noParameter";
        }
        EntityManager entityManager = PersistenceManager.getInstance().getEntityManagerFactory("unit1").createEntityManager();
        if (orderId != 0) {
            order = entityManager.find(OrderEntity.class, orderId);
            Query query = entityManager.createQuery("select count(*), o.promotion.id, o.quantity " +
                    "from OrderLineEntity o " +
                    "where o.order.id = ? and o.promotion.id in (SELECT p.id from PromotionEntity p)" +
                    "GROUP BY o.promotion.id");
            List<Object[]> result = query.setParameter(0,orderId).getResultList();
//            Query query = entityManager.createQuery("select count(*), promotion.id, quantity " +
//                    "from OrderLineEntity " +
//                    "where order.id = 1 and promotion.id in (SELECT promotion.id from PromotionEntity)" +
//                    "GROUP BY promotion");
            List quantities = new ArrayList<Integer>();
            List promos = new ArrayList<PromotionEntity>();
            for (Object[] res : result) {
                PromotionEntity promo = entityManager.find(PromotionEntity.class, res[1]);
                quantities.add(res[2]);
                promos.add(promo);
            }
            resultPromos = buildResultPromos(quantities, promos);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    private List<PromotionLine> buildResultPromos(List<Integer> quantities, List<PromotionEntity> promos) {
        List<PromotionLine> result = new ArrayList<>();
        for (int i = 0; i < quantities.size(); i++) {
            result.add(new PromotionLine(quantities.get(i),promos.get(i).getName(),promos.get(i).getDescription(),promos.get(i).getPrice()));
        }
        return result;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {

    }
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {

    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionMap = map;
    }
}
