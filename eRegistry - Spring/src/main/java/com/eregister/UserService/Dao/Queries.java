package com.eregister.UserService.Dao;

/**
 * Created by Karo2 on 2017-04-27.
 */
public class Queries {
    static final String GET_ALL_EREG_USERS = "SELECT * FROM USERS LEFT JOIN " +
            "(SELECT * FROM (SELECT STUDENTS.id_person students, GUARDIANS.id_person guardians, " +
            "TEACHERS.id_person teachers FROM STUDENTS LEFT OUTER JOIN " +
            "GUARDIANS ON STUDENTS.id_person = GUARDIANS.id_person " +
            "LEFT OUTER JOIN TEACHERS ON STUDENTS.id_person = TEACHERS.id_person " +
            "UNION " +
            "SELECT STUDENTS.id_person students, GUARDIANS.id_person guardians, TEACHERS.id_person teachers " +
            "FROM GUARDIANS " +
            "LEFT OUTER JOIN STUDENTS ON STUDENTS.id_person = GUARDIANS.id_person " +
            "LEFT OUTER JOIN TEACHERS ON GUARDIANS.id_person = TEACHERS.id_person " +
            "UNION " +
            "SELECT STUDENTS.id_person students, GUARDIANS.id_person guardians, TEACHERS.id_person teachers " +
            "FROM TEACHERS " +
            "LEFT OUTER JOIN GUARDIANS ON TEACHERS.id_person = GUARDIANS.id_person " +
            "LEFT OUTER JOIN STUDENTS ON STUDENTS.id_person = TEACHERS.id_person) role " +
            ") role " +
            "ON USERS.id_person = role.students " +
            "OR USERS.id_person = role.guardians " +
            "OR USERS.id_person = role.teachers ";
    static final String GET_ALL_ENABLE_EREG_USERS = GET_ALL_EREG_USERS + "where enabled = 1";
    static final String GET_ALL_TEACHERS_EREG_USERS = "SELECT USERS.id, login, password, last_password_reset_date, " +
            "enabled FROM USERS, TEACHERS where USERS.id_person = TEACHERS.id_person";
    static final String GET_ALL_GUARDIANS_EREG_USERS = "SELECT USERS.id, login, password, last_password_reset_date, " +
            "enabled FROM USERS, GUARDIANS where USERS.id_person = GUARDIANS.id_person";
    static final String GET_ALL_STUDENTS_EREG_USERS = "SELECT USERS.id, login, password, last_password_reset_date, " +
            "enabled FROM USERS, STUDENTS where USERS.id_person = STUDENTS.id_person";
    static final String GET_EREG_USER_BY_ID = GET_ALL_EREG_USERS + "where USERS.id = ?";
    static final String GET_EREG_USER_BY_ID_PERSON = GET_ALL_ENABLE_EREG_USERS + "where USERS.id_person = ?";
    static final String GET_EREG_USER_BY_LOGIN = GET_ALL_EREG_USERS + "WHERE USERS.login = ?";
    static final String REMOVE_EREG_USER_BY_ID = "DELETE FROM USERS WHERE id = ?";
    static final String REMOVE_EREG_USER_BY_LOGIN = "DELETE from USERS where login = ?";
    static final String UPDATE_PASSWORD_EREG_USER = "UPDATE USERS SET password = ? WHERE login = ? AND password = ?";
    static final String INSERT_EREG_USER = "INSERT INTO USERS (login, password, last_password_reset_date, enabled, " +
            "id_person) VALUES (?, ?, ?, ?, ?)";
}
