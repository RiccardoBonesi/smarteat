package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.teamsmarteat.model.CategoryEntity;
import org.teamsmarteat.model.DishEntity;
import org.teamsmarteat.model.OrderEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class DishListAction extends ActionSupport {

    private static Logger logger = LogManager.getLogger(DishListAction.class);

    private List <DishEntity> resultDish;
    private List <CategoryEntity> resultCategory;

    public String execute () {
        EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        Query queryDish= em.createQuery("select d from DishEntity d inner join CategoryEntity c on d.category=c.categoryId order by c.categoryId");
        resultDish = queryDish.getResultList();

        em = factory.createEntityManager();
        Query queryCategory= em.createQuery("select c from CategoryEntity c");
        resultCategory = queryCategory.getResultList();
//        for (CategoryEntity resCat: resultCategory) {
////            logger.debug(res);
//
//        }


//        for (DishEntity res: result) {
//            logger.debug(res);
//        }
        return SUCCESS;
    }

    public List getResultCategory() {
        return resultCategory;
    }

    public List getResultDish() {
        return resultDish;
    }
}
