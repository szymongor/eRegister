package com.eregister.LessonsService.Service;

import com.eregister.LessonsService.DAO.LessonsDAO;
import com.eregister.LessonsService.Entity.Lesson;
import com.eregister.LessonsService.Model.UpdateSemesterRequest;
import com.eregister.LessonsService.Model.UpdateTeacherRequest;
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

    public Collection<Lesson> getLessonsLeadsByTeacher( int idEregUser ) {
        return lessonsDao.getLessonsLeadsByTeacher(idEregUser);
    }

    public Collection<Lesson> getLessonsByAttendingGroup( int idGroup ) {
        return lessonsDao.getLessonsByAttendingGroup(idGroup);
    }

    public Collection<Lesson> getAllStudentLessons( int idEregUser ) {
        return lessonsDao.getAllStudentLessons(idEregUser);
    }

    public void removeLessonById(int id) {
        lessonsDao.removeLessonById(id);
    }

    public void updateTeacher(UpdateTeacherRequest updateTeacherRequest) {
        int idTeacher = updateTeacherRequest.getIdTeacher();
        int idLesson = updateTeacherRequest.getIdLesson();
        lessonsDao.updateTeacher(idTeacher, idLesson);
    }

    public void updateSemester(UpdateSemesterRequest updateSemesterRequest) {
        String semester = updateSemesterRequest.getSemester();
        int idLesson = updateSemesterRequest.getIdLesson();
        lessonsDao.updateSemester(semester, idLesson);
    }

    public void insertLesson(Lesson lesson) {
        lessonsDao.insertLesson(lesson);
    }

}
