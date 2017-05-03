package com.eregister.LessonsService.Service;

import com.eregister.LessonsService.DAO.LessonsDao;
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
    @Qualifier("fakeLessons")
    LessonsDao lessonsDao;

    public Collection<Lesson> getAllLessons(){
        return lessonsDao.getAllLessons();
    }

}
