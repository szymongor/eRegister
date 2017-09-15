package com.eregister.GradesService.DAO.RowMappers;

import com.eregister.GradesService.Entity.Grade;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
        if (hasColumn(resultSet, "weight"))
            grade.setWeight(resultSet.getInt("weight"));
        if (hasColumn(resultSet, "description"))
            grade.setDescription(resultSet.getString("description"));
        grade.setDate(resultSet.getString("date"));
        grade.setIdStudent(resultSet.getInt("id_student"));
        grade.setIdLesson(resultSet.getInt("id_lesson"));
        grade.setSubjectName(resultSet.getString("subject_name"));
        return grade;
    }

    private boolean hasColumn(ResultSet resultSet, String columnName) throws SQLException {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columns = resultSetMetaData.getColumnCount();
        for (int i = 1; i <= columns; i++) {
            if (columnName.equals(resultSetMetaData.getColumnName(i))) {
                return true;
            }
        }
        return false;
    }
}
