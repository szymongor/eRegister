package com.eregister.SecurityService.Model;

import java.io.Serializable;

/**
 * Created by Szymon on 09.04.2017.
 */
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 23L;

    private final String status;

    private final String token;

    public JwtAuthenticationResponse(String token, String status) {
        this.token = token;
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    public String getToken() {
        return this.token;
    }

}