package com.eregister.GroupsService.DAO;

import com.eregister.GroupsService.DAO.RowMappers.ClassRowMapper;
import com.eregister.GroupsService.DAO.RowMappers.GroupRowMapper;
import com.eregister.GroupsService.DAO.RowMappers.StudentsFromGroupRowMapper;
import com.eregister.GroupsService.Entity.Class;
import com.eregister.GroupsService.Entity.Group;
import com.eregister.PeopleService.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Karo2 on 2017-05-17.
 */

@Repository
@Qualifier("mysql")
public class MySqlGroupsDAO implements GroupsDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Collection<Group> getAllGroupsTeachByUser(int idEregUser) {
        String sql = Queries.GET_ALL_GROUPS_TEACH_BY_USER;
        Collection<Group> groups = jdbcTemplate.query(sql, new GroupRowMapper(), idEregUser);
        return groups;
    }

    @Override
    public Collection<Person> getAllStudentsFromGroup(int idGroup) {
        String sql = Queries.GET_ALL_STUDENTS_FROM_GROUP;
        Collection<Person> studentsFromGroup = jdbcTemplate.query(sql, new StudentsFromGroupRowMapper(), idGroup);
        return studentsFromGroup;
    }

    @Override
    public Class getUserClass(int idEregUser) {
        String sql = Queries.GET_USER_CLASS;
        Class groupClass = jdbcTemplate.queryForObject(sql, new ClassRowMapper(), idEregUser);
        return groupClass;
    }
}
