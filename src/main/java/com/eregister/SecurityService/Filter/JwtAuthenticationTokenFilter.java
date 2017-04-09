package com.eregister.SecurityService.Filter;

import com.eregister.SecurityService.AuthorizationService;
import com.eregister.SecurityService.Model.JwtAuthority;
import com.eregister.SecurityService.Token.TokenUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Szymon on 08.04.2017.
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {


    //private final Log logger = LogFactory.getLog(this.getClass());

    //@Autowired
    //private UserDetailsService userDetailsService;

    @Autowired
    private AuthorizationService authorizationService;

    //@Value("${jwt.header}")
    //private String tokenHeader;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authToken = request.getHeader("Authorization");
        if(! "/auth".equals(request.getRequestURI())) {
            UserDetails userDetails = authorizationService.userDetailsFromToken(authToken);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

    private Claims verifyToken(String authToken){
        try {
            Claims claims;
            claims = authorizationService.verifyToken(authToken);
            String resp = "Login: ";
            resp += claims.get("login");
            resp += ", Role: "+ claims.get("role");
            //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, resp);
            return claims;
        }
        catch(Exception e){
            throw e;
        }
    }


}