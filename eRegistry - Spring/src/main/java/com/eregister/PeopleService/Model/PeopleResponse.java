package com.eregister.PeopleService.Model;

import com.eregister.PeopleService.Entity.Person;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Karo2 on 2017-05-10.
 */
public class PeopleResponse implements Serializable {
    private static final long serialVersionUID = 23L;
    private final String status;
    private final Collection<Person> people;

    public PeopleResponse(String status, Collection<Person> people) {
        this.status = status;
        this.people = people;
    }

    public String getStatus() {
        return this.status;
    }

    public Collection<Person> getPeople() {
        return this.people;
    }

}
