package com.eregister.GroupsService.DAO;

import com.eregister.GroupsService.Entity.Group;
import com.eregister.PeopleService.Entity.Person;

import java.util.Collection;

/**
 * Created by Karo2 on 2017-05-17.
 */
public interface GroupsDAO {

    Collection<Group> getAllGroupsTeachByUser(int idEregUser);

    Collection<Person> getAllStudentsFromGroup(int idGroup);
}
