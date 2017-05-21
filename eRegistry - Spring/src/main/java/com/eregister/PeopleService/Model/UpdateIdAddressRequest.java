package com.eregister.PeopleService.Model;

/**
 * Created by Karo2 on 2017-05-10.
 */
public class UpdateIdAddressRequest {
    private int idPerson;
    private int newIdAddress;

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getNewIdAddress() {
        return newIdAddress;
    }

    public void setNewIdAddress(int newIdAddress) {
        this.newIdAddress = newIdAddress;
    }
}
