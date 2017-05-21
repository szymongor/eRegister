package com.eregister.LessonsService.Model;

/**
 * Created by Szymon on 07.05.2017.
 */
public class UpdateSemesterRequest {

    String semester;
    int idLesson;

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(int idLesson) {
        this.idLesson = idLesson;
    }
}
