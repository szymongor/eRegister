package com.eregister.UserService.Service;

import com.eregister.UserService.Dao.EregUserDao;
import com.eregister.UserService.Entity.EregUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Szymon on 07.04.2017.
 */

@Service
public class EregUserService {

    @Autowired
    @Qualifier("mysql")
    EregUserDao eregUserDao;

    public Collection<EregUser> getAllEregUsers(){
        return eregUserDao.getAllEregUsers();
    }

    public Collection<EregUser> getAllEnableEregUsers(){
        return eregUserDao.getAllEnableEregUsers();
    }

    public Collection<EregUser> getAllTeachersEregUsers(){
        return eregUserDao.getAllTeachersEregUsers();
    }

    public Collection<EregUser> getAllGuardiansEregUsers(){
        return eregUserDao.getAllGuardiansEregUsers();
    }

    public Collection<EregUser> getAllStudentsEregUsers(){
        return eregUserDao.getAllStudentsEregUsers();
    }

    public EregUser getEregUserById(int id){
        return eregUserDao.getEregUserById(id);
    }

    public EregUser getEregUserByIdPerson(int id) { return eregUserDao.getEregUserByIdPerson(id);}

    public EregUser getEregUserByLogin(String login){
        return eregUserDao.getEregUserByLogin(login);
    }

    public void removeEregUserById(int id){
        eregUserDao.removeEregUserById(id);
    }

    public void removeEregUserByLogin(String login) {
        eregUserDao.removeEregUserByLogin(login);
    }

    public void updatePasswordEregUser(EregUser eregUser){
        eregUserDao.updatePasswordEregUser(eregUser);
    }

    public void insertEregUser(EregUser eregUser){
        eregUserDao.insertEregUser(eregUser);
    }
}
