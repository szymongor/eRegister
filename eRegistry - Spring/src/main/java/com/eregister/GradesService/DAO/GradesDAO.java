package com.eregister.GradesService.DAO;

import com.eregister.GradesService.Entity.Grade;

import java.util.Collection;

/**
 * Created by Karo2 on 2017-06-11.
 */
public interface GradesDAO {
    Collection<Grade> getAllUserPartialGrades(int idEregUser);

    Collection<Grade> getAllUserPartialGradesFromLesson(int idEregUser, int idLesson);

    Collection<Grade> getAllUserSemifinalGrades(int idEregUser);

    Collection<Grade> getAllUserSemifinalGradesFromLesson(int idEregUser, int idLesson);

    Collection<Grade> getAllUserFinalGrades(int idEregUser);

    Collection<Grade> getAllUserFinalGradesFromLesson(int idEregUser, int idLesson);
}
