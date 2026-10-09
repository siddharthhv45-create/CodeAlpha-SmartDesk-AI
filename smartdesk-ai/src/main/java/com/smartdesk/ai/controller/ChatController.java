package com.smartdesk.ai.controller;

import com.smartdesk.ai.model.ChatMessage;
import com.smartdesk.ai.service.ChatbotService;
import com.smartdesk.ai.service.ConversationHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin
public class ChatController {

    private final ChatbotService chatbotService;
    private final ConversationHistoryService historyService;

    public ChatController(
            ChatbotService chatbotService,
            ConversationHistoryService historyService) {

        this.chatbotService = chatbotService;
        this.historyService = historyService;
    }

    // Send message to chatbot
    @GetMapping
    public String chat(@RequestParam String message) {
        return chatbotService.getResponse(message);
    }

    // Get conversation history
    @GetMapping("/history")
    public List<ChatMessage> getHistory() {
        return historyService.getHistory();
    }

    // Clear conversation history
    @DeleteMapping("/history")
    public String clearHistory() {
        historyService.clearHistory();
        return "Conversation history cleared successfully.";
    }
}