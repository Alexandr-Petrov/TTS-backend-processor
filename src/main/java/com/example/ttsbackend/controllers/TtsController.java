package com.example.ttsbackend.controllers;

import com.example.ttsbackend.models.TextPayload;
import com.example.ttsbackend.service.ResponseService;
import com.example.ttsbackend.service.TtsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TtsController {
    private final TtsService ttsService;
    private final ResponseService responseService;

    @Autowired
    public TtsController(TtsService ttsService, ResponseService responseService) {
        this.ttsService = ttsService;
        this.responseService = responseService;
    }

    @PostMapping("/tts")
    public String convertTextToSpeech(@RequestBody TextPayload payload) {
        // Generate response from ChatGPT
        String response = responseService.generateResponse(payload);

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