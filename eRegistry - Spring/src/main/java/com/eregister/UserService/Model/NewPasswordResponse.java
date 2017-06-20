package com.eregister.UserService.Model;

import java.io.Serializable;

/**
 * Created by Szymon on 29.04.2017.
 */
public class NewPasswordResponse implements Serializable {
    String status;
    String message;
    String token;

    private static final long serialVersionUID = 23L;

    public NewPasswordResponse(String status, String message, String token) {
        this.status = status;
        this.message = message;
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
