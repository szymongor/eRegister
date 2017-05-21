package com.eregister.PeopleService.Model;

import com.eregister.PeopleService.Entity.Address;
import com.eregister.PeopleService.Entity.Person;

/**
 * Created by Karo2 on 2017-05-10.
 */
public class InsertPersonWithAddress {
    private Address address;
    private Person person;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
