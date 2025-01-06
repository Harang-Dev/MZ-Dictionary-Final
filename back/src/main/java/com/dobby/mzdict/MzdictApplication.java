package com.dobby.mzdict;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class MzdictApplication {
    public static void main(String[] args) {
        SpringApplication.run(MzdictApplication.class, args);
    }
}
