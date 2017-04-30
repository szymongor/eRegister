package com.eregister.LessonsService.DAO;

import com.eregister.LessonsService.Entity.Lesson;

import java.util.Collection;

/**
 * Created by Karo2 on 2017-04-30.
 */
public class MySqlLessonsDao implements LessonsDao {
    @Override
    public Collection<Lesson> getAllLessons() {
        return null;
    }

    @Override
    public Collection<Lesson> getLessonsLeadsByTeacher(int idTeacher) {
        return null;
    }

    @Override
    public Collection<Lesson> getLessonsByAttendingGroup(int idGroup) {
        return null;
    }

    @Override
    public Collection<Lesson> getLessonsAboutSubject(int idSubject) {
        return null;
    }

    @Override
    public Lesson getLessonById(int id) {
        return null;
    }

    @Override
    public void removeLessonById(int id) {

    }

    @Override
    public void updateTeacher(Lesson lesson) {

    }

    @Override
    public void updateSemester(Lesson lesson) {

    }

    @Override
    public void insertLesson(Lesson lesson) {

    }
}
