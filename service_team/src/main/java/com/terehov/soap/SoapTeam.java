package com.terehov.soap;

import com.terehov.soap.model.*;
import com.terehov.soap.service.IDataProvider;
import com.terehov.soap.service.DataProvider;

import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SoapTeam {

        private static final Logger LOGGER = Logger.getGlobal();

        private static final String URL = "http://localhost:8090/serviceteam";

        public static void main(String[] args) {

            LOGGER.info("Creating WEB server and publishing SOAP endpoint");
            Endpoint.publish(URL, new DataProvider());


    }
}
