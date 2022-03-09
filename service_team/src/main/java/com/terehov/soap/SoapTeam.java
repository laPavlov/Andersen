package com.terehov.soap;

import com.terehov.soap.model.GroupsEntity;
import com.terehov.soap.service.TeamServiceImpl;

import javax.xml.ws.Endpoint;
import java.util.logging.Logger;

public class SoapTeam {

        private static final Logger LOGGER = Logger.getGlobal();

        private static final String URL = "http://localhost:8091/serviceteam";

        public static void main(String[] args) {

            LOGGER.info("Creating WEB server and publishing SOAP endpoint");
            Endpoint.publish(URL, new TeamServiceImpl());
            TeamServiceImpl teamService = new TeamServiceImpl();

    }
}
