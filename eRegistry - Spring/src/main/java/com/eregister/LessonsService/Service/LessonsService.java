package com.eregister.LessonsService.Service;

import com.eregister.LessonsService.DAO.LessonsDAO;
import com.eregister.LessonsService.Entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Szymon on 15.04.2017.
 */

@Service
public class LessonsService {

    @Autowired
    @Qualifier("mysql")
    LessonsDAO lessonsDao;

    public Collection<Lesson> getAllLessons(){
        return lessonsDao.getAllLessons();
    }

    public Collection<Lesson> getLessonsLeadsByTeacher( int idTeacher ) {
        return lessonsDao.getLessonsLeadsByTeacher(idTeacher);
    }

    public Collection<Lesson> getLessonsByAttendingGroup( int idGroup ) {
        return lessonsDao.getLessonsByAttendingGroup(idGroup);
    }

    public Collection<Lesson> getLessonsAboutSubject( int idSubject ) {
        return lessonsDao.getLessonsAboutSubject(idSubject);
    }

    public Lesson getLessonById(int id) {
        return lessonsDao.getLessonById(id);
    }

    public void removeLessonById(int id) {
        lessonsDao.removeLessonById(id);
    }

    public void updateTeacher(int idTeacher, int idLesson) {
        lessonsDao.updateTeacher(idTeacher, idLesson);
    }

    public void updateSemester(String semester, int idLesson) {
        lessonsDao.updateSemester(semester, idLesson);
    }

    public void insertLesson(Lesson lesson) {
        lessonsDao.insertLesson(lesson);
    }

}
