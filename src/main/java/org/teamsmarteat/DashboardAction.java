package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.teamsmarteat.model.UserEntity;

import java.util.Map;

public class DashboardAction extends ActionSupport  implements SessionAware {

    Map sessionMap;

    public String execute() throws Exception {
        int x=1;
        UserEntity currentUser = (UserEntity) sessionMap.get("userEntity");
        return SUCCESS;
    }

    @Override
    public void setSession(Map session)
    {
        this.sessionMap=session;
    }
}
