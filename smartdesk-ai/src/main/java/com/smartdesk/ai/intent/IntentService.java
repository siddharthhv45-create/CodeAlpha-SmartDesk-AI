package com.smartdesk.ai.intent;

import com.smartdesk.ai.model.IntentResult;
import com.smartdesk.ai.service.NLPService;
import org.springframework.stereotype.Service;

@Service
public class IntentService {

    private final NLPService nlpService;

    public IntentService(NLPService nlpService) {
        this.nlpService = nlpService;
    }

    public IntentResult detectIntent(String message) {

        if (message == null || message.trim().isEmpty()) {
            return new IntentResult("UNKNOWN", 0.0);
        }

        String input = nlpService.preprocess(message);

        // Greeting
        int greetingScore = countMatches(input,
                "hello", "hi", "hey",
                "good morning", "good afternoon", "good evening");

        if (greetingScore > 0) {
            return new IntentResult(
                    "GREETING",
                    calculateConfidence(greetingScore, 2)
            );
        }

        // Working Hours
        int workingHoursScore = countMatches(input,
                "working hours",
                "business hours",
                "office hours",
                "opening hours",
                "closing time",
                "when are you open",
                "what time do you open",
                "what time do you close");

        if (workingHoursScore > 0) {
            return new IntentResult(
                    "WORKING_HOURS",
                    calculateConfidence(workingHoursScore, 2)
            );
        }

        // Bot Name
        int botNameScore = countMatches(input,
                "what is your name",
                "whats your name",
                "your name",
                "who are you");

        if (botNameScore > 0) {
            return new IntentResult(
                    "BOT_NAME",
                    calculateConfidence(botNameScore, 2)
            );
        }

        // About SmartDesk
        int aboutScore = countMatches(input,
                "about smartdesk",
                "tell me about smartdesk",
                "what is smartdesk",
                "what can you do");

        if (aboutScore > 0) {
            return new IntentResult(
                    "ABOUT",
                    calculateConfidence(aboutScore, 2)
            );
        }

        // Services
        int servicesScore = countMatches(input,
                "service",
                "services",
                "what do you provide",
                "what do you offer",
                "products");

        if (servicesScore > 0) {
            return new IntentResult(
                    "SERVICES",
                    calculateConfidence(servicesScore, 2)
            );
        }

        // Pricing
        int pricingScore = countMatches(input,
                "price",
                "pricing",
                "cost",
                "plans",
                "how much");

        if (pricingScore > 0) {
            return new IntentResult(
                    "PRICING",
                    calculateConfidence(pricingScore, 2)
            );
        }

        // Contact
        int contactScore = countMatches(input,
                "contact",
                "phone",
                "email",
                "reach support",
                "contact support",
                "customer care");

        if (contactScore > 0) {
            return new IntentResult(
                    "CONTACT",
                    calculateConfidence(contactScore, 2)
            );
        }

        // Help
        int helpScore = countMatches(input,
                "help",
                "can you help",
                "i need help",
                "what can i ask");

        if (helpScore > 0) {
            return new IntentResult(
                    "HELP",
                    calculateConfidence(helpScore, 2)
            );
        }

        // Thanks
        int thanksScore = countMatches(input,
                "thank",
                "thanks",
                "thank you",
                "thx");

        if (thanksScore > 0) {
            return new IntentResult(
                    "THANKS",
                    calculateConfidence(thanksScore, 2)
            );
        }

        // Goodbye
        int goodbyeScore = countMatches(input,
                "bye",
                "goodbye",
                "see you",
                "good night");

        if (goodbyeScore > 0) {
            return new IntentResult(
                    "GOODBYE",
                    calculateConfidence(goodbyeScore, 2)
            );
        }

        return new IntentResult("UNKNOWN", 0.20);
    }

    private int countMatches(String input, String... keywords) {

        int count = 0;

        for (String keyword : keywords) {

            if (input.contains(keyword)) {
                count++;
            }
        }

        return count;
    }

    private double calculateConfidence(int matches, int minimumMatches) {

        double confidence = 0.70 + (matches * 0.10);

        if (confidence > 0.99) {
            confidence = 0.99;
        }

        return confidence;
    }
}