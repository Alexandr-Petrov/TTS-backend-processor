package com.example.ttsbackend.service;

import com.example.ttsbackend.TtsBackendApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TtsServiceTests extends TtsBackendApplicationTests {

    @Test
    public void testConvertTextToSpeech() {
        TtsService ttsService = new TtsService();
        ResponseEntity<byte[]> response = ttsService.convertTextToSpeech("test");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Add more assertions here based on what you expect the response to be
    }
}