package com.eregister.UserService.Dao.RowMappers;

import com.eregister.UserService.Entity.EregUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Karo2 on 2017-04-27.
 */
public class GuardianRowMapper implements RowMapper<EregUser> {

    @Override
    public EregUser mapRow(ResultSet resultSet, int i) throws SQLException {
        EregUser eregUser = new EregUser();
        eregUser.setId(resultSet.getInt("id"));
        eregUser.setLogin(resultSet.getString("login"));
        eregUser.setPassword(resultSet.getString("password"));
        eregUser.addRole("GUARDIAN");
        eregUser.setLastPasswordResetDate(resultSet.getString("last_password_reset_date"));
        eregUser.setEnable(resultSet.getBoolean("enabled"));
        eregUser.setIdPerson(resultSet.getInt("id_person"));
        return eregUser;
    }
}
