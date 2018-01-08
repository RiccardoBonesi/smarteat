package org.teamsmarteat;

        import com.opensymphony.xwork2.ActionSupport;
        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;
        import org.teamsmarteat.model.DishEntity;
        import org.teamsmarteat.model.OrderEntity;

        import javax.persistence.EntityManager;
        import javax.persistence.EntityManagerFactory;
        import javax.persistence.Query;
        import java.util.List;

public class MenuManagement extends ActionSupport {

    private static Logger logger = LogManager.getLogger(MenuManagement.class);

    private List<DishEntity> result;

    public String execute () {
        EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        Query query= em.createQuery("select o from DishEntity o");
        result = query.getResultList();
        for (DishEntity res: result) {
            logger.debug(res);
        }
        return SUCCESS;
    }

    public List getResult() {
        return result;
    }
}
