package com.eregister.GroupsService.DAO;

/**
 * Created by Karo2 on 2017-05-17.
 */
public class Queries {
    static final String GET_ALL_GROUPS_BY_TEACHER = "SELECT id_teacher, id_group, GROUPS.name group_name " +
            "from LESSONS LEFT JOIN GROUPS ON id_group = GROUPS.id where id_teacher = ?";
    static final String GET_ALL_STUDENTS_FROM_GROUP = "SELECT id_group, GROUPS.name group_name, id_student, " +
            "student_name, student_surname  from BELONGS " +
            "LEFT JOIN GROUPS ON GROUPS.id=id_group " +
            "LEFT JOIN (SELECT STUDENTS.id studentId, name student_name, surname student_surname " +
            "from PEOPLE, STUDENTS where id_person = PEOPLE.id) student ON stud.studentID = id_student " +
            "where id_group = 6";

}
