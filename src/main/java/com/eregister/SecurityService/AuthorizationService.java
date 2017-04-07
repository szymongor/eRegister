package com.eregister.SecurityService;

import com.eregister.SecurityService.Model.JwtCredentials;
import com.eregister.SecurityService.Token.TokenUtils;
import com.eregister.UserService.Entity.EregUser;
import com.eregister.UserService.Service.EregUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Szymon on 07.04.2017.
 */

@Service
public class AuthorizationService {

    @Autowired
    EregUserService eregUserService;

    public String authorizeEregUser(JwtCredentials jwtCredentials){
        String login = jwtCredentials.getLogin();
        String password = jwtCredentials.getPassword();
        EregUser user;
        try {
            user = eregUserService.getEregUserByLogin(login);
        }
        catch (Exception e){
            return "No such user!";
        }
        String tokenStr;
        try{
            TokenUtils tokenUtils = new TokenUtils();
            tokenStr = tokenUtils.generateToken(user);
        }
        catch (Exception e){
            return "TokenUtils Error";
        }

        return tokenStr;

    }
}
