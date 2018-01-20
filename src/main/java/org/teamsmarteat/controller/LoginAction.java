package org.teamsmarteat.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.teamsmarteat.PersistenceManager;
import org.teamsmarteat.model.RestaurantEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {
    private String username;
    private String keyid;
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
        sessionMap.put("psw", keyid);
        return SUCCESS;
    }

    public void validate() {
        if (username.isEmpty() || keyid.isEmpty()) {
            addFieldError("username", "");
            loginFailed = true;
        } else {
            EntityManagerFactory entityManagerFactory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
            EntityManager em = entityManagerFactory.createEntityManager();
            Query query = em.createQuery("select r from RestaurantEntity r " +
                    "where r.username= ? " +
                    "and r.keyid= ?");
            List<RestaurantEntity> result = query.setParameter(0, username).setParameter(1, keyid).getResultList();
            if (result == null || result.isEmpty()) {
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

    public String getKeyid() {
        return keyid;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {

    }
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {

    }
}
