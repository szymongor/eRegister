package com.eregister.UserService.Model;

import com.eregister.UserService.Entity.EregUser;

import java.io.Serializable;

/**
 * Created by Szymon on 27.04.2017.
 */
public class UserResponse implements Serializable {

    private static final long serialVersionUID = 23L;

    private final String status;

    private final EregUser user;

    public UserResponse(EregUser user, String status) {
        this.user = user;
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public EregUser getUser() {
        return this.user;
    }
}
