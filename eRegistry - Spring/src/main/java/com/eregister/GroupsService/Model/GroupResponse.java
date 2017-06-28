package com.eregister.GroupsService.Model;

import com.eregister.GroupsService.Entity.Group;

import java.io.Serializable;

/**
 * Created by Karo2 on 2017-05-17.
 */
public class GroupResponse implements Serializable {
    private static final long serialVersionUID = 23L;

    private final String status;

    private final Group group;

    public GroupResponse(String status, Group group) {
        this.status = status;
        this.group = group;
    }

    public String getStatus() {
        return this.status;
    }

    public Group getGroup() {
        return this.group;
    }
}
