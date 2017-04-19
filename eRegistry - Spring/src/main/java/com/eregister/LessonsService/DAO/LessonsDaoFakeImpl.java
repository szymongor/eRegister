package com.eregister.LessonsService.DAO;

import com.eregister.LessonsService.Entity.Lesson;
import com.eregister.UserService.Entity.EregUser;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Szymon on 18.04.2017.
 */

@Repository
@Qualifier("fakeLessons")
public class LessonsDaoFakeImpl implements LessonsDAO{


    static Map<Integer, Lesson> lessons;
    static List<Map.Entry<Integer,Integer>> attends; //id student, id lesson

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

        attends = new ArrayList<>();
        attends.add(new AbstractMap.SimpleEntry<>(1,1));
        attends.add(new AbstractMap.SimpleEntry<>(1,2));
        attends.add(new AbstractMap.SimpleEntry<>(1,3));
        attends.add(new AbstractMap.SimpleEntry<>(2,1));
        attends.add(new AbstractMap.SimpleEntry<>(2,2));
        attends.add(new AbstractMap.SimpleEntry<>(2,3));
        attends.add(new AbstractMap.SimpleEntry<>(3,4));
        attends.add(new AbstractMap.SimpleEntry<>(3,5));
        attends.add(new AbstractMap.SimpleEntry<>(3,6));
    }



    @Override
    public Collection<Lesson> getAllLessons() {
        return lessons.values();
    }

    @Override
    public Lesson getLessonById(int id) {
        return lessons.get(id);
    }

    @Override
    public Collection<Lesson> getLessonsByStudentAttending(int studentId) {
        Collection<Lesson> lessons = new ArrayList<Lesson>();

        for(Map.Entry<Integer,Integer> attend : attends){
            if(attend.getKey() == studentId){
                lessons.add(getLessonById(attend.getValue()));
            }

        }
        return lessons;
    }
}
