package com.eregister.LessonsService.DAO;

import com.eregister.LessonsService.Entity.Lesson;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Szymon on 18.04.2017.
 */

@Repository
@Qualifier("fakeLessons")
public class LessonsDaoFakeImpl implements LessonsDao {


    static Map<Integer, Lesson> lessons;
    static List<Map.Entry<Integer,Integer>> attends; //id student, id lesson

    static{
        lessons = new HashMap<Integer, Lesson>(){
            {
                put(1, new Lesson(1, "2010/2011", "letni",1,1,1));
                put(2, new Lesson(2, "2010/2011", "letni",2,2,2));
                put(3, new Lesson(3, "2010/2011", "letni",3,3,3));
                put(4, new Lesson(4, "2010/2011", "zimowy",1,1,2));
                put(5, new Lesson(5, "2010/2011", "zimowy",1,2,1));
                put(6, new Lesson(6, "2010/2011", "zimowy",2,1,4));
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
        return lessons.get(id);
    }

    @Override
    public void removeLessonById(int id) {

    }

    @Override
    public void updateTeacher(int id_teacher, int id) {

    }

    @Override
    public void updateSemester(String semester, int id) {

    }

    @Override
    public void insertLesson(Lesson lesson) {

    }

}
