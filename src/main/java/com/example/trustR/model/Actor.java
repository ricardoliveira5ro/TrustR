package com.example.trustR.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "T_ACTOR")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "event_id")
    private UUID actorId;

    @Column(name = "trust_score")
    private double trustScore = 1.0;

    public Actor() {}

    public UUID getActorId() {
        return actorId;
    }

    public void setActorId(UUID actorId) {
        this.actorId = actorId;
    }

    public double getTrustScore() {
        return trustScore;
    }

    public void setTrustScore(double trustScore) {
        this.trustScore = trustScore;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", trustScore=" + trustScore +
                '}';
    }
}
