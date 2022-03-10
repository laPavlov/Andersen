package service;

import com.pavlov.soap.model.ServiceNotifierEntity;
import com.pavlov.soap.service.NotificationServiceImpl;
import com.terehov.soap.service.TeamServiceImpl;


import java.util.ArrayList;
import java.util.List;

public class ServiceRouterImpl implements ServiceRouter {
    NotificationServiceImpl notificationService = new NotificationServiceImpl();
    TeamServiceImpl teamService = new TeamServiceImpl();

    @Override
    public List<StudentsEntity> missDaysSN(List<ServiceNotifierEntity> entities) {
        return getStudentsEntities(entities);

    }

    @Override
    public List<StudentsEntity> missThreeDaySN(List<ServiceNotifierEntity> entities) {
        return getStudentsEntities(entities);
    }

    List<StudentsEntity> getStudentsEntities(List<ServiceNotifierEntity> entities) {
        if(entities == null){
            return null;
        }
        List<Integer> usersId = new ArrayList<>(entities.size());
        for (ServiceNotifierEntity entity: entities){
            usersId.add(entity.getStudentId());
        }
        return teamService.getListUsersByListOfId(usersId);
    }

    @Override
    public void trackingUser(Integer userId) {
        notificationService.trackingOn(userId);
    }
}
