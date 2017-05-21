package com.eregister.PeopleService.Model;

/**
 * Created by Karo2 on 2017-05-10.
 */
public class UpdateMailRequest {
    private int idPerson;
    private String mail;

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
