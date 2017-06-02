package com.eregister.SecurityService.Token;

import com.eregister.SecurityService.Model.JwtUserDetails;
import com.eregister.UserService.Entity.EregUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Szymon on 07.04.2017.
 */
@Component
public class TokenUtils {

    //@Value("${jwt.secret}")
    static private String secret = "eregpass";

    //@Value("${jwt.expiration}")
    static private Long expiration = 604800L;

    public static String generateToken(EregUser eregUser) throws UnsupportedEncodingException {
        String id = Integer.toString(eregUser.getId());
        String login = eregUser.getLogin();
        String roles = eregUser.getRoles();
        String generationDate = generationDate();

        String jwt = Jwts.builder()
                .setExpiration(generateExpirationDate())
                .claim("login", login)
                .claim("roles", roles)
                .claim("id",id)
                .claim("generationDate",generationDate)
                .signWith(
                        SignatureAlgorithm.HS256,
                        secret
                )
                .compact();

        return jwt;
    }

    private static Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    public static Claims verifyToken(String token) throws Exception {
        Claims claims =null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token).getBody();
        } catch (Exception e){
            throw new Exception("Wrong token format");
        }
        return claims;
    }

    public static String generationDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static UserDetails userDetailsFromToken(String token) throws Exception {
        Claims claims = verifyToken(token);
        UserDetails userDetails = new JwtUserDetails(claims);
        return userDetails;
    }

    public static String getLoginFromToken(String token) throws Exception {
        UserDetails userDetails = userDetailsFromToken(token);
        String login = userDetails.getUsername();
        return login;
    }

}
