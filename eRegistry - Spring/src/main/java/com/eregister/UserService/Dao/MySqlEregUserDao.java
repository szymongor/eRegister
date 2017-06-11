package com.eregister.UserService.Dao;

import com.eregister.UserService.Dao.RowMappers.EregUserRowMapper;
import com.eregister.UserService.Dao.RowMappers.GuardianRowMapper;
import com.eregister.UserService.Dao.RowMappers.StudentRowMapper;
import com.eregister.UserService.Dao.RowMappers.TeacherRowMappper;
import com.eregister.UserService.Entity.EregUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
        List<EregUser> eregUsers = jdbcTemplate.query(sql, new TeacherRowMappper());
        return eregUsers;
    }

    @Override
    public Collection<EregUser> getAllGuardiansEregUsers() {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = Queries.GET_ALL_GUARDIANS_EREG_USERS;
        List<EregUser> eregUsers = jdbcTemplate.query(sql, new GuardianRowMapper());
        return eregUsers;
    }

    @Override
    public Collection<EregUser> getAllStudentsEregUsers() {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = Queries.GET_ALL_STUDENTS_EREG_USERS;
        List<EregUser> eregUsers = jdbcTemplate.query(sql, new StudentRowMapper());
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
    public EregUser getEregUserByLogin(String login) {
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
    public void removeEregUserByLogin(String login) {
        final String sql = Queries.REMOVE_EREG_USER_BY_LOGIN;
        jdbcTemplate.update(sql, login);
    }

    @Override
    public void updatePasswordEregUser(String newPassword, String login, String oldPassword) {
        final String sql = Queries.UPDATE_PASSWORD_EREG_USER;
        jdbcTemplate.update(sql, new Object[]{newPassword, login, oldPassword});
    }

    @Override
    public void insertEregUser(EregUser eregUser) {
        // INSERT INTO table_name (column1, column2, column3,...)
        // VALUES (value1, value2, value3,...)
        final String sql = Queries.INSERT_EREG_USER;
        final String login = eregUser.getLogin();
        final String password = eregUser.getPassword();
        final String last_password_reset_date = eregUser.getLastPasswordResetDate();
        final Boolean enabled = eregUser.getEnable();
        final int id_person = eregUser.getIdPerson();
        jdbcTemplate.update(sql, new Object[]{login, password, last_password_reset_date, enabled, id_person});
    }
}
