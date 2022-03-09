package com.terehov.soap.service;

import com.terehov.soap.model.*;

import javax.jws.WebMethod;
import java.util.List;

public interface IDataProvider {

    @WebMethod
    public StudentsEntity insertUser(StudentsEntity entity);

    @WebMethod
    StudentsEntity getUserById(Integer id);

    @WebMethod
    List<StudentsEntity> getListUsersByListOfId(List<Integer> listOfId);

    @WebMethod
    List<StudentsEntity> selectAllUsers();

    @WebMethod
    boolean updateUser(StudentsEntity entity);

    @WebMethod
    boolean deleteUser(int id);
}
