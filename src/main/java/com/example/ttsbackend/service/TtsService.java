package com.example.ttsbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class TtsService {
    public String convertTextToSpeech(String text) {
        RestTemplate restTemplate = new RestTemplate();

        // Build the URL with the text as a query parameter
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:5002/api/tts")
                .queryParam("text", text)
                .build()
                .toUri();

        // Make the GET request
        byte[] response = restTemplate.getForObject(uri, byte[].class);

        // Save the response to a local file
        try {
            Path path = Paths.get("test.wav");
            Files.write(path, response);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save audio file", e);
        }

        return "done";
    }
}