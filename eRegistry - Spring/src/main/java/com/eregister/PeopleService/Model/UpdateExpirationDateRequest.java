package com.eregister.PeopleService.Model;

/**
 * Created by Karo2 on 2017-05-10.
 */
public class UpdateExpirationDateRequest {
    private int idPerson;
    private String expirationDate;

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
