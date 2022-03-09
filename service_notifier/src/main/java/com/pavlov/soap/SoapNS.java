package com.pavlov.soap;

import com.pavlov.soap.service.NotificationServiceImpl;


import java.util.logging.Logger;
import javax.xml.ws.Endpoint;

public class SoapNS {

    private static final Logger LOGGER = Logger.getGlobal();

    private static final String URL = "http://localhost:8090/servicenotifier";

    public static void main(String[] args) {

        LOGGER.info("Creating WEB server and publishing SOAP endpoint");
        Endpoint.publish(URL, new NotificationServiceImpl());
       }
    }
