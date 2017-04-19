package com.eregister.LessonsService.Controller;

import com.eregister.LessonsService.Entity.Lesson;
import com.eregister.LessonsService.LessonsService;
import com.eregister.LessonsService.Model.LessonsResponse;
import com.eregister.UserService.Entity.EregUser;
import com.eregister.UserService.Model.UsersListResponse;
import com.eregister.UserService.Service.EregUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
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
