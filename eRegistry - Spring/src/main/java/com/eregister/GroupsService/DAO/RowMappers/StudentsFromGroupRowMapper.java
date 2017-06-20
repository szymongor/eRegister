package com.eregister.GroupsService.DAO.RowMappers;

import com.eregister.PeopleService.Entity.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Karo2 on 2017-06-08.
 */
public class StudentsFromGroupRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id_student"));
        person.setIdUser(resultSet.getInt("id_user"));
        person.setName(resultSet.getString("student_name"));
        person.setSurname(resultSet.getString("student_surname"));
        return person;
    }
}
