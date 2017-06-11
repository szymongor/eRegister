package com.eregister.GradesService.DAO.RowMappers;

import com.eregister.GradesService.Entity.Grade;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Karo2 on 2017-06-11.
 */
public class GradeRowMapper implements RowMapper<Grade> {
    @Override
    public Grade mapRow(ResultSet resultSet, int i) throws SQLException {
        Grade grade = new Grade();
        grade.setId(resultSet.getInt("id"));
        grade.setMark(resultSet.getString("mark"));
        grade.setWeight(resultSet.getInt("weight"));
        grade.setDescription(resultSet.getString("description"));
        grade.setDate(resultSet.getString("date"));
        grade.setIdStudent(resultSet.getInt("id_student"));
        grade.setIdLesson(resultSet.getInt("id_lesson"));
        grade.setSubjectName(resultSet.getString("subject_name"));
        return grade;
    }
}
