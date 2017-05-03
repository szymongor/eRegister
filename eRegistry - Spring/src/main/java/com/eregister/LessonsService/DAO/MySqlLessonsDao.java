package com.eregister.LessonsService.DAO;

import com.eregister.LessonsService.DAO.RowMappers.LessonRowMapper;
import com.eregister.LessonsService.Entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Collection;
import java.util.List;

/**
 * Created by Karo2 on 2017-04-30.
 */
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
    public Collection<Lesson> getLessonsLeadsByTeacher(int idTeacher) {
        final String sql = Queries.GET_LESSONS_LEADS_BY_TEACHER;
        List<Lesson> lessons = jdbcTemplate.query(sql, new LessonRowMapper(), idTeacher);
        return lessons;
    }

    @Override
    public Collection<Lesson> getLessonsByAttendingGroup(int idGroup) {
        final String sql = Queries.GET_LESSONS_BY_ATTENDING_GROUP;
        List<Lesson> lessons = jdbcTemplate.query(sql, new LessonRowMapper(), idGroup);
        return lessons;
    }

    @Override
    public Collection<Lesson> getLessonsAboutSubject(int idSubject) {
        final String sql = Queries.GET_ALL_LESSONS;
        List<Lesson> lessons = jdbcTemplate.query(sql, new LessonRowMapper(), idSubject);
        return lessons;
    }

    @Override
    public Lesson getLessonById(int id) {
        final String sql = Queries.GET_LESSON_BY_ID;
        Lesson lesson = jdbcTemplate.queryForObject(sql, new LessonRowMapper(), id);
        return lesson;
    }

    @Override
    public void removeLessonById(int id) {
        final String sql = Queries.REMOVE_LESSON_BY_ID;
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateTeacher(int id_teacher, int id) {
        final String sql = Queries.UPDATE_TEACHER;
        jdbcTemplate.update(sql, new Object[] {id_teacher, id});
    }

    @Override
    public void updateSemester(String semester, int id) {
        final String sql = Queries.UPDATE_SEMESTER;
        jdbcTemplate.update(sql, new Object[] {semester, id});
    }

    @Override
    public void insertLesson(Lesson lesson) {
//      "INSERT into LESSONS ( year, semester, id_teacher, id_group, id_subject)...";
        final String sql = Queries.INSERT_LESSON;
        final String year = lesson.getYear();
        final String semester = lesson.getSemester();
        final int id_teacher = lesson.getIdTeacher();
        final int id_group = lesson.getIdGroup();
        final int id_subject = lesson.getIdSubject();
        jdbcTemplate.update(sql, new Object[] {year, semester, id_teacher, id_group, id_subject});
    }
}
