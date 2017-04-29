package com.eregister.UserService.Model;

import oracle.jrockit.jfr.StringConstantPool;

import java.io.Serializable;

/**
 * Created by Szymon on 29.04.2017.
 */
public class NewPasswordRequest implements Serializable {
    String oldPassword;
    String newPassword;

    private static final long serialVersionUID = 23L;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
