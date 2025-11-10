package service;

import java.util.ResourceBundle;

public class TestDataReader {

    private static String environment = System.getProperty("environment");
    static {
        if (environment == null) {
            environment = "set1";
        }
    }

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(environment);

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
