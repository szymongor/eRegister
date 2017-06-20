package com.eregister.PeopleService.DAO.RowMappers;

import com.eregister.PeopleService.Entity.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Karo2 on 2017-05-08.
 */
public class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setIdUser(resultSet.getInt("id_user"));
        person.setName(resultSet.getString("name"));
        person.setSurname(resultSet.getString("surname"));
        person.setDateOfBirth(resultSet.getString("date_of_birth"));
        person.setSex(resultSet.getString("sex"));
        person.setPhone(resultSet.getString("phone"));
        person.setMail(resultSet.getString("mail"));
        person.setExpirationDate(resultSet.getString("expiration_date"));
        person.setIdAddress(resultSet.getInt("id_address"));
        return person;
    }
}
