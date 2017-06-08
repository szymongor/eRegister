package com.eregister.GroupsService.DAO;

/**
 * Created by Karo2 on 2017-05-17.
 */
public class Queries {
    static final String GET_ALL_GROUPS_TEACH_BY_USER = "SELECT id_teacher, id_group, GROUPS.name group_name from LESSONS " +
            "INNER JOIN GROUPS ON id_group = GROUPS.id " +
            "and id_teacher = (SELECT TEACHERS.id from TEACHERS " +
            "where id_person = (SELECT id_person from USERS where id = ?))";
    static final String GET_ALL_STUDENTS_FROM_GROUP = "SELECT id_group, GROUPS.name group_name, id_user, id_student, " +
            "student_name, student_surname from BELONGS " +
            "LEFT JOIN GROUPS ON GROUPS.id = id_group " +
            "LEFT JOIN (SELECT STUDENTS.id studentId, USERS.id id_user, name student_name, surname student_surname " +
            "from PEOPLE, STUDENTS " +
            "LEFT JOIN USERS ON STUDENTS.id_person = USERS.id_person " +
            "where STUDENTS.id_person = PEOPLE.id) student ON student.studentID = id_student where id_group = ?";
}
