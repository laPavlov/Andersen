package service;

import com.pavlov.soap.model.ServiceNotifierEntity;
import com.pavlov.soap.service.NotificationServiceImpl;
import modelToResponce.Students;


import java.util.List;

public class ServiceRouterImpl implements ServiceRouter {
    NotificationServiceImpl notificationService = new NotificationServiceImpl();

    @Override
    public List<Students> missDaysSN(List<ServiceNotifierEntity> entities) {
        if(entities == null){
            return null;
        }
        //ИЩУ ЛЮДЕЙ В СЕРВЕСЕ КОМАНДА
    }

    @Override
    public List<Students> missThreeDaySN(List<ServiceNotifierEntity> entities) {
        if(entities == null){
            return null;
        }
        //ИЩУ ЛЮДЕЙ В СЕРВЕСЕ КОМАНДА
    }

    @Override
    public void trackingUser(Integer userId) {
        notificationService.trackingOn(userId);
    }
}
