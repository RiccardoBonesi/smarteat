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
    private boolean loginFailed = false;
    private List<RestaurantEntity> result;
    Map sessionMap;

    public List<RestaurantEntity> getResult() {
        return result;
    }

    public void setResult(List<RestaurantEntity> result) {
        this.result = result;
    }

    public String execute() {
        sessionMap.put("user", username);
        sessionMap.put("psw", password);
        return SUCCESS;
    }



    public void validate() {
        if (username.isEmpty() || password.isEmpty()) {
            addFieldError("username", "");
            loginFailed = true;
        } else if (!username.isEmpty() && !password.isEmpty()) {
            EntityManagerFactory entityManagerFactory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
            EntityManager em = entityManagerFactory.createEntityManager();
            Query query = em.createQuery("select r from RestaurantEntity r " +
                    "where r.username= :userUsername " +
                    "and r.password= :userPassword");
            List<RestaurantEntity> result = query.setParameter("userUsername", username).setParameter("userPassword", password).getResultList();
            if (result == null || result.size() == 0) {
                addFieldError("username", "");
                loginFailed = true;
            }
        }
    }

    @Override
    public void setSession(Map session) {
        this.sessionMap = session;
    }

    public boolean isLoginFailed() {
        return loginFailed;
    }

    public void setLoginFailed(boolean loginFailed) {
        this.loginFailed = loginFailed;
    }

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
}
