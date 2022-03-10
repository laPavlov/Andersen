package service;

import com.pavlov.soap.model.ServiceNotifierEntity;
import com.pavlov.soap.service.NotificationServiceImpl;
import com.terehov.soap.model.UserEntity;

import java.util.Date;
import java.util.List;

public class Script extends Thread {

    Date date = new Date();
    Integer deadLine = 22;

    NotificationServiceImpl notificationService = new NotificationServiceImpl();
    ServiceRouter serviceRouter = new ServiceRouterImpl();
    SenderService senderService = new SenderServiceImpl();
    List<ServiceNotifierEntity> serviceNotifierEntity;

    public void run() {
        for (; ; ) {
            if (date.getHours() == deadLine) {
                serviceNotifierEntity = notificationService.getEntityByMiss();
                if (serviceNotifierEntity != null) {
                    List<UserEntity> UserEntity = serviceRouter.missDaysSN(serviceNotifierEntity);
//                    МЕТОД БОТА ПОЛУЧАЮЩИЙ studentsEntity И ОТПРАВЛЯЮЩИЙ СООБЩЕНИЕ ТИМЛИДУ
                }
                serviceNotifierEntity = notificationService.getEntityByMissThreeDays();
                if (serviceNotifierEntity != null) {
                    serviceRouter.missThreeDaySN(serviceNotifierEntity);
//                    МЕТОД БОТА ПОЛУЧАЮЩИЙ studentsEntity И ОТПРАВЛЯЮЩИЙ СООБЩЕНИЕ ЛЕКТОРУ
                }
            }

            //МЕТОД БОТА
            senderService.getALlTeamsReports();


            notificationService.trackingOff();
            try {
                Script.sleep(446000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
