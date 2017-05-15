package com.eregister.LessonsService.DAO;

import com.eregister.LessonsService.Entity.Lesson;

import java.util.Collection;

/**
 * Created by Karo2 on 2017-04-30.
 */
public class Queries {
    static final String GET_ALL_LESSONS = "SELECT LESSONS.id id, LESSONS.year year, semester, id_teacher, teacher_name, " +
            "teacher_surname, id_group, GROUPS.name group_name, id_subject, SUBJECTS.name subject_name from LESSONS " +
            "LEFT JOIN " +
            "(SELECT TEACHERS.id teacher_id, name teacher_name, surname teacher_surname from TEACHERS, PEOPLE " +
            "where id_person = PEOPLE.id) teacher ON id_teacher = teacher.teacher_id " +
            "LEFT JOIN GROUPS ON id_group = GROUPS.id " +
            "LEFT JOIN SUBJECTS ON id_subject = SUBJECTS.id";
    static final String GET_LESSONS_LEADS_BY_TEACHER = GET_ALL_LESSONS + " where id_teacher = ?";
    static final String GET_LESSONS_BY_ATTENDING_GROUP = GET_ALL_LESSONS + " where id_group = ?";
    static final String GET_LESSONS_ABOUT_SUBJECT = GET_ALL_LESSONS + " where id_subject = ?";
    static final String GET_LESSON_BY_ID = GET_ALL_LESSONS + " where LESSONS.id = ?";
    static final String REMOVE_LESSON_BY_ID = "DELETE from LESSONS where id = ?";
    static final String UPDATE_TEACHER = "UPDATE LESSONS set id_teacher = ? where id = ?";
    static final String UPDATE_SEMESTER = "UPDATE LESSONS set semester = ? where id = ?";
    static final String INSERT_LESSON = "INSERT into LESSONS ( year, semester, id_teacher, id_group, id_subject)" +
            " VALUES (?, ?, ?, ?, ?)";
}
