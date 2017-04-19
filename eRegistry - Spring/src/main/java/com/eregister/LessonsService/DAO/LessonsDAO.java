package com.eregister.LessonsService.DAO;

import com.eregister.LessonsService.Entity.Lesson;
import org.springframework.http.converter.xml.Jaxb2CollectionHttpMessageConverter;

import java.util.Collection;

/**
 * Created by Szymon on 15.04.2017.
 */
public interface LessonsDAO {

    Collection<Lesson> getAllLessons();

    Lesson getLessonById(int id);

    Collection<Lesson> getLessonsByStudentAttending(int studentId);


}
