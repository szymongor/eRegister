package com.eregister.SecurityService.Model;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Szymon on 21.04.2017.
 */
public class JwtUserDetails implements UserDetails{

    List<JwtAuthority> authorities;
    String login;

    public JwtUserDetails(Claims claims){
        authorities = new ArrayList<>();
        login = claims.get("login").toString();
        String roles = claims.get("roles").toString();
        String[] splitedRoles = roles.split(",");
        for(String role : splitedRoles){
            JwtAuthority jwtAuthority = new JwtAuthority("ROLE_" + role);
            authorities.add(jwtAuthority);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
