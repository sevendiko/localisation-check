package com.sevendiko.main.java;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    private static Properties prop = null;

    public static String get(String key) {
        if (null == prop) {
            init();
        }
        return (String) prop.get(key);
    }

    private static void init() {
        prop = new Properties();
        try {
            prop.load(PropertyLoader.class.getClassLoader().getResourceAsStream("localisation.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
