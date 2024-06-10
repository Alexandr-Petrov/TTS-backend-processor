package com.example.ttsbackend;

import com.example.ttsbackend.support.TtsServerContainer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
public class TtsBackendApplicationTests {

    @Container
    private static final TtsServerContainer ttsServerContainer = new TtsServerContainer();

    @Test
    public void contextLoads() {
    }
}