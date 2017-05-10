package com.eregister.PeopleService.Model;

import com.eregister.PeopleService.Entity.Address;

import java.io.Serializable;

/**
 * Created by Karo2 on 2017-05-10.
 */
public class AddressResponse implements Serializable {
    private static final long serialVersionUID = 23L;
    private final String status;
    private final Address address;

    public AddressResponse(String status, Address address) {
        this.status = status;
        this.address = address;
    }

    public String getStatus() {
        return this.status;
    }

    public Address getAddress() {
        return this.address;
    }
}
