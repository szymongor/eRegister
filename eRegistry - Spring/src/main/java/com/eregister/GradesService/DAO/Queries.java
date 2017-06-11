package com.eregister.GradesService.DAO;

/**
 * Created by Karo2 on 2017-06-08.
 */
public class Queries {
    static final String GET_GRADES_BY_ID_USER = "SELECT PARTIAL_GRADES.*, SUBJECTS.name subject_name " +
            "from PARTIAL_GRADES, LESSONS LEFT JOIN SUBJECTS ON LESSONS.id_subject = SUBJECTS.id " +
            "where id_student = (SELECT STUDENTS.id from STUDENTS, USERS " +
            "where STUDENTS.id_person = USERS.id_person and USERS.id = ?) and LESSONS.id = id_lesson ";
    static final String ORDER_BY_LESSON_ID = "ORDER BY id_lesson";
    static final String GET_SORT_GRADES_BY_ID_USER = GET_GRADES_BY_ID_USER + ORDER_BY_LESSON_ID;
    static final String GET_GRADES_BY_ID_USER_AND_ID_LESSON = GET_GRADES_BY_ID_USER + "and id_lesson = ? " + ORDER_BY_LESSON_ID;
}
