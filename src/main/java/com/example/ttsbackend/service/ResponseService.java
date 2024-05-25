package com.example.ttsbackend.service;

import com.example.ttsbackend.models.TextPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ResponseService {
    private static final String CHAT_GPT_API_URL = "https://api.openai.com/v1/chat/completions";

    public String generateResponse(TextPayload payload) {
        RestTemplate restTemplate = new RestTemplate();

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + System.getProperty("OPENAI_API_KEY"));

        // Create request
        HttpEntity<String> request = new HttpEntity<>(createRequestBody(payload.getText()), headers);

        // Make the POST request
        ResponseEntity<String> response = restTemplate.exchange(CHAT_GPT_API_URL, HttpMethod.POST, request, String.class);

        // Extract the generated text from the response
        return response.getBody();
    }

    private String createRequestBody(String text) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode requestBody = mapper.createObjectNode();

            requestBody.put("model", "gpt-4o");

            ArrayNode messages = requestBody.putArray("messages");

            ObjectNode systemMessage = messages.addObject();
            systemMessage.put("role", "system");
            systemMessage.put("content", "You are samurai warrior, you are tasked with writing with a haikus about anything those seeking advice asking about.");

            ObjectNode userMessage = messages.addObject();
            userMessage.put("role", "user");
            userMessage.put("content", text);

            return mapper.writeValueAsString(requestBody);
        } catch (Exception e) {
            throw new RuntimeException("Error creating request body", e);
        }
    }
}