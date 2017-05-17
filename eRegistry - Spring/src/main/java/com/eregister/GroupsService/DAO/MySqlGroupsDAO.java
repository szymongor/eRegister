package com.eregister.GroupsService.DAO;

import com.eregister.GroupsService.DAO.RowMappers.GroupRowMapper;
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
    public Collection<Group> getAllGroupsByTeacher(int idTeacher) {
        String sql = Queries.GET_ALL_GROUPS_BY_TEACHER;
        Collection<Group> groups = jdbcTemplate.query(sql, new GroupRowMapper(), idTeacher);
        return groups;
    }

    @Override
    public Collection<Person> getAllStudentsFromGroup(int idGroup) {
        return null;
    }
}
