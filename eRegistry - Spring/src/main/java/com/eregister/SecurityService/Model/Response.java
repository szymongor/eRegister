package com.eregister.SecurityService.Model;

import java.io.Serializable;

/**
 * Created by Szymon on 12.04.2017.
 */
public class Response implements Serializable {

    private static final long serialVersionUID = 23L;

    private final String status;

    private final String message;

    public Response(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus(){
        return this.status;
    }

    public String getMessage(){
        return this.message;
    }


}