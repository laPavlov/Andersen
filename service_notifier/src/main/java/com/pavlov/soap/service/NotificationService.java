package com.pavlov.soap.service;

import com.pavlov.soap.model.ServiceNotifierEntity;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface NotificationService {

    //Create
    @WebMethod
    Boolean addUser(Integer userId);

    //Read
    ServiceNotifierEntity getEntityById(Integer id);

    List<ServiceNotifierEntity> getEntityByMiss();
    List<ServiceNotifierEntity> getEntityByMissThreeDays();

    List<ServiceNotifierEntity> getAll();

    //Update
    @WebMethod
    Boolean trackingOn(Integer userId);
    Boolean trackingOff();

    //Delete
    @WebMethod
    Boolean deleteUser(Integer userId);

}
