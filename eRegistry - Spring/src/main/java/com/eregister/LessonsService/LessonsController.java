package com.eregister.LessonsService;

import com.eregister.LessonsService.Entity.Lesson;
import com.eregister.LessonsService.Model.LessonResponse;
import com.eregister.LessonsService.Model.LessonsResponse;
import com.eregister.LessonsService.Model.UpdateSemesterRequest;
import com.eregister.LessonsService.Model.UpdateTeacherRequest;
import com.eregister.LessonsService.Service.LessonsService;
import com.eregister.SecurityService.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * Created by Szymon on 07.04.2017.
 */

@RestController
@RequestMapping("/Lessons")
public class LessonsController {
    @Autowired
    LessonsService lessonsService;

    @RequestMapping(method = RequestMethod.GET)
    public Serializable getAllLessons() {
        Serializable response;
        try {
            response = new LessonsResponse("ok", lessonsService.getAllLessons());
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/leadBy/id={idTeacher}", method = RequestMethod.GET)
    public Serializable getLessonsLeadsByTeacher(@PathVariable("idTeacher") int idTeacher) {
        Serializable response;
        try {
            response = new LessonsResponse("ok", lessonsService.getLessonsLeadsByTeacher(idTeacher));
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/attendingGroup/id={idGroup}", method = RequestMethod.GET)
    public Serializable getLessonsByAttendingGroup(@PathVariable("idGroup") int idGroup) {
        Serializable response;
        try {
            response = new LessonsResponse("ok", lessonsService.getLessonsByAttendingGroup(idGroup));
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/about/id={idSubject}", method = RequestMethod.GET)
    public Serializable getLessonsAboutSubject(@PathVariable("idSubject") int idSubject) {
        Serializable response;
        try {
            response = new LessonsResponse("ok", lessonsService.getLessonsAboutSubject(idSubject));
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/id={id}", method = RequestMethod.GET)
    public Serializable getLessonById(@PathVariable("id") int id) {
        Serializable response;
        try {
            response = new LessonResponse("ok", lessonsService.getLessonById(id));
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/id={id}", method = RequestMethod.DELETE)
    public Serializable removeLessonById(@PathVariable("id") int id) {
        Serializable response;
        try {
            lessonsService.removeLessonById(id);
            response = new Response("ok", "Removed lesson id: " + id);
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/newTeacher", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable updateTeacher(@RequestBody UpdateTeacherRequest updateTeacherRequest) {
        Serializable response;
        try {
            lessonsService.updateTeacher(updateTeacherRequest);
            response = new Response("ok", "Updated teacher.");
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/newSemester", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable updateSemester(@RequestBody UpdateSemesterRequest updateSemesterRequest) {
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
    public Serializable insertLesson(@RequestBody Lesson lesson) {
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
