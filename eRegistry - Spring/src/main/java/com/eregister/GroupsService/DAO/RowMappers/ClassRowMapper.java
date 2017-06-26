package com.eregister.GroupsService.DAO.RowMappers;

import com.eregister.GroupsService.Entity.Class;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Karo2 on 2017-06-26.
 */
public class ClassRowMapper implements RowMapper<Class> {
    @Override
    public Class mapRow(ResultSet resultSet, int i) throws SQLException {
        Class groupClass = new Class();
        groupClass.setName(resultSet.getString("class_name"));
        groupClass.setProfile(resultSet.getString("profile"));
        groupClass.setIdTutor(resultSet.getInt("tutor_id"));
        groupClass.setTutorName(resultSet.getString("tutor_name"));
        groupClass.setTutorSurname(resultSet.getString("tutor_surname"));
        return groupClass;
    }
}
