package com.eregister.GradesService.DAO;

import com.eregister.GradesService.Entity.Grade;
import com.eregister.GradesService.Model.InsertFinalGrade;
import com.eregister.GradesService.Model.InsertPartialGrade;

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

    void removePartialGradeById(int idGrade);

    void removeSemifinalGradeById(int idGrade);

    void removeFinalGradeById(int idGrade);

    void updatePartialGrade(String mark, int weight, String description, String date, int idGrade);

    void updateSemifinalGrade(String mark, String date, int idGrade);

    void updateFinalGrade(String mark, String date, int idGrade);

    void insertPartialGrade(InsertPartialGrade insertPartialGrade);

    void insertSemifinalGrade(InsertFinalGrade insertFinalGrade);

    void insertFinalGrade(InsertFinalGrade insertFinalGrade);
}
