package com.example.ttsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class TtsBackendApplication {

    @PostConstruct
    public void init() {
        try {
            FileInputStream fis = new FileInputStream(".env");
            Properties properties = new Properties();
            properties.load(fis);

            properties.forEach((key, value) -> {
                System.setProperty((String) key, (String) value);
            });
        } catch (IOException e) {
            throw new RuntimeException("Could not load .env file", e);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(TtsBackendApplication.class, args);

    }
}