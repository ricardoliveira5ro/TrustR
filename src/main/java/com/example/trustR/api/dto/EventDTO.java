package com.example.trustR.api.dto;

import java.time.LocalDateTime;
import java.util.Map;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

public class EventDTO {

    @NotNull
    private String actorId;

    @NotNull
    @Pattern(regexp = "ACTION_ATTEMPTED|ACTION_SUCCEEDED|ACTION_FAILED|RATE_LIMIT_EXCEEDED|POLICY_VIOLATION|MANUAL_REVIEW|ACCOUNT_CREATED|ACCOUNT_VERIFIED", message = "Invalid value")
    private String eventType;

    @NotNull
    @PastOrPresent(message = "occurredAt cannot be in the future")
    private LocalDateTime occurredAt;

    private Map<String, Object> metadata;

    public EventDTO() {}

    public EventDTO(String actorId, String eventType, LocalDateTime occurredAt, Map<String, Object> metadata) {
        this.actorId = actorId;
        this.eventType = eventType;
        this.occurredAt = occurredAt;
        this.metadata = metadata;
    }

    public String getActorId() {
        return actorId;
    }

    public String getEventType() {
        return eventType;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "actorId='" + actorId + '\'' +
                ", eventType='" + eventType + '\'' +
                ", occurredAt=" + occurredAt +
                ", metadata=" + metadata +
                '}';
    }
}
