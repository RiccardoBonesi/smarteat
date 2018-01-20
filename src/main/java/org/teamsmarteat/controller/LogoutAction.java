package org.teamsmarteat.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class LogoutAction extends ActionSupport {
    public LogoutAction() {
    }

    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        session.clear();
        return SUCCESS;
    }
}
