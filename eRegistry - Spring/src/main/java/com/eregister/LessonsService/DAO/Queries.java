package com.eregister.LessonsService.DAO;

import com.eregister.LessonsService.Entity.Lesson;

import java.util.Collection;

/**
 * Created by Karo2 on 2017-04-30.
 */
public class Queries {
    static final String GET_ALL_LESSONS = "SELECT * from LESSONS;";
    static final String GET_LESSONS_LEADS_BY_TEACHER = "SELECT * from LESSONS where id_teacher = ?";
    static final String GET_LESSONS_BY_ATTENDING_GROUP = "SELECT * from LESSONS where id_group = ?";
    static final String GET_LESSONS_ABOUT_SUBJECT = "SELECT * from LESSONS where id_subject = ?";
    static final String GET_LESSON_BY_ID = "SELECT * from LESSONS where id = ?";
    static final String REMOVE_LESSON_BY_ID = "DELETE from LESSONS where id = ?";
    static final String UPDATE_TEACHER = "UPDATE LESSONS set id_teacher = ? where id = ?";
    static final String UPDATE_SEMESTER = "UPDATE LESSONS set semester = ? where id = ?";
    static final String INSERT_LESSON = "INSERT into LESSONS ( year, semester, id_teacher, id_group, id_subject)" +
            " VALUES (?, ?, ?, ?, ?)";
}
