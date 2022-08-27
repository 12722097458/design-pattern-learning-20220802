package com.ityj.design.factory.factory_config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Slf4j
public class CoffeeFactory {
    private static Map<String, Coffee> coffeeMap = new HashMap<>();

    static {
        Properties properties = new Properties();
        try(InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("factory/factory_config.properties")) {
            properties.load(is);
            for (Object name : properties.keySet()) {
                Class<?> clazz = Class.forName(properties.getProperty((String) name));
                Coffee coffee = (Coffee) clazz.getDeclaredConstructor().newInstance();
                coffeeMap.put((String) name, coffee);
            }
        } catch (Exception e) {
            log.error("Error occurred: ", e);
        }

    }

    public static Coffee getCoffee(String name) {
        Coffee coffee = coffeeMap.get(name);
        Assert.notNull(coffee, "当前Coffee类型不存在！");
        return coffee;
    }

}
