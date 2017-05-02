package com.eregister.LessonsService.DAO.RowMappers;

import com.eregister.LessonsService.Entity.Lesson;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Karo2 on 2017-04-30.
 */
public class LessonRowMapper implements RowMapper<Lesson> {

@Override
public Lesson mapRow(ResultSet resultSet, int i) throws SQLException {
        Lesson lesson = new Lesson();
        lesson.setId(resultSet.getInt("id"));
        lesson.setYear(resultSet.getString("year"));
        lesson.setSemester(resultSet.getString("semester"));
        lesson.setIdTeacher(resultSet.getInt("id_teacher"));
        lesson.setIdGroup(resultSet.getInt("id_group"));
        lesson.setIdSubject(resultSet.getInt("id_subject"));
        return lesson;
        }
}
