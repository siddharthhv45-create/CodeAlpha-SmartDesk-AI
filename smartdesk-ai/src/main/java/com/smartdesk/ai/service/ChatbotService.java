package com.smartdesk.ai.service;

import com.smartdesk.ai.intent.IntentService;
import com.smartdesk.ai.model.IntentResult;
import com.smartdesk.ai.repository.FAQRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    private final IntentService intentService;
    private final FAQRepository faqRepository;
    private final ConversationHistoryService historyService;

    public ChatbotService(
            IntentService intentService,
            FAQRepository faqRepository,
            ConversationHistoryService historyService) {

        this.intentService = intentService;
        this.faqRepository = faqRepository;
        this.historyService = historyService;
    }

    public String getResponse(String message) {

        if (message == null || message.trim().isEmpty()) {
            return "Please enter a message so I can help you.";
        }

        // Detect intent and confidence
        IntentResult result = intentService.detectIntent(message);

        String intent = result.getIntent();
        double confidence = result.getConfidence();

        // Get FAQ response
        String faqResponse = getFAQResponse(intent);

        String response;

        // If FAQ exists
        if (faqResponse != null) {

            response = faqResponse
                    + "\n\n🧠 Intent: " + intent
                    + "\n📊 Confidence: "
                    + String.format("%.0f%%", confidence * 100);

        } else {

            // Fallback response
            response = "I'm sorry, I don't have enough information to answer that yet. "
                    + "Try asking about our services, pricing, contact information, "
                    + "working hours, or SmartDesk AI."
                    + "\n\n🧠 Intent: " + intent
                    + "\n📊 Confidence: "
                    + String.format("%.0f%%", confidence * 100);
        }

        // Save conversation to history
        historyService.addMessage(message, response);

        return response;
    }

    private String getFAQResponse(String intent) {

        return switch (intent) {

            case "GREETING" ->
                    faqRepository.getFAQ("greeting");

            case "WORKING_HOURS" ->
                    faqRepository.getFAQ("working hours");

            case "SERVICES" ->
                    faqRepository.getFAQ("services");

            case "PRICING" ->
                    faqRepository.getFAQ("pricing");

            case "CONTACT" ->
                    faqRepository.getFAQ("contact");

            case "ABOUT" ->
                    faqRepository.getFAQ("about");

            case "BOT_NAME" ->
                    faqRepository.getFAQ("bot name");

            case "HELP" ->
                    faqRepository.getFAQ("help");

            case "THANKS" ->
                    faqRepository.getFAQ("thanks");

            case "GOODBYE" ->
                    faqRepository.getFAQ("goodbye");

            default ->
                    null;
        };
    }
}