package com.example.service_notifier_spring.controller;

import com.example.service_notifier_spring.model.ServiceNotifierEntity;
import com.example.service_notifier_spring.service.NotificationService;
import com.example.service_notifier_spring.service.NotificationServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private static final NotificationService notificationService = new NotificationServiceImpl();

    @GetMapping("/addUser/{user-id}")
    public Boolean addUser(@PathVariable("user-id") Integer userId){
        notificationService.addUser(userId);
        return true;
    }
    @GetMapping("/trackingOn/{user-id}")
    public Boolean trackingOn(@PathVariable("user-id") Integer userId){
        notificationService.trackingOn(userId);
        return true;
    }
    @GetMapping("/trackingOff")
    public Boolean trackingOff(){
        notificationService.trackingOff();
        return true;
    }
    @GetMapping("/deleteUser/{user-id}")
    public Boolean deleteUser(@PathVariable("user-id") Integer userId){
        notificationService.deleteUser(userId);
        return true;
    }
    @GetMapping("/getEntityByMiss")
    public List<ServiceNotifierEntity> missOneDay(){
        return notificationService.getEntityByMiss();
    }
    @GetMapping("/getEntityByMissThree")
    public List<ServiceNotifierEntity> missThreeDay(){
        return notificationService.getEntityByMissThreeDays();
    }
}
