package com.eregister.LessonsService;

import com.eregister.LessonsService.Entity.Lesson;
import com.eregister.LessonsService.Service.LessonsService;
import com.eregister.LessonsService.Model.LessonsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Szymon on 07.04.2017.
 */

@RestController
@RequestMapping("/Lessons")
public class LessonsController
{
    @Autowired
    LessonsService lessonsService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public LessonsResponse getAllLessons(@RequestBody Object o){
        Collection<Lesson> lessons = lessonsService.getAllLessons();
        LessonsResponse lessonsResponse = new LessonsResponse("Ok",lessons);
        return lessonsResponse;
    }

    @RequestMapping(value ="/myLessons",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public LessonsResponse getMyLessons(@RequestHeader(value="Authorization")String token){
        String authToken =token;
        Collection<Lesson> lessons = lessonsService.getLessonsByStudentAttending(1);
        LessonsResponse lessonsResponse = new LessonsResponse(authToken,lessons);
        return lessonsResponse;
    }
}
