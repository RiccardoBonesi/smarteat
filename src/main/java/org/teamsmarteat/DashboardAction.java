package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class DashboardAction extends ActionSupport  implements SessionAware {

    Map sessionMap;

    public String execute() throws Exception {
        String currentUser = (String) sessionMap.get("user");
        return SUCCESS;
    }

    @Override
    public void setSession(Map session)
    {
        this.sessionMap=session;
    }
}
