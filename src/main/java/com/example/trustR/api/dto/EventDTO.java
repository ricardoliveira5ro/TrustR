package com.example.trustR.api.dto;

import java.util.Map;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class EventDTO {

    @NotNull
    private String actorId;

    @NotNull
    @Pattern(regexp = "ACTION_ATTEMPTED|ACTION_SUCCEEDED|ACTION_FAILED|RATE_LIMIT_EXCEEDED|POLICY_VIOLATION|MANUAL_REVIEW|ACCOUNT_CREATED|ACCOUNT_VERIFIED", message = "Invalid value")
    private String eventType;

    private Map<String, Object> metadata;

    public EventDTO() {}

    public EventDTO(String actorId, String eventType, Map<String, Object> metadata) {
        this.actorId = actorId;
        this.eventType = eventType;
        this.metadata = metadata;
    }

    public String getActorId() {
        return actorId;
    }

    public String getEventType() {
        return eventType;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "actorId='" + actorId + '\'' +
                ", eventType='" + eventType + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}
