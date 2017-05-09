package com.eregister.PeopleService.DAO;

import com.eregister.PeopleService.Entity.Address;
import com.eregister.PeopleService.Entity.Person;

import java.util.Collection;

/**
 * Created by Karo2 on 2017-05-07.
 */
public interface PeopleDAO {

    Collection<Person> getAllPeople();

    Person getPersonById(int id);

    Address getAddressById(int id);

    void removePersonById(int id);

    void removeAddressById(int id);

    void updatePhone(int idPerson, String newPhone);

    void updateMail(int idPerson, String newMail);

    void updateExpirationDate(int idPerson, String newExpirationDate);

    void updateAddress(int idPerson, int newIdAddress);

    void insertAddress(Address address);

    void insertPerson(Person person, Address address);

    void insertPerson(Person person);
//get all child -> guardian??
}
