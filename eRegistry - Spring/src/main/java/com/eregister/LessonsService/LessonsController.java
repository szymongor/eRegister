package com.eregister.LessonsService;

import com.eregister.LessonsService.Entity.Lesson;
import com.eregister.LessonsService.Model.LessonsResponse;
import com.eregister.LessonsService.Model.UpdateSemesterRequest;
import com.eregister.LessonsService.Model.UpdateTeacherRequest;
import com.eregister.LessonsService.Service.LessonsService;
import com.eregister.SecurityService.Model.Response;
import com.eregister.SecurityService.Token.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * Created by Szymon on 07.04.2017.
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Lessons")
public class LessonsController {
    @Autowired
    LessonsService lessonsService;

    @RequestMapping(method = RequestMethod.GET)
    public Serializable getAllLessons(@RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new LessonsResponse("ok", lessonsService.getAllLessons());
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/teacher/myLessons", method = RequestMethod.GET)
    public Serializable getLessonsLeadsByTeacher(@RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            int idEregUser = TokenUtils.getIdEregUserFromToken(token);
            response = new LessonsResponse("ok", lessonsService.getLessonsLeadsByTeacher(idEregUser));
        } catch (Exception e) {
            response = new Response("Error", e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/attendingGroup/id={idGroup}", method = RequestMethod.GET)
    public Serializable getLessonsByAttendingGroup(@PathVariable("idGroup") int idGroup,
                                                   @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new LessonsResponse("ok", lessonsService.getLessonsByAttendingGroup(idGroup));
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/student/myLessons", method = RequestMethod.GET)
    public Serializable getAllStudentLessons(@RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            int idEregUser = TokenUtils.getIdEregUserFromToken(token);
            response = new LessonsResponse("ok", lessonsService.getAllStudentLessons(idEregUser));
        } catch (Exception e) {
            response = new Response("Error", e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/id={id}", method = RequestMethod.DELETE)
    public Serializable removeLessonById(@PathVariable("id") int id,
                                         @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            lessonsService.removeLessonById(id);
            response = new Response("ok", "Removed lesson id: " + id);
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/updateTeacher", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable updateTeacher(@RequestBody UpdateTeacherRequest updateTeacherRequest,
                                      @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            lessonsService.updateTeacher(updateTeacherRequest);
            response = new Response("ok", "Updated teacher.");
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/updateSemester", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable updateSemester(@RequestBody UpdateSemesterRequest updateSemesterRequest,
                                       @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            lessonsService.updateSemester(updateSemesterRequest);
            response = new Response("ok", "Updated semester.");
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable insertLesson(@RequestBody Lesson lesson,
                                     @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            lessonsService.insertLesson(lesson);
            response = new Response("ok", "Inserted lesson");
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }
}
