package com.eregister.UserService;

import com.eregister.UserService.Entity.EregUser;
import com.eregister.UserService.Model.UsersListResponse;
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
    public UsersListResponse getAllEregUsers(){
        UsersListResponse usersListResponse =
                new UsersListResponse(eregUserService.getAllEregUsers(), "Ok");

        return usersListResponse;
    }

    @RequestMapping(value ="/enables",method = RequestMethod.GET)
    @PreAuthorize("hasRole('TEACHER')")
    public UsersListResponse getAllEnableEregUsers(){
        UsersListResponse usersListResponse =
                new UsersListResponse(eregUserService.getAllEnableEregUsers(), "Ok");

        return usersListResponse;
    }
    @RequestMapping(value ="/teachers",method = RequestMethod.GET)
    @PreAuthorize("hasRole('TEACHER')")
    public UsersListResponse getAllTeachersEregUsers(){
        UsersListResponse usersListResponse =
                new UsersListResponse(eregUserService.getAllTeachersEregUsers(), "Ok");

        return usersListResponse;
    }
    @RequestMapping(value ="/guardians",method = RequestMethod.GET)
    @PreAuthorize("hasRole('TEACHER')")
    public UsersListResponse getAllGuardiansEregUsers(){
        UsersListResponse usersListResponse =
                new UsersListResponse(eregUserService.getAllGuardiansEregUsers(), "Ok");

        return usersListResponse;
    }
    @RequestMapping(value ="/students",method = RequestMethod.GET)
    @PreAuthorize("hasRole('TEACHER')")
    public UsersListResponse getAllStudentsEregUsers(){
        UsersListResponse usersListResponse =
                new UsersListResponse(eregUserService.getAllStudentsEregUsers(), "Ok");

        return usersListResponse;
    }

    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public EregUser getEregUserById(@PathVariable("id") int id){
        return eregUserService.getEregUserById(id);
    }

    @RequestMapping(value ="/person/{id}",method = RequestMethod.GET)
    public EregUser getEregUserByIdPerson(@PathVariable("id") int id){
        return eregUserService.getEregUserByIdPerson(id);
    }

    @RequestMapping(value ="/login={login}",method = RequestMethod.GET)
    public EregUser getEregUserByLogin(@PathVariable("login") String login){
        return eregUserService.getEregUserByLogin(login);
    }

    @RequestMapping(value ="/{id}",method = RequestMethod.DELETE)
    public String removeEregUserById(@PathVariable("id") int id){
        eregUserService.removeEregUserById(id);
        return "Ereg user deleted";
    }

    @RequestMapping(value ="/login={login}",method = RequestMethod.DELETE)
    public String removeEregUserByLogin(@PathVariable("login") String login){
        eregUserService.removeEregUserByLogin(login);
        return "Ereg user deleted";
    }

    // zmienić update -> Szymek
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updatePasswordEregUser(@RequestBody EregUser eregUser){
        eregUserService.updatePasswordEregUser(eregUser);
        return "Ereg User updated!";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String insertEregUser(@RequestBody EregUser eregUser){
        eregUserService.insertEregUser(eregUser);
        return "Ereg User inserted!";
    }
}
