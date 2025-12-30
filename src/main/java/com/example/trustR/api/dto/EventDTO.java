package com.example.trustR.api.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class EventDTO {

    private String actorId;
    private String eventType;
    private LocalDateTime occurredAt;
    private Map<String, Object> metadata;

    public EventDTO(String actorId, String eventType, LocalDateTime occurredAt, Map<String, Object> metadata) {
        this.actorId = actorId;
        this.eventType = eventType;
        this.occurredAt = occurredAt;
        this.metadata = metadata;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(LocalDateTime occurredAt) {
        this.occurredAt = occurredAt;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
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
