package com.eregister.UserService.Service;

import com.eregister.UserService.Dao.EregUserDao;
import com.eregister.UserService.Dao.EregUserDaoFakeImpl;
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
    @Qualifier("fakeData")
    EregUserDao eregUserDao;

    public Collection<EregUser> getAllEregUsers(){
        return eregUserDao.getAllEregUsers();
    }

    public EregUser getEregUserById(int id){
        return eregUserDao.getEregUserById(id);
    }

    public void removeEregUserById(int id){
        eregUserDao.removeEregUserById(id);
    }

    public void updateEregUser(EregUser eregUser){
        eregUserDao.updateEregStudent(eregUser);
    }

    public void insertEregUser(EregUser eregUser){
        eregUserDao.insertEregStudent(eregUser);
    }

}
