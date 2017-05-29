package com.eregister.GroupsService;

import com.eregister.GroupsService.Model.GroupsResponse;
import com.eregister.GroupsService.Service.GroupsService;
import com.eregister.SecurityService.Model.Response;
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

    @RequestMapping(value = "/teachBy/id={idTeacher}", method = RequestMethod.GET)
    public Serializable getAllGroupsByTeacher(@PathVariable("idTeacher") int idTeacher,
                                              @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new GroupsResponse("ok", groupsService.getAllGroupsByTeacher(idTeacher));
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }
}
