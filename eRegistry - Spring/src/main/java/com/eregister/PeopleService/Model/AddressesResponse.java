package com.eregister.PeopleService.Model;

import com.eregister.PeopleService.Entity.Address;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Karo2 on 2017-05-10.
 */
public class AddressesResponse implements Serializable {
    private static final long serialVersionUID = 23L;
    private final String status;
    private final Collection<Address> addresses;

    public AddressesResponse(String status, Collection<Address> addresses){
        this.status = status;
        this.addresses = addresses;
    }

    public String getStatus(){
        return this.status;
    }

    public Collection<Address> getAddresses(){
        return this.addresses;
    }
}
