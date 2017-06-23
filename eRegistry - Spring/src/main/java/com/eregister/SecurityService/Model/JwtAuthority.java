package com.eregister.SecurityService.Model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Szymon on 09.04.2017.
 */
public class JwtAuthority implements GrantedAuthority {

    String role;

    public JwtAuthority(String role){
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return this.role;
    }
}
