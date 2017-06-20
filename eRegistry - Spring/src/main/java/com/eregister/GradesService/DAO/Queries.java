package com.eregister.GradesService.DAO;

/**
 * Created by Karo2 on 2017-06-08.
 */
public class Queries {
    static final String PARTIAL_GRADES = "SELECT PARTIAL_GRADES.*, SUBJECTS.name subject_name from PARTIAL_GRADES, ";
    static final String SEMIFINAL_GRADES = "SELECT SEMIFINAL_GRADES.*, SUBJECTS.name subject_name from SEMIFINAL_GRADES, ";
    static final String FINAL_GRADES = "SELECT FINAL_GRADES.*, SUBJECTS.name subject_name from FINAL_GRADES, ";

    static final String GET_GRADES_BY_ID_USER = " LESSONS LEFT JOIN SUBJECTS ON LESSONS.id_subject = SUBJECTS.id " +
            "where id_student = (SELECT STUDENTS.id from STUDENTS, USERS " +
            "where STUDENTS.id_person = USERS.id_person and USERS.id = ?) and LESSONS.id = id_lesson ";
    static final String ORDER_BY_LESSON_ID = "ORDER BY id_lesson";

    static final String GET_SORT_PARTIAL_GRADES_BY_ID_USER = PARTIAL_GRADES + GET_GRADES_BY_ID_USER + ORDER_BY_LESSON_ID;
    static final String GET_SORT_PARTIAL_GRADES_BY_ID_USER_AND_ID_LESSON = PARTIAL_GRADES + GET_GRADES_BY_ID_USER +
            "and id_lesson = ? " + ORDER_BY_LESSON_ID;

    static final String GET_SORT_SEMIFINAL_GRADES_BY_ID_USER = SEMIFINAL_GRADES + GET_GRADES_BY_ID_USER + ORDER_BY_LESSON_ID;
    static final String GET_SORT_SEMIFINAL_GRADES_BY_ID_USER_AND_ID_LESSON = SEMIFINAL_GRADES + GET_GRADES_BY_ID_USER +
            "and id_lesson = ? " + ORDER_BY_LESSON_ID;

    static final String GET_SORT_FINAL_GRADES_BY_ID_USER = FINAL_GRADES + GET_GRADES_BY_ID_USER + ORDER_BY_LESSON_ID;
    static final String GET_SORT_FINAL_GRADES_BY_ID_USER_AND_ID_LESSON = FINAL_GRADES + GET_GRADES_BY_ID_USER +
            "and id_lesson = ? " + ORDER_BY_LESSON_ID;

    static final String REMOVE_PARTIAL_GRADE_BY_ID = "DELETE from PARTIAL_GRADES where id = ?";
    static final String REMOVE_SEMIFINAL_GRADE_BY_ID = "DELETE from SEMIFINAL_GRADES where id = ?";
    static final String REMOVE_FINAL_GRADE_BY_ID = "DELETE from FINAL_GRADES where id = ?";

    static final String UPDATE_PARTIAL_GRADE = "UPDATE PARTIAL_GRADES SET mark = ?, weight = ?, description = ?, " +
            "date = ? WHERE id = ?";
    static final String UPDATE_SEMIFINAL_GRADE = "UPDATE SEMIFINAL_GRADES SET mark = ?, date = ? WHERE id = ?";
    static final String UPDATE_FINAL_GRADE = "UPDATE FINAL_GRADES SET mark = ?, date = ? WHERE id = ?";

    static final String INSERT_PARTIAL_GRADE = "INSERT INTO PARTIAL_GRADES (mark, weight, description, date, " +
            "id_student, id_lesson) VALUES (?, ?, ?, ?, ?, ?)";
    static final String INSERT_SEMIFINAL_GRADE = "INSERT INTO SEMIFINAL_GRADES (mark, date, id_student, id_lesson) " +
            "VALUES (?, ?, ?, ?)";
    static final String INSERT_FINAL_GRADE = "INSERT INTO FINAL_GRADES (mark, date, id_student, id_lesson) " +
            "VALUES (?, ?, ?, ?)";
}
