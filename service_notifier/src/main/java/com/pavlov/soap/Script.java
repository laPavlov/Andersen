package com.pavlov.soap;

import com.pavlov.soap.model.ServiceNotifierEntity;
import com.pavlov.soap.service.NotificationService;
import com.pavlov.soap.service.NotificationServiceImpl;

import java.util.Date;
import java.util.List;

public class Script extends Thread{
    Date date = new Date();
    Integer deadLine = 12;
    NotificationServiceImpl service = new NotificationServiceImpl();
    public void run(){
        for(;;){
            if(date.getHours() == deadLine){
                List<ServiceNotifierEntity> entities =  service.getAll();
                for (ServiceNotifierEntity entity: entities) {
                  if(entity.getCountOfMiss() == 1){
                      System.out.println(entity.getId() + " 1 день"); //МЕТОД ВНЕШНЕГО СЕРВИСА
                  }
                  if(entity.getCountOfMiss() == 3){
                      System.out.println(entity.getId() + " 3 дня"); //МЕТОД ВНЕШНЕГО СЕРВИСА
                  }
                }

                service.trackingOff();
                try {
                    Script.sleep(446400000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
