package com.eregister.GroupsService.Service;

import com.eregister.GroupsService.DAO.GroupsDAO;
import com.eregister.GroupsService.Entity.Group;
import com.eregister.PeopleService.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Karo2 on 2017-05-17.
 */
@Service
public class GroupsService {

    @Autowired
    @Qualifier("mysql")
    GroupsDAO groupsDAO;

    public Collection<Group> getAllGroupsByTeacher(int idTeacher) {
        return groupsDAO.getAllGroupsByTeacher(idTeacher);
    }

    public Collection<Person> getAllStudentsFromGroup(int idGroup) {
        return groupsDAO.getAllStudentsFromGroup(idGroup);
    }
}
