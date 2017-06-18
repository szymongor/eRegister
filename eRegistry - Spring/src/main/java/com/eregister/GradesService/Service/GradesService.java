package com.eregister.GradesService.Service;

import com.eregister.GradesService.DAO.GradesDAO;
import com.eregister.GradesService.Entity.Grade;
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
}
