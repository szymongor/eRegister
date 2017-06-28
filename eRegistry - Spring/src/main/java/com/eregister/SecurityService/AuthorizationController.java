package com.eregister.SecurityService;

import com.eregister.SecurityService.Service.AuthorizationService;
import com.eregister.SecurityService.Model.Response;
import com.eregister.SecurityService.Model.JwtAuthenticationResponse;
import com.eregister.SecurityService.Model.JwtCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * Created by Szymon on 07.04.2017.
 */

@RestController
@CrossOrigin(origins = "*")
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
            response = new Response("Security error", e.getMessage());
        }
        catch (Exception e){
            response = new Response("Internal error", e.getMessage());
        }
        return response;
    }
}
