package com.eregister.LessonsService;

import com.eregister.LessonsService.Entity.Lesson;
import com.eregister.LessonsService.Service.LessonsService;
import com.eregister.LessonsService.Model.LessonsResponse;
import com.eregister.SecurityService.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
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

    @RequestMapping(method = RequestMethod.GET)
    public Serializable getAllLessons(){
        Serializable response;
        try {
            response = new LessonsResponse("ok", lessonsService.getAllLessons());
        }
        catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }
    @RequestMapping(value = "/leadBy/id={idTeacher}", method = RequestMethod.GET)
    public Serializable getLessonsLeadsByTeacher(@PathVariable("idTeacher") int idTeacher) {
        Serializable response;
        try {
            response = new LessonsResponse("ok", lessonsService.getLessonsLeadsByTeacher(idTeacher));
        }
        catch(Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }
}
