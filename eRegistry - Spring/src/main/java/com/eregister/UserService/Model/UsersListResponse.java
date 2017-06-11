package com.eregister.UserService.Model;

import com.eregister.UserService.Entity.EregUser;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Szymon on 12.04.2017.
 */
public class UsersListResponse implements Serializable {

    private static final long serialVersionUID = 23L;

    private final String status;

    private final Collection<EregUser> usersList;

    public UsersListResponse(Collection<EregUser> users, String status) {
        this.usersList = users;
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public Collection<EregUser> getUsersList() {
        return this.usersList;
    }

}