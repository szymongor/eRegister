package com.eregister.LessonsService.Model;

import com.eregister.LessonsService.Entity.Lesson;

import java.io.Serializable;

/**
 * Created by Karo2 on 2017-05-04.
 */
public class LessonResponse implements Serializable {

    private static final long serialVersionUID = 23L;

    private final String status;

    private final Lesson lesson;

    public LessonResponse(String status, Lesson lesson) {
        this.status = status;
        this.lesson = lesson;
    }

    public String getStatus() {
        return this.status;
    }

    public Lesson getLesson() {
        return this.lesson;
    }
}
