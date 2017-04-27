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
            eregUser.addRole("TEACHER");
            eregUser.addRole("USER");
            eregUser.setLastPasswordResetDate(resultSet.getString("last_password_reset_date"));
            eregUser.setEnable(resultSet.getBoolean("enabled"));
            return eregUser;
        }
    }

    @Override
    public Collection<EregUser> getAllEregUsers() {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = Queries.GET_ALL_EREG_USERS;
        List<EregUser> eregUsers = jdbcTemplate.query(sql, new EregUserRowMapper());
        return eregUsers;
    }

    @Override
    public Collection<EregUser> getAllEnableEregUsers() {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = Queries.GET_ALL_ENABLE_EREG_USERS;
        List<EregUser> eregUsers = jdbcTemplate.query(sql, new EregUserRowMapper());
        return eregUsers;
    }

    @Override
    public Collection<EregUser> getAllTeachersEregUsers() {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = Queries.GET_ALL_TEACHERS_EREG_USERS;
        List<EregUser> eregUsers = jdbcTemplate.query(sql, new EregUserRowMapper());
        return eregUsers;
    }

    @Override
    public Collection<EregUser> getAllGuardiansEregUsers() {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = Queries.GET_ALL_GUARDIANS_EREG_USERS;
        List<EregUser> eregUsers = jdbcTemplate.query(sql, new EregUserRowMapper());
        return eregUsers;
    }

    @Override
    public Collection<EregUser> getAllStudentsEregUsers() {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = Queries.GET_ALL_STUDENTS_EREG_USERS;
        List<EregUser> eregUsers = jdbcTemplate.query(sql, new EregUserRowMapper());
        return eregUsers;
    }

    @Override
    public EregUser getEregUserById(int id) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = Queries.GET_EREG_USER_BY_ID;
        EregUser eregUser = jdbcTemplate.queryForObject(sql, new EregUserRowMapper(), id);
        return eregUser;
    }

    @Override
    public EregUser getEregUserByIdPerson(int id) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = Queries.GET_EREG_USER_BY_ID_PERSON;
        EregUser eregUser = jdbcTemplate.queryForObject(sql, new EregUserRowMapper(), id);
        return eregUser;
    }

    @Override
    public EregUser getEregUserByLogin(String login){
        final String sql = Queries.GET_EREG_USER_BY_LOGIN;
        EregUser eregUser = jdbcTemplate.queryForObject(sql, new EregUserRowMapper(), login);
        return eregUser;
    }

    @Override
    public void removeEregUserById(int id) {
        final String sql = Queries.REMOVE_EREG_USER_BY_ID;
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateEregUser(EregUser eregUser) {
        // UPDATE table_name
        // SET column1=value, column2=value2,...
        // WHERE some_column=some_value
        final String sql = Queries.UPDATE_EREG_USER;
        final int id = eregUser.getId();
        final String login = eregUser.getLogin();
        final String password = eregUser.getPassword();
        jdbcTemplate.update(sql, new Object[]{login, password, id});
    }

    @Override
    public void insertEregUser(EregUser eregUser) {
        // INSERT INTO table_name (column1, column2, column3,...)
        // VALUES (value1, value2, value3,...)
        final String sql = Queries.INSERT_EREG_USER;
        final String login = eregUser.getLogin();
        final String password = eregUser.getPassword();
        jdbcTemplate.update(sql, new Object[]{login, password});
    }
}
