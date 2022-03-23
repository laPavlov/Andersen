package com.example.service_notifier_spring;

public class Constants {
    //---------------------------------
    private static final String REST_URI_POST = "http://localhost:8090/service_notifier_war";
    private static final String RESPONSE_RECEIVED = "Received response";
    //---------------------------------Hibernate Util
    public static final String PROPERTIES_PATH = "properties";
    public static final String DEFAULT_CONFIG_PATH ="./src/main/resources/environment.properties";
    public static final String DEFAULT_HBN_CFG = "def.hbn_cnf";
    public static final String DEFAULT_HBN_CONFIG_PATH = "src/main/resources/hibernate.cfg.xml";
    public static final String WEB_HBN_CONFIG_PATH = "hibernate.cfg.xml";

    //---------------------------------CRUD
    public static final String RECORDS_ADDED = "All records were added";
    public static final String RECORDS_SELECTED = "Records were selected";
    public static final String FOUND = " found";
    public static final String NOT_FOUND = " not found";
    public static final String NOT_UPDATED =" wasn't updated";
    public static final String UPDATED =" updated";
    public static final String DELETED =" deleted";
    public static final String NOT_DELETED =" not deleted";
    public static final String ADDED =" was added";
    public static final String NOT_ADDED =" not added";


}
