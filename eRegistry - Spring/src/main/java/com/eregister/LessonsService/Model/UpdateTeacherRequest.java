package com.eregister.LessonsService.Model;

import java.io.Serializable;

/**
 * Created by Szymon on 07.05.2017.
 */
public class UpdateTeacherRequest {

    int idTeacher, idLesson;

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public int getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(int idLesson) {
        this.idLesson = idLesson;
    }
}
