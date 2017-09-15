package com.eregister.GroupsService;

import com.eregister.GroupsService.Model.ClassResponse;
import com.eregister.GroupsService.Model.GroupsResponse;
import com.eregister.GroupsService.Service.GroupsService;
import com.eregister.PeopleService.Model.PeopleResponse;
import com.eregister.SecurityService.Model.Response;
import com.eregister.SecurityService.Token.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * Created by Karo2 on 2017-05-17.
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Groups")
public class GroupsController {
    @Autowired
    GroupsService groupsService;

    @RequestMapping(value = "/teacher/myGroups", method = RequestMethod.GET)
    public Serializable getAllGroupsTeachByUser(@RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            int idEregUser = TokenUtils.getIdEregUserFromToken(token);
            response = new GroupsResponse("ok", groupsService.getAllGroupsTeachByUser(idEregUser));
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/attendingStudents/{idGroup}", method = RequestMethod.GET)
    public Serializable getAllStudentsFromGroup(@PathVariable("idGroup") int idGroup,
                                                @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new PeopleResponse("ok", groupsService.getAllStudentsFromGroup(idGroup));
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/student/myClass", method = RequestMethod.GET)
    public Serializable getStudentMyClass(@RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            int idEregUser = TokenUtils.getIdEregUserFromToken(token);
            response = new ClassResponse("ok", groupsService.getStudentClass(idEregUser));
        } catch (Exception e) {
            response = new Response("Error", "Internal Error");
        }
        return response;
    }

    @RequestMapping(value = "/studentClass/userId={id}", method = RequestMethod.GET)
    public Serializable getStudentMyClass(@PathVariable("id") int id, @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new ClassResponse("ok", groupsService.getStudentClass(id));
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/teacher/myClass", method = RequestMethod.GET)
    public Serializable getMyClass(@RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            int idEregUser = TokenUtils.getIdEregUserFromToken(token);
            response = new ClassResponse("ok", groupsService.getTeacherClass(idEregUser));
        } catch (Exception e) {
            response = new Response("Error", e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/teacherClass/userId={id}", method = RequestMethod.GET)
    public Serializable getMyClass(@PathVariable("id") int id, @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new ClassResponse("ok", groupsService.getTeacherClass(id));
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }
}
