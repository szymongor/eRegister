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

    public Collection<Grade> getAllUserGrades(int idEregUser) {
        return gradesDAO.getAllUserGrades(idEregUser);
    }

    public Collection<Grade> getAllUserGradesFromLesson(int idEregUser, int idLesson) {
        return gradesDAO.getAllUserGradesFromLesson(idEregUser, idLesson);
    }
}
