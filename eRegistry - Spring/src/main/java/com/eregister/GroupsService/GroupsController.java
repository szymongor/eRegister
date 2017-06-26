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

    @RequestMapping(value = "/myClass", method = RequestMethod.GET)
    public Serializable getMyClass(@RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            int idEregUser = TokenUtils.getIdEregUserFromToken(token);
            response = new ClassResponse("ok", groupsService.getUserClass(idEregUser));
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/userClass/userId={id}", method = RequestMethod.GET)
    public Serializable getMyClass(@PathVariable("id") int id, @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new ClassResponse("ok", groupsService.getUserClass(id));
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }
}
