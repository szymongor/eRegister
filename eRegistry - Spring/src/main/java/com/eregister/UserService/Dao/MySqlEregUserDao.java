package com.eregister.UserService.Dao;

import com.eregister.UserService.Entity.EregUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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
            eregUser.setRole("ROLE_STUDENT,ROLE_TEACHER");
            eregUser.setLastPasswordResetDate(resultSet.getString("last_password_reset_date"));
            eregUser.setEnable(resultSet.getBoolean("enabled"));
            /*
            String role ="";
            if(resultSet.getInt("students") != 0){
                role += "ROLE_STUDENT";
            }
            if(resultSet.getInt("guardians") != 0){
                role += " | ROLE_GUARDIAN";
            }
            if(resultSet.getInt("teachers") != 0){
                role += " | ROLE_TEACHER";
            }
            */
            return eregUser;
        }
    }

    @Override
    public Collection<EregUser> getAllEregUsers() {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT * FROM USERS";
        List<EregUser> eregUsers = jdbcTemplate.query(sql, new EregUserRowMapper());
        return eregUsers;
    }

    @Override
    public Collection<EregUser> getAllEnableEregUsers() {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT * FROM USERS where enabled = 1";
        List<EregUser> eregUsers = jdbcTemplate.query(sql, new EregUserRowMapper());
        return eregUsers;
    }

    @Override
    public Collection<EregUser> getAllTeachersEregUsers() {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT USERS.id, login, password, last_password_reset_date, enabled FROM USERS, TEACHERS where USERS.id_person = TEACHERS.id_person";
        List<EregUser> eregUsers = jdbcTemplate.query(sql, new EregUserRowMapper());
        return eregUsers;
    }

    @Override
    public Collection<EregUser> getAllGuardiansEregUsers() {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT USERS.id, login, password, last_password_reset_date, enabled FROM USERS, GUARDIANS where USERS.id_person = GUARDIANS.id_person";
        List<EregUser> eregUsers = jdbcTemplate.query(sql, new EregUserRowMapper());
        return eregUsers;
    }

    @Override
    public Collection<EregUser> getAllStudentsEregUsers() {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT USERS.id, login, password, last_password_reset_date, enabled FROM USERS, STUDENTS where USERS.id_person = STUDENTS.id_person";
        List<EregUser> eregUsers = jdbcTemplate.query(sql, new EregUserRowMapper());
        return eregUsers;
    }

    @Override
    public EregUser getEregUserById(int id) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT * FROM USERS where id = ?";
        EregUser eregUser = jdbcTemplate.queryForObject(sql, new EregUserRowMapper(), id);
        return eregUser;
    }

    @Override
    public EregUser getEregUserByIdPerson(int id) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT * FROM USERS where id_person = ?";
        EregUser eregUser = jdbcTemplate.queryForObject(sql, new EregUserRowMapper(), id);
        return eregUser;
    }

    @Override
    public EregUser getEregUserByLogin(String login){
        final String sql = "SELECT * FROM USERS where login = ?";
        EregUser eregUser = jdbcTemplate.queryForObject(sql, new EregUserRowMapper(), login);
        return eregUser;
    }

    @Override
    public void removeEregUserById(int id) {
        final String sql = "DELETE FROM USERS WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateEregStudent(EregUser eregUser) {
        // UPDATE table_name
        // SET column1=value, column2=value2,...
        // WHERE some_column=some_value
        final String sql = "UPDATE USERS SET login = ?, password = ?, role = ? WHERE id = ?";
        final int id = eregUser.getId();
        final String login = eregUser.getLogin();
        final String password = eregUser.getPassword();
        final String role = eregUser.getRole();
        jdbcTemplate.update(sql, new Object[]{login, password, role, id});
    }

    @Override
    public void insertEregStudent(EregUser eregUser) {
        // INSERT INTO table_name (column1, column2, column3,...)
        // VALUES (value1, value2, value3,...)
        final String sql = "INSERT INTO USERS (login, password, role) VALUES (?, ?, ?)";
        final String login = eregUser.getLogin();
        final String password = eregUser.getPassword();
        final String role = eregUser.getRole();
        jdbcTemplate.update(sql, new Object[]{login, password, role});
    }

    @Override
    public Collection<EregUser> myNewTestFunction(boolean isActive) {
        final String sql ="SELECT * FROM USERS where enabled = ?";
        Collection<EregUser> users = jdbcTemplate.query(sql, new EregUserRowMapper(), isActive);
        return users;
    }
}
