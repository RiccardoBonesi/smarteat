package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.teamsmarteat.model.OrderEntity;
import org.teamsmarteat.model.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {
    private UserEntity userEntity;
    Map sessionMap;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String execute() {
        String user = userEntity.getUsername();
        String pwd = userEntity.getPassword();
        pwd="BananaU24";
        EntityManagerFactory entityManagerFactory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query= em.createQuery("select u from UserEntity u " +
                "where u.username= :userUsername " +
                "and u.password= :userPassword");

        List<UserEntity> result = query.setParameter("userUsername", user).setParameter("userPassword", pwd).getResultList();

        if(result.size()>0){
            sessionMap.put("userEntity",result.get(0));
            return SUCCESS;
        }else{
            return ERROR;
        }


    }

    @Override
    public void setSession(Map session)
    {
        this.sessionMap=session;
    }
}
