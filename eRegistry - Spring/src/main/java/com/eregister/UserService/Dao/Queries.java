package com.eregister.UserService.Dao;

/**
 * Created by Karo2 on 2017-04-27.
 */
public class Queries {
    static final String GET_ALL_EREG_USERS = "SELECT * FROM USERS";
    static final String GET_ALL_ENABLE_EREG_USERS = "SELECT * FROM USERS where enabled = 1";
    static final String GET_ALL_TEACHERS_EREG_USERS = "SELECT USERS.id, login, password, last_password_reset_date, " +
            "enabled FROM USERS, TEACHERS where USERS.id_person = TEACHERS.id_person";
    static final String GET_ALL_GUARDIANS_EREG_USERS = "SELECT USERS.id, login, password, last_password_reset_date, " +
            "enabled FROM USERS, GUARDIANS where USERS.id_person = GUARDIANS.id_person";
    static final String GET_ALL_STUDENTS_EREG_USERS = "SELECT USERS.id, login, password, last_password_reset_date, " +
            "enabled FROM USERS, STUDENTS where USERS.id_person = STUDENTS.id_person";
    static final String GET_EREG_USER_BY_ID = "SELECT * FROM USERS where id = ?";
    static final String GET_EREG_USER_BY_ID_PERSON = "SELECT * FROM USERS where id_person = ?";
    static final String GET_EREG_USER_BY_LOGIN = "SELECT * FROM USERS where login = ?";
    static final String REMOVE_EREG_USER_BY_ID = "DELETE FROM USERS WHERE id = ?";
    static final String UPDATE_EREG_USER = "UPDATE USERS SET login = ?, password = ? WHERE id = ?";
    static final String INSERT_EREG_USER = "INSERT INTO USERS (login, password) VALUES (?, ?, ?)"; // ZMIENIĆ !!!!!
}
