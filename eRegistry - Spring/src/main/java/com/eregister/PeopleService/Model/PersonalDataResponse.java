package com.eregister.PeopleService.Model;

import com.eregister.PeopleService.Entity.PersonalData;

import java.io.Serializable;

/**
 * Created by Szymon on 05.06.2017.
 */
public class PersonalDataResponse implements Serializable {
    private static final long serialVersionUID = 23L;
    private final String status;
    private final PersonalData personalData;

    public PersonalDataResponse(String status, PersonalData personalData) {
        this.status = status;
        this.personalData = personalData;
    }

    public String getStatus() {
        return this.status;
    }

    public PersonalData getPersonalData() {
        return this.personalData;
    }

}
