package service;

import com.pavlov.soap.model.ServiceNotifierEntity;
import com.terehov.soap.model.StudentsEntity;
import modelToResponce.Students;


import java.util.List;

public interface ServiceRouter {

    List<StudentsEntity> missDaysSN(List<ServiceNotifierEntity> entities);
    List<StudentsEntity> missThreeDaySN(List<ServiceNotifierEntity> entities);

    void trackingUser(Integer userId);

}
