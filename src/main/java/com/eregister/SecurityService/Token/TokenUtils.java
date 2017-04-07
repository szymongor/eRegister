package com.eregister.SecurityService.Token;

import com.eregister.UserService.Entity.EregUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Szymon on 07.04.2017.
 */
@Component
public class TokenUtils {


    //@Value("${jwt.secret}")
    static private String secret = "eregpass";

    //@Value("${jwt.expiration}")
    static private Long expiration;

    public String generateToken(EregUser eregUser) throws UnsupportedEncodingException {
        String id = Integer.toString(eregUser.getId());
        String login = eregUser.getLogin();
        String role = eregUser.getRole();

        String jwt = Jwts.builder()
                //.setExpiration(new Date(1300819380))
                .claim("login", login)
                .claim("role", role)
                .claim("id",id)
                .signWith(
                        SignatureAlgorithm.HS256,
                        secret
                )
                .compact();


        return jwt;
    }


}
