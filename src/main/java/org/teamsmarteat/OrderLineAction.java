package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.Order;
import org.teamsmarteat.model.OrderEntity;
import org.teamsmarteat.model.PromotionEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class OrderLineAction extends ActionSupport {
    private static Logger logger = LogManager.getLogger(OrderLineAction.class);

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
}
