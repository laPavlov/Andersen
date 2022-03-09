package com.terehov.soap.service;

import com.terehov.soap.model.*;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface TeamService {

    @WebMethod
    public StudentsEntity insertUser(StudentsEntity entity);

    @WebMethod
    StudentsEntity getUserById(Integer id);
    @WebMethod
    GroupsEntity getGroupById(Integer id);

    @WebMethod
    List<StudentsEntity> getListUsersByListOfId(List<Integer> listOfId);

    @WebMethod
    List<StudentsEntity> selectAllUsers();

    @WebMethod
    boolean updateUser(StudentsEntity entity);

    @WebMethod
    boolean deleteUser(int id);
}
