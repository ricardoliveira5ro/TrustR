package com.example.trustR.event;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "T_EVENT")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "event_id")
    private UUID eventId;

    @Column(name = "actor_id", nullable = false)
    private String actorId;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false)
    private EventType eventType;

    @Column(name = "metadata", columnDefinition = "TEXT", nullable = false)
    private String metadata;

    @Column(name= "occurred_at", nullable = false)
    private LocalDateTime occurredAt;

    public Event(String actorId, EventType eventType, String metadata, LocalDateTime occurredAt) {
        this.actorId = actorId;
        this.eventType = eventType;
        this.metadata = metadata;
        this.occurredAt = occurredAt;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
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

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(LocalDateTime occurredAt) {
        this.occurredAt = occurredAt;
    }
}
