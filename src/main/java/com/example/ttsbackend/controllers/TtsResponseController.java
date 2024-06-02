package com.example.ttsbackend.controllers;

import com.example.ttsbackend.models.TextPayload;
import com.example.ttsbackend.service.GptResponseService;
import com.example.ttsbackend.service.TtsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TtsResponseController {
    private final TtsService ttsService;
    private final GptResponseService gptResponseService;

    @Autowired
    public TtsResponseController(TtsService ttsService, GptResponseService gptResponseService) {
        this.ttsService = ttsService;
        this.gptResponseService = gptResponseService;
    }

    @PostMapping("/respond/tts")
    public ResponseEntity<byte[]> convertTextToSpeech(@RequestBody TextPayload payload) {
        // Generate response from ChatGPT
        String response = gptResponseService.generateResponse(payload);

        // Parse the response to extract the content
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response);
            String content = root.path("choices").get(0).path("message").path("content").asText();

            // Convert the content to speech
            return ttsService.convertTextToSpeech(content);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing response", e);
        }
    }
}