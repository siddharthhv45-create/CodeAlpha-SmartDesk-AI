package com.smartdesk.ai.service;

import com.smartdesk.ai.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConversationHistoryService {

    private final List<ChatMessage> history = new ArrayList<>();

    public void addMessage(String message, String response) {
        history.add(new ChatMessage(message, response));
    }

    public List<ChatMessage> getHistory() {
        return history;
    }

    public void clearHistory() {
        history.clear();
    }
}