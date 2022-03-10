package service;

import com.pavlov.soap.model.ServiceNotifierEntity;
import com.terehov.soap.model.UserEntity;


import java.util.List;

public interface ServiceRouter {

    List<UserEntity> missDaysSN(List<ServiceNotifierEntity> entities);
    List<UserEntity> missThreeDaySN(List<ServiceNotifierEntity> entities);

    void trackingUser(Integer userId);

}
