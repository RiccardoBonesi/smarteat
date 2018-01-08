package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.Order;
import org.teamsmarteat.model.OrderEntity;



public class OrderLineAction extends ActionSupport {
    private static Logger logger = LogManager.getLogger(OrderLineAction.class);

    private OrderEntity orderEntity;

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public OrderLineAction(){

    }

    public String execute(){


      int id = getOrderEntity().getOrderId();
        logger.debug(orderEntity.getOrderId());
        return SUCCESS;
    }
}
