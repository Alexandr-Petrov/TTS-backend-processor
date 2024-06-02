package com.example.ttsbackend.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class TtsService {
    public ResponseEntity<byte[]> convertTextToSpeech(String text) {
        RestTemplate restTemplate = new RestTemplate();

        // Build the URL with the text as a query parameter
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:5002/api/tts")
                .queryParam("text", text)
                .build()
                .toUri();

        // Make the GET request
        byte[] response = restTemplate.getForObject(uri, byte[].class);

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("audio/wav"));

        // Create and return the response entity
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }
}