package com.example.ttsbackend.controllers;

import com.example.ttsbackend.models.TextPayload;
import com.example.ttsbackend.service.TtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TtsController {
    private final TtsService ttsService;

    @Autowired
    public TtsController(TtsService ttsService) {
        this.ttsService = ttsService;
    }

    @PostMapping("/tts")
    public String convertTextToSpeech(@RequestBody TextPayload payload) {
        return ttsService.convertTextToSpeech(payload.getText());
    }
}