package com.eregister.GradesService.DAO;

import com.eregister.GradesService.DAO.RowMappers.GradeRowMapper;
import com.eregister.GradesService.Entity.Grade;
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
}
