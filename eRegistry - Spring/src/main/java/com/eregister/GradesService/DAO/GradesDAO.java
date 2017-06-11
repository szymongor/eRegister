package com.eregister.GradesService.DAO;

import com.eregister.GradesService.Entity.Grade;

import java.util.Collection;

/**
 * Created by Karo2 on 2017-06-11.
 */
public interface GradesDAO {

    Collection<Grade> getAllUserGrades(int idEregUser);

    Collection<Grade> getAllUserGradesFromLesson(int idEregUser, int idLesson);
}
