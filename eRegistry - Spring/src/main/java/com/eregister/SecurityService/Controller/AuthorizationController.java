package com.eregister.SecurityService.Controller;

import com.eregister.SecurityService.AuthorizationService;
import com.eregister.SecurityService.Model.JwtAuthenticationResponse;
import com.eregister.SecurityService.Model.JwtCredentials;
import com.eregister.UserService.Entity.EregUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Szymon on 07.04.2017.
 */

@RestController
public class AuthorizationController {

    @Autowired
    AuthorizationService authorizationService;

    @RequestMapping(value = "auth", method = RequestMethod.POST)
    public JwtAuthenticationResponse createAuthenticationToken(@RequestBody JwtCredentials jwtCredentials){
        String token = authorizationService.authorizeEregUser(jwtCredentials);
        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse(token, "Ok");
        return jwtAuthenticationResponse;
    }

    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String verifyToken(@RequestBody JwtCredentials jwtCredentials){
        String response = authorizationService.authorizeEregUser(jwtCredentials);
        return response;
    }
}
