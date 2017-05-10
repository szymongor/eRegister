package com.eregister.PeopleService.DAO;

import com.eregister.PeopleService.DAO.RowMappers.AddressRowMapper;
import com.eregister.PeopleService.DAO.RowMappers.PersonRowMapper;
import com.eregister.PeopleService.Entity.Address;
import com.eregister.PeopleService.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Karo2 on 2017-05-07.
 */

@Repository
@Qualifier("mysql")
public class MySqlPeopleDAO implements PeopleDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Collection<Person> getAllPeople() {
        final String sql = Queries.GET_ALL_PEOPLE;
        Collection<Person> people = jdbcTemplate.query(sql, new PersonRowMapper());
        return people;
    }

    @Override
    public Person getPersonById(int id) {
        final String sql = Queries.GET_PERSON_BY_ID;
        Person person = jdbcTemplate.queryForObject(sql, new PersonRowMapper(), id);
        return person;
    }

    @Override
    public Address getAddressById(int id) {
        final String sql = Queries.GET_ADDRESS_BY_ID;
        Address address = jdbcTemplate.queryForObject(sql, new AddressRowMapper(), id);
        return address;
    }

    @Override
    public void removePersonById(int id) {
        final String sql = Queries.REMOVE_PERSON_BY_ID;
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void removeAddressById(int id) {
        final String sql = Queries.REMOVE_ADDRESS_BY_ID;
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updatePhone(int idPerson, String newPhone) {
        final String sql = Queries.UPDATE_PHONE;
        jdbcTemplate.update(sql, new Object[] {newPhone, idPerson});
    }

    @Override
    public void updateMail(int idPerson, String newMail) {
        final String sql = Queries.UPDATE_MAIL;
        jdbcTemplate.update(sql, new Object[] {newMail, idPerson});
    }

    @Override
    public void updateExpirationDate(int idPerson, String newExpirationDate) {
        final String sql = Queries.UPDATE_EXPIRATION_DATE;
        jdbcTemplate.update(sql, new Object[] {newExpirationDate, idPerson});
    }

    @Override
    public void updateIdAddress(int idPerson, int newIdAddress) {
        final String sql = Queries.UPDATE_ID_ADDRESS;
        jdbcTemplate.update(sql, new Object[] {newIdAddress, idPerson});
    }

    @Override
    public void updateAddress(int idAddress, Address newAddress) {
        final String sql = Queries.UPDATE_ADDRESS;
        final String street = newAddress.getStreet();
        final String houseNumber = newAddress.getHouseNumber();
        final int flatNumber = newAddress.getFlatNumber();
        final String postalCode = newAddress.getPostalCode();
        final String city = newAddress.getCity();
        final String country = newAddress.getCountry();
        jdbcTemplate.update(sql, new Object[] {street, houseNumber, flatNumber, postalCode, city, country, idAddress});
    }

    @Override
    public void insertAddress(Address address) {
        final String sql = Queries.INSERT_ADDRESS;
        final String street = address.getStreet();
        final String houseNumber = address.getHouseNumber();
        final int flatNumber = address.getFlatNumber();
        final String postalCode = address.getPostalCode();
        final String city = address.getCity();
        final String country = address.getCountry();
        jdbcTemplate.update(sql, new Object[] {street, houseNumber, flatNumber, postalCode, city, country});
    }

    @Override
    public void insertPerson(Person person, Address address) {
        final String sql = Queries.INSERT_ADDRESS_AND_PERSON;

        final String street = address.getStreet();
        final String houseNumber = address.getHouseNumber();
        final int flatNumber = address.getFlatNumber();
        final String postalCode = address.getPostalCode();
        final String city = address.getCity();
        final String country = address.getCountry();

        final String name = person.getName();
        final String surname = person.getSurname();
        final String dateOfBirth = person.getDateOfBirth();
        final String sex = person.getSex();
        final String phone = person.getPhone();
        final String mail = person.getMail();
        final String expirationDate = person.getExpirationDate();

        jdbcTemplate.update(sql, new Object[] {street, houseNumber, flatNumber, postalCode, city, country,
                name, surname, dateOfBirth, sex, phone, mail, expirationDate});
    }

    @Override
    public void insertPerson(Person person) {
        final String sql = Queries.INSERT_PERSON;
        final String name = person.getName();
        final String surname = person.getSurname();
        final String dateOfBirth = person.getDateOfBirth();
        final String sex = person.getSex();
        final String phone = person.getPhone();
        final String mail = person.getMail();
        final String expirationDate = person.getExpirationDate();
        final int idAddress = person.getIdAddress();
        jdbcTemplate.update(sql, new Object[] {name, surname, dateOfBirth, sex, phone, mail, expirationDate, idAddress});
    }
}
