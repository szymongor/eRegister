package com.eregister.SecurityService.Model;

import java.io.Serializable;

/**
 * Created by Szymon on 09.04.2017.
 */
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}