package com.eregister.SecurityService.Service;

import com.eregister.SecurityService.Model.JwtCredentials;
import com.eregister.SecurityService.Token.TokenUtils;
import com.eregister.UserService.Entity.EregUser;
import com.eregister.UserService.Service.EregUserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by Szymon on 07.04.2017.
 */

@Service
public class AuthorizationService {

    @Autowired
    EregUserService eregUserService;

    @Autowired
    private TokenUtils tokenUtils;

    public String authorizeEregUser(JwtCredentials jwtCredentials) throws Exception{
        String login = jwtCredentials.getLogin();
        String password = jwtCredentials.getPassword();
        EregUser user;
        try {
            user = eregUserService.getEregUserByLogin(login);
        }
        catch (Exception e){
            throw new SecurityException(e.getMessage());
        }

        if(!user.getPassword().equals(password)){
            throw new SecurityException("Wrong password");
        }

        String tokenStr;
        try{
            tokenStr = tokenUtils.generateToken(user);
        }
        catch (Exception e){
            throw new Exception("Token error");
        }

        return tokenStr;

    }

    public Claims verifyToken(String token){
        Claims claims = tokenUtils.verifyToken(token);
        EregUser user = getUser(claims);
        return claims;
    }

    public UserDetails userDetailsFromToken(String token){
        return tokenUtils.userDetailsFromToken(token);
    }

    private EregUser getUser(Claims claims){
        int userId = Integer.parseInt(claims.get("id").toString());
        EregUser user = eregUserService.getEregUserById(userId);
        return user;
    }

    private void checkLastPasswordResetDate(EregUser eregUser){
        //TO DO
    }

}
