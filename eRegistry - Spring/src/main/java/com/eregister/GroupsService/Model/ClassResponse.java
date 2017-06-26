package com.eregister.GroupsService.Model;

import com.eregister.GroupsService.Entity.Class;

import java.io.Serializable;

/**
 * Created by Karo2 on 2017-06-26.
 */
public class ClassResponse implements Serializable {

    private static final long serialVersionUID = 23L;
    private final String status;
    private final Class groupClass;

    public ClassResponse(String status, Class groupClass) {
        this.status = status;
        this.groupClass = groupClass;
    }

    public String getStatus() {
        return this.status;
    }

    public Class getGroupClass() {
        return groupClass;
    }
}