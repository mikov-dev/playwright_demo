package org.pnm;

import org.pnm.support.FileUtils;

import java.util.Properties;

public class AppConfig {

    private static final FileUtils fileUtils = FileUtils.getInstance();
    private static final Properties properties = fileUtils.loadProperties("application.properties", null);

    private static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    private static String getPath() {
        return properties.getProperty("path");
    }

    private static String getUsersEndpoint() {
        return properties.getProperty("usersEndpoint");
    }

    public final static  String BASE_URL = getBaseUrl();
    public final static  String PATH = getPath();
    public final static  String USERS = getUsersEndpoint();
    public final static  String VEHICLES = getUsersEndpoint();

}
