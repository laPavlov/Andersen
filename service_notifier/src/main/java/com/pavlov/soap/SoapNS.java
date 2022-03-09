package com.pavlov.soap;

import com.pavlov.soap.model.ServiceNotifierEntity;
import com.pavlov.soap.service.NotificationService;
import com.pavlov.soap.service.NotificationServiceImpl;


import java.util.List;
import java.util.logging.Logger;
import javax.xml.ws.Endpoint;

public class SoapNS {

    private static final Logger LOGGER = Logger.getGlobal();

    private static final String URL = "http://localhost:8090/servicenotifier";

    public static void main(String[] args) {

        LOGGER.info("Creating WEB server and publishing SOAP endpoint");
        Endpoint.publish(URL, new NotificationServiceImpl());
        Script script = new Script();
        script.start();
       }
    }
