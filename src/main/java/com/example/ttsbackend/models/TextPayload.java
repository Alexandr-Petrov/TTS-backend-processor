package com.example.ttsbackend.models;

public class TextPayload {
    private String text;

    public TextPayload() {
    }

    public TextPayload(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
