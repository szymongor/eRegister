package com.eregister.PeopleService.DAO.RowMappers;

import com.eregister.PeopleService.Entity.PersonalData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Szymon on 05.06.2017.
 */
public class PersonalDataRowMapper implements RowMapper<PersonalData> {

    @Override
    public PersonalData mapRow(ResultSet resultSet, int i) throws SQLException {
        PersonalData personalData = new PersonalData();
        personalData.setIdPerson(resultSet.getInt("PEOPLE.id"));
        personalData.setName(resultSet.getString("name"));
        personalData.setSurname(resultSet.getString("surname"));
        personalData.setDateOfBirth(resultSet.getString("date_of_birth"));
        personalData.setSex(resultSet.getString("sex"));
        personalData.setPhone(resultSet.getString("phone"));
        personalData.setMail(resultSet.getString("mail"));
        personalData.setExpirationDate(resultSet.getString("expiration_date"));
        personalData.setIdAddress(resultSet.getInt("id_address"));
        personalData.setStreet(resultSet.getString("street"));
        personalData.setHouseNumber(resultSet.getString("house_number"));
        personalData.setFlatNumber(resultSet.getInt("flat_number"));
        personalData.setPostalCode(resultSet.getString("postal_code"));
        personalData.setCity(resultSet.getString("city"));
        personalData.setCountry(resultSet.getString("country"));
        return personalData;
    }
}
