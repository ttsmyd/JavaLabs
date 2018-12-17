package com.netcracker.lab.injectors;

import com.netcracker.lab.annotations.AutoInjectable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Properties;


public class Injector {
    public static final String PATH_TO_PROPERTIES = "src/main/resources/config.properties";

    public <T> T inject(T object) {
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(AutoInjectable.class)) {
                    field.setAccessible(true);
                    String type = field.getType().getName();
                    System.out.println(type);
                    String sortString = properties(type);
                    Object sort = Class.forName(sortString).newInstance();
                    field.set(object, sort);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return object;
    }

    private String properties(String type) {
        String results = "";
        FileInputStream fileInputStream;
        Properties prop = new Properties();
        try {
            File file = new File(PATH_TO_PROPERTIES);
            prop.load(new FileReader(file));
            results = prop.getProperty(type);
        } catch (Exception e) {
        }

        return results;
    }
}
