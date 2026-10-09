package com.smartdesk.ai.service;

import org.springframework.stereotype.Service;

@Service
public class NLPService {

    public String preprocess(String message) {

        if (message == null || message.trim().isEmpty()) {
            return "";
        }

        // Convert text to lowercase
        String processed = message.toLowerCase();

        // Remove special characters
        processed = processed.replaceAll("[^a-z0-9\\s]", "");

        // Remove extra spaces
        processed = processed.replaceAll("\\s+", " ").trim();

        return processed;
    }
}