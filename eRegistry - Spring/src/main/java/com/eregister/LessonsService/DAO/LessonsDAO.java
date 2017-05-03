package com.eregister.LessonsService.DAO;

import com.eregister.LessonsService.Entity.Lesson;
import org.springframework.http.converter.xml.Jaxb2CollectionHttpMessageConverter;

import java.util.Collection;

/**
 * Created by Szymon on 15.04.2017.
 */
public interface LessonsDao {

    Collection<Lesson> getAllLessons();

    Collection<Lesson> getLessonsLeadsByTeacher( int idTeacher );

    Collection<Lesson> getLessonsByAttendingGroup( int idGroup );

    Collection<Lesson> getLessonsAboutSubject( int idSubject );

    Lesson getLessonById(int id);

    void removeLessonById(int id);

    void updateTeacher(int id_teacher, int id);

    void updateSemester(String semester, int id);

    void insertLesson(Lesson lesson);
}
