package com.eregister.UserService;

import com.eregister.SecurityService.Model.ErrorResponse;
import com.eregister.UserService.Entity.EregUser;
import com.eregister.UserService.Model.UserResponse;
import com.eregister.UserService.Model.UsersListResponse;
import com.eregister.UserService.Service.EregUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.Serializable;
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
    public Serializable getAllEregUsers(){
        Serializable response;
        try{
            response = new UsersListResponse(eregUserService.getAllEregUsers(), "Ok");
        }
        catch (Exception e) {
            response = new ErrorResponse("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value ="/enables",method = RequestMethod.GET)
    @PreAuthorize("hasRole('TEACHER')")
    public Serializable getAllEnableEregUsers(){
        Serializable response;
        try{
            response = new UsersListResponse(eregUserService.getAllEnableEregUsers(), "Ok");
        }
        catch (Exception e) {
            response = new ErrorResponse("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value ="/teachers",method = RequestMethod.GET)
    @PreAuthorize("hasRole('TEACHER')")
    public Serializable getAllTeachersEregUsers(){
        Serializable response;
        try{
            response = new UsersListResponse(eregUserService.getAllTeachersEregUsers(), "Ok");
        }
        catch (Exception e) {
            response = new ErrorResponse("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value ="/guardians",method = RequestMethod.GET)
    @PreAuthorize("hasRole('TEACHER')")
    public Serializable getAllGuardiansEregUsers(){
        Serializable response;
        try{
            response = new UsersListResponse(eregUserService.getAllGuardiansEregUsers(), "Ok");
        }
        catch (Exception e) {
            response = new ErrorResponse("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value ="/students",method = RequestMethod.GET)
    @PreAuthorize("hasRole('TEACHER')")
    public Serializable getAllStudentsEregUsers(){
        Serializable response;
        try{
            response = new UsersListResponse(eregUserService.getAllStudentsEregUsers(), "Ok");
        }
        catch (Exception e){
            response = new ErrorResponse("Error", "Internal error");
        }

        return response;
    }

    @RequestMapping(value ="/id={id}",method = RequestMethod.GET)
    public Serializable getEregUserById(@PathVariable("id") int id){
        Serializable response;
        try{
            EregUser eregUser = eregUserService.getEregUserById(id);
            response = new UserResponse(eregUser, "OK");
        }
        catch(EmptyResultDataAccessException e){
            response = new ErrorResponse("Error", "No user with such id");
        }
        catch (Exception e){
            response = new ErrorResponse("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value ="/person/id={id}",method = RequestMethod.GET)
    public Serializable getEregUserByIdPerson(@PathVariable("id") int id){
        Serializable response;
        try{
            EregUser eregUser = eregUserService.getEregUserByIdPerson(id);
            response = new UserResponse(eregUser, "OK");
        }
        catch(EmptyResultDataAccessException e){
            response = new ErrorResponse("Error", "No user with such id");
        }
        catch (Exception e){
            response = new ErrorResponse("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value ="/login={login}",method = RequestMethod.GET)
    public Serializable getEregUserByLogin(@PathVariable("login") String login){
        Serializable response;
        try{
            EregUser eregUser = eregUserService.getEregUserByLogin(login);
            response = new UserResponse(eregUser, "OK");
        }
        catch(EmptyResultDataAccessException e){
            response = new ErrorResponse("Error", "No user with such id");
        }
        catch (Exception e){
            response = new ErrorResponse("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value ="/id={id}",method = RequestMethod.DELETE)
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
