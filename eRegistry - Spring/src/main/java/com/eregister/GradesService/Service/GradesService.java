package com.eregister.GradesService.Service;

import com.eregister.GradesService.DAO.GradesDAO;
import com.eregister.GradesService.Entity.Grade;
import com.eregister.GradesService.Model.InsertFinalGrade;
import com.eregister.GradesService.Model.InsertPartialGrade;
import com.eregister.GradesService.Model.UpdateFinalGrade;
import com.eregister.GradesService.Model.UpdatePartialGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Karo2 on 2017-06-11.
 */
@Service
public class GradesService {

    @Autowired
    @Qualifier("mysql")
    GradesDAO gradesDAO;

    public Collection<Grade> getAllUserPartialGrades(int idEregUser) {
        return gradesDAO.getAllUserPartialGrades(idEregUser);
    }

    public Collection<Grade> getAllUserPartialGradesFromLesson(int idEregUser, int idLesson) {
        return gradesDAO.getAllUserPartialGradesFromLesson(idEregUser, idLesson);
    }

    public Collection<Grade> getAllUserSemifinalGrades(int idEregUser) {
        return gradesDAO.getAllUserSemifinalGrades(idEregUser);
    }

    public Collection<Grade> getAllUserSemifinalGradesFromLesson(int idEregUser, int idLesson) {
        return gradesDAO.getAllUserSemifinalGradesFromLesson(idEregUser, idLesson);
    }

    public Collection<Grade> getAllUserFinalGrades(int idEregUser) {
        return gradesDAO.getAllUserFinalGrades(idEregUser);
    }

    public Collection<Grade> getAllUserFinalGradesFromLesson(int idEregUser, int idLesson) {
        return gradesDAO.getAllUserFinalGradesFromLesson(idEregUser, idLesson);
    }

    public void removePartialGradeById(int idGrade) {
        gradesDAO.removePartialGradeById(idGrade);
    }

    public void removeSemifinalGradeById(int idGrade) {
        gradesDAO.removeSemifinalGradeById(idGrade);
    }

    public void removeFinalGradeById(int idGrade) {
        gradesDAO.removeFinalGradeById(idGrade);
    }

    public void updatePartialGrade(int idGrade, UpdatePartialGrade updatePartialGrade) {
        String mark = updatePartialGrade.getMark();
        int weight = updatePartialGrade.getWeight();
        String description = updatePartialGrade.getDescription();
        String date = updatePartialGrade.getDate();
        gradesDAO.updatePartialGrade(mark, weight, description, date, idGrade);
    }

    public void updateSemifinalGrade(int idGrade, UpdateFinalGrade updateFinalGrade) {
        String mark = updateFinalGrade.getMark();
        String date = updateFinalGrade.getDate();
        gradesDAO.updateSemifinalGrade(mark, date, idGrade);
    }

    public void updateFinalGrade(int idGrade, UpdateFinalGrade updateFinalGrade) {
        String mark = updateFinalGrade.getMark();
        String date = updateFinalGrade.getDate();
        gradesDAO.updateFinalGrade(mark, date, idGrade);
    }

    public void insertPartialGrade(InsertPartialGrade insertPartialGrade) {
        gradesDAO.insertPartialGrade(insertPartialGrade);
    }

    public void insertSemifinalGrade(InsertFinalGrade insertFinalGrade) {
        gradesDAO.insertSemifinalGrade(insertFinalGrade);
    }

    public void insertFinalGrade(InsertFinalGrade insertFinalGrade) {
        gradesDAO.insertFinalGrade(insertFinalGrade);
    }
}
