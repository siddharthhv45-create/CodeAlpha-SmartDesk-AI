package com.smartdesk.ai.model;

import java.time.LocalDateTime;

public class ChatMessage {

    private String message;
    private String response;
    private LocalDateTime timestamp;

    public ChatMessage(String message, String response) {
        this.message = message;
        this.response = response;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public String getResponse() {
        return response;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}