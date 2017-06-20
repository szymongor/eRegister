package com.eregister.SecurityService.Service;

import com.eregister.SecurityService.Model.JwtCredentials;
import com.eregister.SecurityService.Token.TokenUtils;
import com.eregister.UserService.Entity.EregUser;
import com.eregister.UserService.Service.EregUserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Szymon on 07.04.2017.
 */

@Service
public class AuthorizationService {

    @Autowired
    EregUserService eregUserService;

    @Autowired
    private TokenUtils tokenUtils;

    public String authorizeEregUser(JwtCredentials jwtCredentials) throws Exception {
        String login = jwtCredentials.getLogin();
        String password = jwtCredentials.getPassword();
        EregUser user;
        try {
            user = eregUserService.getEregUserByLogin(login);
        } catch (Exception e) {
            throw e;
        }

        if (!user.getPassword().equals(password)) {
            throw new SecurityException("Wrong password");
        }

        String tokenStr;
        try {
            tokenStr = tokenUtils.generateToken(user);
        } catch (Exception e) {
            throw new Exception("Token error");
        }

        return tokenStr;

    }

    public Claims verifyToken(String token) throws Exception {
        Claims claims = tokenUtils.verifyToken(token);
        EregUser user = getUser(claims);
        checkLastPasswordResetDate(user, claims);
        return claims;
    }

    public UserDetails userDetailsFromToken(String token) throws Exception {
        return tokenUtils.userDetailsFromToken(token);
    }

    private EregUser getUser(Claims claims) {
        EregUser user = null;
        try {
            int userId = Integer.parseInt(claims.get("id").toString());
            user = eregUserService.getEregUserById(userId);
        } catch (Exception e) {
            throw e;
        }

        return user;
    }

    private void checkLastPasswordResetDate(EregUser eregUser, Claims claims) {
        String lastPasswordResetDateStr = eregUser.getLastPasswordResetDate();
        String tokenGenerationDateStr = claims.get("generationDate").toString();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date lastPasswordResetDate;
        Date tokenGenerationDate;
        try {
            lastPasswordResetDate = dateFormat.parse(lastPasswordResetDateStr);
            tokenGenerationDate = dateFormat.parse(tokenGenerationDateStr);
        } catch (ParseException e) {
            throw new SecurityException("Parse exception");
        }
        long lastPasswordResetTimeSec = lastPasswordResetDate.getTime() / 1000;
        long tokenGenerationTimeSec = tokenGenerationDate.getTime() / 1000;
        if (tokenGenerationTimeSec < lastPasswordResetTimeSec) {
            throw new SecurityException(
                    "Token expired. Token generated: "
                            + tokenGenerationTimeSec
                            + ", last password reset : "
                            + lastPasswordResetTimeSec);
        }
    }

}
