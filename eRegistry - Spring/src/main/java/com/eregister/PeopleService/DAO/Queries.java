package com.eregister.PeopleService.DAO;

/**
 * Created by Karo2 on 2017-05-07.
 */
public class Queries {

    static final String GET_ALL_PEOPLE = "SELECT * from PEOPLE";

    static final String GET_ALL_CHILD = "SELECT * from PEOPLE where " +
            "PEOPLE.id in (SELECT STUDENTS.id_person from STUDENTS where " +
            "STUDENTS.id in (SELECT id_student from CARES where " +
            "id_guardian = (SELECT id from GUARDIANS where id_person=?)))";

    static final String GET_PERSON_BY_ID = "SELECT * from PEOPLE where id=?";

    static final String GET_ADDRESS_BY_ID = "SELECT * from ADDRESSES where id=?";

    static final String REMOVE_PERSON_BY_ID = "DELETE from PEOPLE WHERE id = ?";

    static final String REMOVE_ADDRESS_BY_ID = "DELETE from ADDRESSES WHERE id = ?";

    static final String UPDATE_PHONE = "UPDATE PEOPLE set phone = ? WHERE id=?";

    static final String UPDATE_MAIL = "UPDATE PEOPLE set mail= ? WHERE id=?";

    static final String UPDATE_EXPIRATION_DATE = "UPDATE PEOPLE set expiration_date= ? WHERE id=?";

    static final String UPDATE_ID_ADDRESS = "UPDATE PEOPLE set id_address = ? WHERE id=?";

    static final String UPDATE_ADDRESS = "UPDATE ADDRESSES set street = ?, house_number = ?, flat_number = ?, " +
            "postal_code = ?, city = ?, country = ? WHERE id=?";

    static final String INSERT_ADDRESS = "INSERT INTO ADDRESSES (street, house_number, flat_number, postal_code, " +
            "city, country) VALUES (?, ?, ?, ?, ?, ?)";

    static final String INSERT_PERSON = "INSERT INTO PEOPLE (name, surname, date_of_birth, sex, phone, mail, " +
            "expiration_date, id_address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    static final String INSERT_ADDRESS_AND_PERSON = "INSERT INTO ADDRESSES " +
            "(street, house_number, flat_number, postal_code, city, country) VALUES (?, ?, ?, ?, ?, ?);" +
            "INSERT INTO PEOPLE ( name, surname, date_of_birth, sex, phone, mail, expiration_date, id_address) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, LAST_INSERT_ID());";
}
