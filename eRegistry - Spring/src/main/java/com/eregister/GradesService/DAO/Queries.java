package com.eregister.GradesService.DAO;

/**
 * Created by Karo2 on 2017-06-08.
 */
public class Queries {
    static final String GET_MY_GRADES = "SELECT PARTIAL_GRADES.*, SUBJECTS.name subject_name from PARTIAL_GRADES, LESSONS " +
            "LEFT JOIN SUBJECTS ON LESSONS.id_subject = SUBJECTS.id " +
            "where id_student = (SELECT STUDENTS.id from STUDENTS, USERS where STUDENTS.id_person = USERS.id_person and USERS.id = ?) " +
            "and LESSONS.id = id_lesson";
    // get group grades / lesson grades / for teacher get grades of all students ?????
}
