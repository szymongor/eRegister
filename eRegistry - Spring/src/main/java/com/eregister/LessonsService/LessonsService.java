package com.eregister.LessonsService;

import com.eregister.LessonsService.DAO.LessonsDAO;
import com.eregister.LessonsService.Entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * Created by Szymon on 15.04.2017.
 */

@Service
public class LessonsService {

    @Autowired
    @Qualifier("fakeLessons")
    LessonsDAO lessonsDAO;

    public Collection<Lesson> getAllLessons(){
        return lessonsDAO.getAllLessons();
    }

    public Collection<Lesson> getLessonsByStudentAttending(int idStudent){
        return lessonsDAO.getLessonsByStudentAttending(idStudent);
    }

}
