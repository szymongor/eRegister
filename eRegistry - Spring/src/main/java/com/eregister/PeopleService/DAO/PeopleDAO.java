package com.eregister.PeopleService.DAO;

import com.eregister.PeopleService.Entity.Address;
import com.eregister.PeopleService.Entity.Person;

import java.util.Collection;

/**
 * Created by Karo2 on 2017-05-07.
 */
public interface PeopleDAO {

    Collection<Person> getAllPeople();

    Collection<Person> getAllChild(int idPerson);

    Person getPersonById(int id);

    Address getAddressById(int id);

    void removePersonById(int id);

    void removeAddressById(int id);

    void updatePhone(int idPerson, String newPhone);

    void updateMail(int idPerson, String newMail);

    void updateExpirationDate(int idPerson, String newExpirationDate);

    void updateIdAddress(int idPerson, int newIdAddress);

    void updateAddress(int idAddress, Address newAddress);

    void insertAddress(Address address);

    void insertPerson(Person person, Address address);

    void insertPerson(Person person);
    // get all child -> guardian?? => people
    // add person with addres with role => jakos zrobic
    // people i address rozdzielić? => moze
    // błędy obsłużyć ładnie
    // zwracać id czy imię nazwisko? => imie i nazwisko
    // teksty w osobnym pliku "error" itp => jeden plik po którym dziedziczą inne
    // generator wpisów automatycznie

    // uczeń -> moje oceny, moje przedmioty;
    // rodzic -> moje dzieci -> oceny, przedmioty;
    // nauczyciel -> moje lekcje -> grupa -> uczniowie -> oceny;
    // nauczyciel -> edycja ocen;
}
