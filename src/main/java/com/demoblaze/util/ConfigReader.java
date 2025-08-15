package com.demoblaze.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    // Static block loads properties file once when the class is first used
    static {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("❌ Could not load config.properties file", e);
        }
    }

    // Get a value by key
    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value != null) {
            return value.trim(); // remove extra spaces
        }
        return null;
    }
}


