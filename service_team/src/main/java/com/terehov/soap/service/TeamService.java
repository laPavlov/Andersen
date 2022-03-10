package com.terehov.soap.service;

import com.terehov.soap.model.*;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface TeamService {

    @WebMethod
    public UserEntity insertUser(UserEntity entity);

    @WebMethod
    UserEntity getUserById(Integer id);
    @WebMethod
    GroupEntity getGroupById(Integer id);

    @WebMethod
    List<UserEntity> getListUsersByListOfId(List<Integer> listOfId);

    @WebMethod
    List<UserEntity> selectAllUsers();

    @WebMethod
    boolean updateUser(UserEntity entity);

    @WebMethod
    boolean deleteUser(int id);

    /**
     * работа с группами
     */
    @WebMethod
    public GroupEntity insertGroup(GroupEntity entity);

    @WebMethod
    boolean deleteGroup(int id);

    @WebMethod
    boolean updateGroup(GroupEntity entity);

    /**
     * для сервис-отправителя
     */
    public Object getInfoAboutLectorTeamStudent(int id);
}
