package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.teamsmarteat.model.RestaurantEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {
    private String username;
    private String password;
    Map sessionMap;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String execute() {
        String user = username;
        String pwd = password;
        pwd="BananaU2";
        EntityManagerFactory entityManagerFactory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query= em.createQuery("select r from RestaurantEntity r " +
                "where r.username= :userUsername " +
                "and r.password= :userPassword");

        List<RestaurantEntity> result = query.setParameter("userUsername", user).setParameter("userPassword", pwd).getResultList();

        if(result.size()>0){
            sessionMap.put("user",user);
            sessionMap.put("psw",password);
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
