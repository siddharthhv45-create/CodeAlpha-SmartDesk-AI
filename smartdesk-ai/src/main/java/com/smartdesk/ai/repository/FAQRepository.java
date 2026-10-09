package com.smartdesk.ai.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class FAQRepository {

    private final Map<String, String> faqData = new HashMap<>();

    public FAQRepository() {

        faqData.put(
                "working hours",
                "Our working hours are Monday to Friday, 9:00 AM to 6:00 PM."
        );

        faqData.put(
                "services",
                "We provide software development, AI solutions, technical support and customer assistance."
        );

        faqData.put(
                "pricing",
                "Our pricing depends on the service and requirements. Please contact our support team for detailed pricing."
        );

        faqData.put(
                "contact",
                "You can contact our support team through the official support channel. We're happy to assist you."
        );

        faqData.put(
                "about",
                "SmartDesk AI is a Java-based customer-support chatbot designed to understand user questions and provide helpful responses."
        );

        // Bot name FAQ
        faqData.put(
                "bot name",
                "My name is SmartDesk AI. 🤖 I'm a Java-based chatbot designed to help users with common questions and support."
        );

        faqData.put(
                "help",
                "You can ask me about services, pricing, contact information, working hours, or SmartDesk AI."
        );

        faqData.put(
                "greeting",
                "Hello! 👋 I'm SmartDesk AI. How can I help you today?"
        );

        faqData.put(
                "thanks",
                "You're very welcome! 😊 I'm happy to help."
        );

        faqData.put(
                "goodbye",
                "Goodbye! 👋 Have a great day. Feel free to come back anytime!"
        );
    }

    public String getFAQ(String category) {
        return faqData.get(category);
    }

    public boolean containsFAQ(String category) {
        return faqData.containsKey(category);
    }
}