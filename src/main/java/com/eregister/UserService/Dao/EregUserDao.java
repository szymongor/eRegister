package com.eregister.UserService.Dao;

import com.eregister.UserService.Entity.EregUser;

import java.util.Collection;

/**
 * Created by Szymon on 07.04.2017.
 */
public interface EregUserDao {
    Collection<EregUser> getAllEregUsers();

    EregUser getEregUserById(int id);

    void removeEregUserById(int id);

    EregUser getEregUserByLogin(String login);

    void updateEregStudent(EregUser eregUser);

    void insertEregStudent(EregUser eregUser);
}
