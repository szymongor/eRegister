package com.eregister.UserService.Dao.RowMappers;

import com.eregister.UserService.Entity.EregUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Karo2 on 2017-04-27.
 */
public class EregUserRowMapper implements RowMapper<EregUser> {

    @Override
    public EregUser mapRow(ResultSet resultSet, int i) throws SQLException {
        EregUser eregUser = new EregUser();
        eregUser.setId(resultSet.getInt("id"));
        eregUser.setLogin(resultSet.getString("login"));
        eregUser.setPassword(resultSet.getString("password"));
        setRoles(eregUser, resultSet);
//            eregUser.addRole("TEACHER");
//            eregUser.addRole("USER");
        eregUser.setLastPasswordResetDate(resultSet.getString("last_password_reset_date"));
        eregUser.setEnable(resultSet.getBoolean("enabled"));
        return eregUser;
    }

    private void setRoles(EregUser eregUser, ResultSet resultSet) throws SQLException {
        String teacher = resultSet.getString("teachers");
        String student = resultSet.getString("students");
        String guardian = resultSet.getString("guardians");
        //eregUser.addRole(student);
        if(teacher!=null)
            eregUser.addRole("TEACHER");
        if(student!=null)
            eregUser.addRole("STUDENT");
        if(guardian!=null)
            eregUser.addRole("GUARDIAN");
    }
}
