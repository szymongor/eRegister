package com.eregister.PeopleService.DAO.RowMappers;

import com.eregister.PeopleService.Entity.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Karo2 on 2017-05-09.
 */
public class AddressRowMapper implements RowMapper<Address> {
    
    @Override
    public Address mapRow(ResultSet resultSet, int i) throws SQLException {
        Address address = new Address();
        address.setId(resultSet.getInt("id"));
        address.setStreet(resultSet.getString("street"));
        address.setHouseNumber(resultSet.getString("house_number"));
        address.setFlatNumber(resultSet.getInt("flat_number"));
        address.setPostalCode(resultSet.getString("postal_code"));
        address.setCity(resultSet.getString("city"));
        address.setCountry(resultSet.getString("country"));
        return null;
    }
}
