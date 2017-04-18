package com.eregister.LessonsService.DAO;

import com.eregister.LessonsService.Entity.Lesson;
import com.eregister.UserService.Entity.EregUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Szymon on 18.04.2017.
 */

@Repository
@Qualifier("fakeLessons")
public class LessonsDaoFakeImpl implements LessonsDAO{


    static Map<Integer, Lesson> lessons;

    static{
        lessons = new HashMap<Integer, Lesson>(){
            {
                put(1, new Lesson(1, 2010, 1,"Polski"));
                put(2, new Lesson(2, 2010, 1,"Matematyka"));
                put(3, new Lesson(3, 2010, 1,"WF"));
                put(4, new Lesson(4, 2010, 2,"Polski"));
                put(5, new Lesson(5, 2010, 2,"Historia"));
                put(6, new Lesson(6, 2010, 2,"Przyroda"));
            }
        };
    }



    @Override
    public Collection<Lesson> getAllLessons() {
        return lessons.values();
    }

    @Override
    public Lesson getLessonById(int id) {
        return null;
    }

    @Override
    public Collection<Lesson> getLessonByStudentAttending(int studentId) {
        return null;
    }
}
