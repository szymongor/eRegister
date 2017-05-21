package com.eregister.UserService;

import com.eregister.SecurityService.Model.Response;
import com.eregister.SecurityService.Token.TokenUtils;
import com.eregister.UserService.Entity.EregUser;
import com.eregister.UserService.Model.NewPasswordRequest;
import com.eregister.UserService.Model.NewPasswordResponse;
import com.eregister.UserService.Model.UserResponse;
import com.eregister.UserService.Model.UsersListResponse;
import com.eregister.UserService.Service.EregUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * Created by Szymon on 07.04.2017.
 */

@RestController
@CrossOrigin(origins = "*")
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
            response = new Response("Error", "Internal error");
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
            response = new Response("Error", "Internal error");
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
            response = new Response("Error", "Internal error");
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
            response = new Response("Error", "Internal error");
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
            response = new Response("Error", "Internal error");
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
            response = new Response("Error", "No user with such id");
        }
        catch (Exception e){
            response = new Response("Error", "Internal error");
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
            response = new Response("Error", "No user with such id");
        }
        catch (Exception e){
            response = new Response("Error", "Internal error");
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
            response = new Response("Error", "No user with such id");
        }
        catch (Exception e){
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value ="/id={id}",method = RequestMethod.DELETE)
    public Serializable removeEregUserById(@PathVariable("id") int id){
        Serializable response;
        try{
            eregUserService.removeEregUserById(id);
            response = new Response("Ok","Removed eReg user id:" + id);
        }
        catch (Exception e){
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value ="/login={login}",method = RequestMethod.DELETE)
    public Serializable removeEregUserByLogin(@PathVariable("login") String login){
        Serializable response;
        try{
            eregUserService.removeEregUserByLogin(login);
            response = new Response("Ok","Removed eReg user login:" + login);
        }
        catch (Exception e){
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value ="/newPassword",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable updatePasswordEregUser(@RequestBody NewPasswordRequest newPasswordRequest,
                                               @RequestHeader(value="Authorization")String token){
        Serializable response;
        try{
            String login = TokenUtils.getLoginFromToken(token);
            eregUserService.updatePasswordEregUser(login, newPasswordRequest);
            EregUser eregUser = eregUserService.getEregUserByLogin(login);
            String newToken = TokenUtils.generateToken(eregUser);
            response = new NewPasswordResponse("Ok","Login: " + login
                    +", new pass: " + newPasswordRequest.getNewPassword(),
                    newToken);
        }
        catch (Exception e){
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable insertEregUser(@RequestBody EregUser eregUser){
        Serializable response;
        try{
            eregUserService.insertEregUser(eregUser);
            response = new Response("Ok","Inserted user");
        }
        catch (Exception e){
            response = new Response("Error", "Internal error");
        }
        return response;
    }
}
