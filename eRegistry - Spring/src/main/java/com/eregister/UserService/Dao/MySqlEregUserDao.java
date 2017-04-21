package com.eregister.UserService.Dao;

import com.eregister.UserService.Entity.EregUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Szymon on 07.04.2017.
 */
@Repository
@Qualifier("mysql")
public class MySqlEregUserDao implements EregUserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    static class EregUserRowMapper implements RowMapper<EregUser>{

        @Override
        public EregUser mapRow(ResultSet resultSet, int i) throws SQLException {
            EregUser eregUser = new EregUser();
            eregUser.setId(resultSet.getInt("id"));
            eregUser.setLogin(resultSet.getString("login"));
            eregUser.setPassword(resultSet.getString("password"));
            //eregUser.setRoles(resultSet.getString("role"));
            String roles = "ROLE_USER";
            roles+=","+resultSet.getString("role");
            eregUser.setRoles(roles);

            return eregUser;
        }
    }

    @Override
    public Collection<EregUser> getAllEregUsers() {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT * FROM users";
        List<EregUser> eregUsers = jdbcTemplate.query(sql, new EregUserRowMapper());
        return eregUsers;
    }

    @Override
    public EregUser getEregUserById(int id) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT * FROM users where id = ?";
        EregUser student = jdbcTemplate.queryForObject(sql, new EregUserRowMapper(), id);
        return student;
    }

    @Override
    public EregUser getEregUserByLogin(String login){
        final String sql = "SELECT * FROM users where login = ?";
        EregUser student = jdbcTemplate.queryForObject(sql, new EregUserRowMapper(), login);
        return student;
    }

    @Override
    public void removeEregUserById(int id) {
        final String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateEregStudent(EregUser eregUser) {
        // UPDATE table_name
        // SET column1=value, column2=value2,...
        // WHERE some_column=some_value
        final String sql = "UPDATE users SET login = ?, password = ?, role = ? WHERE id = ?";
        final int id = eregUser.getId();
        final String login = eregUser.getLogin();
        final String password = eregUser.getPassword();
        final String roles = eregUser.getRoles();
        jdbcTemplate.update(sql, new Object[]{login, password, roles, id});
    }

    @Override
    public void insertEregStudent(EregUser eregUser) {
        // INSERT INTO table_name (column1, column2, column3,...)
        // VALUES (value1, value2, value3,...)
        final String sql = "INSERT INTO users (login, password, role) VALUES (?, ?, ?)";
        final String login = eregUser.getLogin();
        final String password = eregUser.getPassword();
        final String roles = eregUser.getRoles();
        jdbcTemplate.update(sql, new Object[]{login, password, roles});
    }
}
