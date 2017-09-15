package com.eregister.GroupsService.DAO;

/**
 * Created by Karo2 on 2017-05-17.
 */
public class Queries {//phonr i mail
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
    static final String GET_STUDENT_CLASS = "SELECT CLASSES.name class_name, CLASSES.profile profile, " +
            "CLASSES.id_teacher tutor_id, tutor_name, tutor_surname, tutor_phone, tutor_mail from BELONGS " +
            "INNER JOIN CLASSES ON BELONGS.id_group = CLASSES.id_group " +
            "INNER JOIN (SELECT TEACHERS.id tutor_id, name tutor_name, surname tutor_surname, phone tutor_phone, mail tutor_mail " +
            "from PEOPLE, TEACHERS where TEACHERS.id_person = PEOPLE.id) tutor ON id_teacher = tutor.tutor_id " +
            "and id_student = (SELECT STUDENTS.id from STUDENTS where STUDENTS.id_person = (SELECT USERS.id_person from USERS " +
            "where USERS.id = ?))";
    static final String GET_TEACHER_CLASS = "SELECT CLASSES.name class_name, CLASSES.profile profile, CLASSES.id_teacher tutor_id, " +
            "tutor_name, tutor_surname, tutor_phone, tutor_mail from  CLASSES RIGHT JOIN " +
            "(SELECT TEACHERS.id tutor_id, name tutor_name, surname tutor_surname, phone tutor_phone, mail tutor_mail from " +
            "PEOPLE, TEACHERS where TEACHERS.id_person = PEOPLE.id and TEACHERS.id_person = (SELECT USERS.id_person " +
            "from USERS where USERS.id = ?)) tutor ON id_teacher = tutor.tutor_id";
}
