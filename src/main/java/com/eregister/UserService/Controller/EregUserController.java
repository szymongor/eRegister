package com.eregister.UserService.Controller;

import com.eregister.UserService.Entity.EregUser;
import com.eregister.UserService.Service.EregUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;

/**
 * Created by Szymon on 07.04.2017.
 */

@RestController
@RequestMapping("/EregUsers")
public class EregUserController
{
    @Autowired
    EregUserService eregUserService;

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('TEACHER')")
    public Collection<EregUser> getAllEregUsers(){
        return eregUserService.getAllEregUsers();
    }

    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public EregUser getEregUserById(@PathVariable("id") int id){
        return eregUserService.getEregUserById(id);
    }

    @RequestMapping(value ="/{id}",method = RequestMethod.DELETE)
    public String removeEregUserById(@PathVariable("id") int id){
        eregUserService.removeEregUserById(id);
        return "Ereg user deleted";
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateEregUserById(@RequestBody EregUser eregUser){
        eregUserService.updateEregUser(eregUser);
        return "Ereg User updated!";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String insertEregUserById(@RequestBody EregUser eregUser){
        eregUserService.insertEregUser(eregUser);
        return "Ereg User inserted!";
    }
}
