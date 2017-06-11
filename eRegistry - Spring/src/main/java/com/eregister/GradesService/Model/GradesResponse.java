package com.eregister.GradesService.Model;

import com.eregister.GradesService.Entity.Grade;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Karo2 on 2017-06-11.
 */
public class GradesResponse implements Serializable {

    private static final long serialVersionUID = 23L;
    private final String status;
    private final Collection<Grade> grades;

    public GradesResponse(String status, Collection<Grade> grades) {
        this.status = status;
        this.grades = grades;
    }

    public String getStatus() {
        return this.status;
    }

    public Collection<Grade> getGrades() {
        return this.grades;
    }
}

