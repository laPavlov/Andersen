package com.example.service_notifier_spring.service;


import com.example.service_notifier_spring.model.ServiceNotifierEntity;

import java.util.List;

public interface NotificationService {

    //Create
    Boolean addUser(Integer userId);

    //Read
    ServiceNotifierEntity getEntityById(Integer id);

    List<ServiceNotifierEntity> getEntityByMiss();
    List<ServiceNotifierEntity> getEntityByMissThreeDays();

    List<ServiceNotifierEntity> getAll();

    //Update
    Boolean trackingOn(Integer userId);
    Boolean trackingOff();

    //Delete
    Boolean deleteUser(Integer userId);

}
