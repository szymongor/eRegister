package com.eregister.LessonsService.DAO;

import com.eregister.LessonsService.DAO.RowMappers.LessonRowMapper;
import com.eregister.LessonsService.Entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by Karo2 on 2017-04-30.
 */

@Repository
@Qualifier("mysql")
public class MySqlLessonsDao implements LessonsDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Collection<Lesson> getAllLessons() {
        final String sql = Queries.GET_ALL_LESSONS;
        List<Lesson> lessons = jdbcTemplate.query(sql, new LessonRowMapper());
        return lessons;
    }

    @Override
    public Collection<Lesson> getLessonsLeadsByTeacher(int idEregUser) {
        final String sql = Queries.GET_LESSONS_LEADS_BY_TEACHER;
        List<Lesson> lessons = jdbcTemplate.query(sql, new LessonRowMapper(), idEregUser);
        return lessons;
    }

    @Override
    public Collection<Lesson> getLessonsByAttendingGroup(int idGroup) {
        final String sql = Queries.GET_LESSONS_BY_ATTENDING_GROUP;
        List<Lesson> lessons = jdbcTemplate.query(sql, new LessonRowMapper(), idGroup);
        return lessons;
    }

    @Override
    public Collection<Lesson> getAllStudentLessons(int idEregUser) {
        final String sql = Queries.GET_ALL_STUDENT_LESSONS;
        List<Lesson> lessons = jdbcTemplate.query(sql, new LessonRowMapper(), idEregUser);
        return lessons;
    }

    @Override
    public void removeLessonById(int id) {
        final String sql = Queries.REMOVE_LESSON_BY_ID;
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateTeacher(int idTeacher, int idLesson) {
        final String sql = Queries.UPDATE_TEACHER;
        jdbcTemplate.update(sql, new Object[]{idTeacher, idLesson});
    }

    @Override
    public void updateSemester(String semester, int idLesson) {
        final String sql = Queries.UPDATE_SEMESTER;
        jdbcTemplate.update(sql, new Object[]{semester, idLesson});
    }

    @Override
    public void insertLesson(Lesson lesson) {
//      "INSERT into LESSONS ( year, semester, id_teacher, id_group, id_subject)...";
        final String sql = Queries.INSERT_LESSON;
        final String year = lesson.getYear();
        final String semester = lesson.getSemester();
        final int idTeacher = lesson.getIdTeacher();
        final int idGroup = lesson.getIdGroup();
        final int idSubject = lesson.getIdSubject();
        jdbcTemplate.update(sql, new Object[]{year, semester, idTeacher, idGroup, idSubject});
    }
}
