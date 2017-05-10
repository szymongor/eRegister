package com.eregister.PeopleService.Service;

import com.eregister.PeopleService.DAO.PeopleDAO;
import com.eregister.PeopleService.Entity.Address;
import com.eregister.PeopleService.Entity.Person;
import com.eregister.PeopleService.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Karo2 on 2017-05-07.
 */

@Service
public class PeopleService {
    @Autowired
    @Qualifier("mysql")
    PeopleDAO peopleDAO;

    public Collection<Person> getAllPeople() {
        return peopleDAO.getAllPeople();
    }

    public Person getPersonById(int id) {
        return peopleDAO.getPersonById(id);
    }

    public Address getAddressById(int id) {
        return peopleDAO.getAddressById(id);
    }

    public void removePersonById(int id) {
        peopleDAO.removePersonById(id);
    }

    public void removeAddressById(int id) {
        peopleDAO.removeAddressById(id);
    }

    public void updatePhone(UpdatePhoneRequest updatePhoneRequest) {
        int idPerson = updatePhoneRequest.getIdPerson();
        String newPhone = updatePhoneRequest.getPhone();
        peopleDAO.updatePhone(idPerson, newPhone);
    }

    public void updateMail(UpdateMailRequest updateMailRequest) {
        int idPerson = updateMailRequest.getIdPerson();
        String newMail = updateMailRequest.getMail();
        peopleDAO.updateMail(idPerson, newMail);
    }

    public void updateExpirationDate(UpdateExpirationDateRequest updateExpirationDateRequest) {
        int idPerson = updateExpirationDateRequest.getIdPerson();
        String newExpirationDate = updateExpirationDateRequest.getExpirationDate();
        peopleDAO.updateExpirationDate(idPerson, newExpirationDate);
    }

    public void updateIdAddress(UpdateIdAddressRequest updateIdAddressRequest) {
        int idPerson = updateIdAddressRequest.getIdPerson();
        int newIdAddress = updateIdAddressRequest.getNewIdAddress();
        peopleDAO.updateIdAddress(idPerson, newIdAddress);
    }

    public void updateAddress(UpdateAddressRequest updateAddressRequest) {
        int idAddress = updateAddressRequest.getIdAddress();
        Address newAddress = new Address();
        newAddress.setStreet(updateAddressRequest.getStreet());
        newAddress.setHouseNumber(updateAddressRequest.getHouseNumber());
        newAddress.setFlatNumber(updateAddressRequest.getFlatNumber());
        newAddress.setPostalCode(updateAddressRequest.getPostalCode());
        newAddress.setCity(updateAddressRequest.getCity());
        newAddress.setCountry(updateAddressRequest.getCountry());
        peopleDAO.updateAddress(idAddress, newAddress);
    }

    public void insertAddress(Address address) {
        peopleDAO.insertAddress(address);
    }

    public void insertPerson(Person person, Address address) {
        peopleDAO.insertPerson(person, address);
    }

    public void insertPerson(Person person) {
        peopleDAO.insertPerson(person);
    }
}
