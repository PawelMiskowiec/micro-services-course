package com.in28minutes.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    /**
     * This method goes stooopid
     * @param args input from arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
