package com.eregister.UserService.Dao;

import com.eregister.UserService.Entity.EregUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;


import static javax.swing.UIManager.put;

/**
 * Created by Szymon on 07.04.2017.
 */
@Repository
@Qualifier("fakeData")
public class EregUserDaoFakeImpl implements EregUserDao {

    static Map<Integer, EregUser> allUsers;

    static{
        allUsers = new HashMap<Integer, EregUser>(){
            {
                put(1, new EregUser(1, "Adam", "12345678"));
                put(2, new EregUser(2, "Kasia", "12345678"));
                put(3, new EregUser(3, "Marta", "12345678"));
                put(4, new EregUser(4, "Marta", "12345678"));
            }
        };
    }

    @Override
    public Collection<EregUser> getAllEregUsers(){
        return allUsers.values();
    }

    @Override
    public EregUser getEregUserById(int id){
        return allUsers.get(id);
    }

    @Override
    public void removeEregUserById(int id){
        allUsers.remove(id);
    }

    @Override
    public EregUser getEregUserByName(String name) {
        return null;
    }

    @Override
    public void updateEregStudent(EregUser eregUser){
        allUsers.put(eregUser.getId(),eregUser);
    }

    @Override
    public void insertEregStudent(EregUser eregUser){
        allUsers.put(eregUser.getId(),eregUser);
    }


}
