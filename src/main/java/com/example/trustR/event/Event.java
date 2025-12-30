package com.example.trustR.event;

import java.time.LocalDateTime;

public class Event {

    private String id;
    private String actorId;
    private EventType eventType;
    private String payload;
    private LocalDateTime timestamp;

    public Event(String id, String actorId, EventType eventType, String payload, LocalDateTime timestamp) {
        this.id = id;
        this.actorId = actorId;
        this.eventType = eventType;
        this.payload = payload;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
