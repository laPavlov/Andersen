package com.terehov.soap.service;

import com.terehov.soap.model.*;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface TeamService {

//Методы работы с группой
    @WebMethod
    Boolean createGroup(String color);
    @WebMethod
    Boolean deleteGroup(Integer idGroup);
    @WebMethod
    Boolean choiceColorForGroup(Integer idGroup, String color);
    @WebMethod
    Boolean addUserToGroup(Integer idGroup, Integer idUser, String role);
    @WebMethod
    Boolean choiceRoleUserToGroup(Integer idUser, String role);
    @WebMethod
    Boolean removeUserFromGroup(Integer idUser);

    @WebMethod
    List<UserEntity> getListUsersByListOfId(List<Integer> listOfId);



    @WebMethod
    UserEntity insertUser(UserEntity entity);
    @WebMethod
    UserEntity getUserById(Integer id);

    @WebMethod
    GroupEntity getGroupById(Integer id);

    @WebMethod
    List<UserEntity> selectAllUsers();

    @WebMethod
    boolean updateUser(UserEntity entity);

    @WebMethod
    boolean deleteUser(int id);

    @WebMethod
    public GroupEntity insertGroup(GroupEntity entity);


    @WebMethod
    boolean updateGroup(GroupEntity entity);

    /**
     * для сервис-отправителя
     */
//    public Object getInfoAboutLectorTeamStudent(int id);
}
