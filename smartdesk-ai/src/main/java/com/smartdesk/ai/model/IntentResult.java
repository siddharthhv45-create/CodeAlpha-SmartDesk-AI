package com.smartdesk.ai.model;

public class IntentResult {

    private String intent;
    private double confidence;

    public IntentResult(String intent, double confidence) {
        this.intent = intent;
        this.confidence = confidence;
    }

    public String getIntent() {
        return intent;
    }

    public double getConfidence() {
        return confidence;
    }
}