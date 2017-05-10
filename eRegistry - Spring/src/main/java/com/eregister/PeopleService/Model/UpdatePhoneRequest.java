package com.eregister.PeopleService.Model;

/**
 * Created by Karo2 on 2017-05-10.
 */
public class UpdatePhoneRequest {
    private int idPerson;
    private String phone;

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
