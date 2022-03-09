package service;

import com.pavlov.soap.model.ServiceNotifierEntity;
import modelToResponce.Students;


import java.util.List;

public interface ServiceRouter {

    List<Students> missDaysSN(List<ServiceNotifierEntity> entities);
    List<Students> missThreeDaySN(List<ServiceNotifierEntity> entities);

    void trackingUser(Integer userId);

}
