package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.teamsmarteat.model.OrderEntity;
import org.teamsmarteat.model.PromotionEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PromotionAction extends ActionSupport {

    private PromotionAction(){

    }

    List<PromotionEntity> result;
    @Override
    public String execute() throws Exception {
        result = new ArrayList<PromotionEntity>();
        EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        Query query= em.createQuery("SELECT p from PromotionEntity p");
        result = query.getResultList();
        return SUCCESS;
    }
    public List getResult() {
        return result;
    }

    public void setResult(List<PromotionEntity> result) {
        this.result = result;
    }
}
