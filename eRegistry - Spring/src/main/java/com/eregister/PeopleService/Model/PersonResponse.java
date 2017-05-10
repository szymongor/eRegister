package com.eregister.PeopleService.Model;

import com.eregister.PeopleService.Entity.Person;

import java.io.Serializable;

/**
 * Created by Karo2 on 2017-05-10.
 */
public class PersonResponse implements Serializable {
    private static final long serialVersionUID = 23L;
    private final String status;
    private final Person person;

    public PersonResponse(String status, Person person) {
        this.status = status;
        this.person = person;
    }

    public String getStatus() {
        return this.status;
    }

    public Person getPerson() {
        return this.person;
    }

}
