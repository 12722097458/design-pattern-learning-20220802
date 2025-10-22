package com.ityj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DesignPatternStarter {
    // java -Xloggc:./gc.log -Xmx100m -Xms50m
    // -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDetails
    // -jar design-pattern-learning-20220802-1.0-SNAPSHOT.jar &
    public static void main(String[] args) {
        SpringApplication.run(DesignPatternStarter.class, args);
    }
}
