package com.eregister.GradesService.DAO;

import com.eregister.GradesService.DAO.RowMappers.GradeRowMapper;
import com.eregister.GradesService.Entity.Grade;
import com.eregister.GradesService.Model.InsertFinalGrade;
import com.eregister.GradesService.Model.InsertPartialGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Karo2 on 2017-06-11.
 */

@Repository
@Qualifier("mysql")
public class MySqlGradesDAO implements GradesDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Collection<Grade> getAllUserPartialGrades(int idEregUser) {
        String sql = Queries.GET_SORT_PARTIAL_GRADES_BY_ID_USER;
        return jdbcTemplate.query(sql, new GradeRowMapper(), idEregUser);
    }

    @Override
    public Collection<Grade> getAllUserPartialGradesFromLesson(int idEregUser, int idLesson) {
        String sql = Queries.GET_SORT_PARTIAL_GRADES_BY_ID_USER_AND_ID_LESSON;
        return jdbcTemplate.query(sql, new GradeRowMapper(), new Object[]{idEregUser, idLesson});
    }

    @Override
    public Collection<Grade> getAllUserSemifinalGrades(int idEregUser) {
        String sql = Queries.GET_SORT_SEMIFINAL_GRADES_BY_ID_USER;
        return jdbcTemplate.query(sql, new GradeRowMapper(), idEregUser);
    }

    @Override
    public Collection<Grade> getAllUserSemifinalGradesFromLesson(int idEregUser, int idLesson) {
        String sql = Queries.GET_SORT_SEMIFINAL_GRADES_BY_ID_USER_AND_ID_LESSON;
        return jdbcTemplate.query(sql, new GradeRowMapper(), new Object[]{idEregUser, idLesson});
    }

    @Override
    public Collection<Grade> getAllUserFinalGrades(int idEregUser) {
        String sql = Queries.GET_SORT_FINAL_GRADES_BY_ID_USER;
        return jdbcTemplate.query(sql, new GradeRowMapper(), idEregUser);
    }

    @Override
    public Collection<Grade> getAllUserFinalGradesFromLesson(int idEregUser, int idLesson) {
        String sql = Queries.GET_SORT_FINAL_GRADES_BY_ID_USER_AND_ID_LESSON;
        return jdbcTemplate.query(sql, new GradeRowMapper(), new Object[]{idEregUser, idLesson});
    }

    @Override
    public void removePartialGradeById(int idGrade) {
        jdbcTemplate.update(Queries.REMOVE_PARTIAL_GRADE_BY_ID, idGrade);
    }

    @Override
    public void removeSemifinalGradeById(int idGrade) {
        jdbcTemplate.update(Queries.REMOVE_SEMIFINAL_GRADE_BY_ID, idGrade);
    }

    @Override
    public void removeFinalGradeById(int idGrade) {
        jdbcTemplate.update(Queries.REMOVE_FINAL_GRADE_BY_ID, idGrade);
    }

    @Override
    public void updatePartialGrade(String mark, int weight, String description, String date, int idGrade) {
        String sql = Queries.UPDATE_PARTIAL_GRADE;
        jdbcTemplate.update(sql, new Object[]{mark, weight, description, date, idGrade});
    }

    @Override
    public void updateSemifinalGrade(String mark, String date, int idGrade) {
        String sql = Queries.UPDATE_SEMIFINAL_GRADE;
        jdbcTemplate.update(sql, new Object[]{mark, date, idGrade});
    }

    @Override
    public void updateFinalGrade(String mark, String date, int idGrade) {
        String sql = Queries.UPDATE_FINAL_GRADE;
        jdbcTemplate.update(sql, new Object[]{mark, date, idGrade});
    }

    @Override
    public void insertPartialGrade(InsertPartialGrade insertPartialGrade) {
        String sql = Queries.INSERT_PARTIAL_GRADE;
        String mark = insertPartialGrade.getMark();
        int weight = insertPartialGrade.getWeight();
        String description = insertPartialGrade.getDescription();
        String date = insertPartialGrade.getDate();
        int idStudent = insertPartialGrade.getIdStudent();
        int idLesson = insertPartialGrade.getIdLesson();
        jdbcTemplate.update(sql, new Object[]{mark, weight, description, date, idStudent, idLesson});
    }

    @Override
    public void insertSemifinalGrade(InsertFinalGrade insertFinalGrade) {
        String sql = Queries.INSERT_SEMIFINAL_GRADE;
        String mark = insertFinalGrade.getMark();
        String date = insertFinalGrade.getDate();
        int idStudent = insertFinalGrade.getIdStudent();
        int idLesson = insertFinalGrade.getIdLesson();
        jdbcTemplate.update(sql, new Object[]{mark, date, idStudent, idLesson});
    }

    @Override
    public void insertFinalGrade(InsertFinalGrade insertFinalGrade) {
        String sql = Queries.INSERT_FINAL_GRADE;
        String mark = insertFinalGrade.getMark();
        String date = insertFinalGrade.getDate();
        int idStudent = insertFinalGrade.getIdStudent();
        int idLesson = insertFinalGrade.getIdLesson();
        jdbcTemplate.update(sql, new Object[]{mark, date, idStudent, idLesson});
    }
}
