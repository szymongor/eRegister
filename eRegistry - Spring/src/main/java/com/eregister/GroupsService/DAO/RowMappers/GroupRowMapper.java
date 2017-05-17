package com.eregister.GroupsService.DAO.RowMappers;

import com.eregister.GroupsService.Entity.Group;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Karo2 on 2017-05-17.
 */
public class GroupRowMapper implements RowMapper<Group> {
    @Override
    public Group mapRow(ResultSet resultSet, int i) throws SQLException {
        Group group = new Group();
        group.setId(resultSet.getInt("id_group"));
        group.setName(resultSet.getString("group_name"));
        return group;
    }
}
