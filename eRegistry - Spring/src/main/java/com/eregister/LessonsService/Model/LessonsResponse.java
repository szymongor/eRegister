package com.eregister.LessonsService.Model;

import com.eregister.LessonsService.Entity.Lesson;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Szymon on 19.04.2017.
 */
public class LessonsResponse implements Serializable {

    private static final long serialVersionUID = 23L;

    private final String status;

    private final Collection<Lesson> lessons;

    public LessonsResponse(String status, Collection<Lesson> lessons) {
        this.status = status;
        this.lessons = lessons;
    }

    public String getStatus() {
        return this.status;
    }

    public Collection<Lesson> getLessons() {
        return this.lessons;
    }


}
