package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.teamsmarteat.model.UserEntity;

public class LoginAction extends ActionSupport {
    private UserEntity userEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String execute() {
        String user = userEntity.getUsername();

        return SUCCESS;
    }
}
