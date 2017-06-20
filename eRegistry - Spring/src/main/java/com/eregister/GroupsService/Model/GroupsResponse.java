package com.eregister.GroupsService.Model;

import com.eregister.GroupsService.Entity.Group;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Karo2 on 2017-05-17.
 */
public class GroupsResponse implements Serializable {
    private static final long serialVersionUID = 23L;

    private final String status;

    private final Collection<Group> groups;

    public GroupsResponse(String status, Collection<Group> groups) {
        this.status = status;
        this.groups = groups;
    }

    public String getStatus() {
        return this.status;
    }

    public Collection<Group> getGroups() {
        return this.groups;
    }
}
