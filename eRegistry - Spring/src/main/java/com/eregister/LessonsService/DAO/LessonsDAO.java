package com.eregister.LessonsService.DAO;

import com.eregister.LessonsService.Entity.Lesson;
import org.springframework.http.converter.xml.Jaxb2CollectionHttpMessageConverter;

import java.util.Collection;

/**
 * Created by Szymon on 15.04.2017.
 */
public interface LessonsDAO {

    Collection<Lesson> getAllLessons();

    Collection<Lesson> getLessonsLeadsByTeacher( int idEregUser );

    Collection<Lesson> getLessonsByAttendingGroup( int idGroup );

    Collection<Lesson> getAllStudentLessons( int idEregUser );

    void removeLessonById(int id);

    void updateTeacher(int idTeacher, int idLesson);

    void updateSemester(String semester, int idLesson);

    void insertLesson(Lesson lesson);
}
