package com.example.trustR.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Entity
@Table(name = "T_ACTOR")
public class Fact {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "fact_id")
    private UUID factId;

    @Column(name = "actor_id", nullable = false)
    private String actorId;

    // Type

    // Metadata

    @Column(name= "occurred_at")
    private LocalDateTime occurredAt = LocalDateTime.now(ZoneOffset.UTC);

    public Fact(String actorId) {
        this.actorId = actorId;
    }

    public UUID getFactId() {
        return factId;
    }

    public void setFactId(UUID factId) {
        this.factId = factId;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(LocalDateTime occurredAt) {
        this.occurredAt = occurredAt;
    }

    @Override
    public String toString() {
        return "Fact{" +
                "factId=" + factId +
                ", actorId='" + actorId + '\'' +
                ", occurredAt=" + occurredAt +
                '}';
    }
}
