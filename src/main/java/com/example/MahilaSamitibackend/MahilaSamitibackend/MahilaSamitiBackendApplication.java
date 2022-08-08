package com.example.MahilaSamitibackend.MahilaSamitibackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MahilaSamitiBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MahilaSamitiBackendApplication.class, args);
    }

}
