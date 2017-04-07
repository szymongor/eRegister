package com.eregister.SecurityService.Controller;

import com.eregister.SecurityService.AuthorizationService;
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
@RequestMapping("/auth")
public class AuthorizationController {

    @Autowired
    AuthorizationService authorizationService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String insertEregUserById(@RequestBody JwtCredentials jwtCredentials){
        String response = authorizationService.authorizeEregUser(jwtCredentials);
        return response;
    }
}
