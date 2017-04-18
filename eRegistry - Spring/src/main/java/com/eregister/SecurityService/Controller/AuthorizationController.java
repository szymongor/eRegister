package com.eregister.SecurityService.Controller;

import com.eregister.SecurityService.AuthorizationService;
import com.eregister.SecurityService.Model.ErrorResponse;
import com.eregister.SecurityService.Model.JwtAuthenticationResponse;
import com.eregister.SecurityService.Model.JwtCredentials;
import com.eregister.UserService.Entity.EregUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * Created by Szymon on 07.04.2017.
 */

@RestController
@RequestMapping(value = "auth")
public class AuthorizationController {

    @Autowired
    AuthorizationService authorizationService;

    @RequestMapping(method = RequestMethod.POST)
    public Serializable createAuthenticationToken(@RequestBody JwtCredentials jwtCredentials){
        String token;
        Serializable response;
        try{
            token = authorizationService.authorizeEregUser(jwtCredentials);
            response = new JwtAuthenticationResponse(token,"Ok");
        }
        catch (SecurityException e){
            response = new ErrorResponse("Security error", e.getMessage());
        }
        catch (Exception e){
            response = new ErrorResponse("Internal error", e.getMessage());
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String verifyToken(@RequestBody JwtCredentials jwtCredentials){
        //String response = authorizationService.authorizeEregUser(jwtCredentials);
        return "Ok";
    }
}
