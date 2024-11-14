package com.bupt.nicetown;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class NiceTownApplication {

    public static void main(String[] args) {
        SpringApplication.run(NiceTownApplication.class, args);
    }

}
