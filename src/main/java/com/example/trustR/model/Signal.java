package com.example.trustR.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "T_SIGNAL")
public class Signal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "signal_id")
    private UUID signalId;

    @Column(name = "actor_id", nullable = false)
    private String actorId;

    @Column(name = "signal_type", nullable = false)
    private SignalType signalType;

    @Column(name = "value_number")
    private Double valueNumber;

    @Column(name = "value_boolean")
    private boolean valueBoolean;

    public Signal(UUID signalId, String actorId, SignalType signalType) {
        this.signalId = signalId;
        this.actorId = actorId;
        this.signalType = signalType;
    }

    public Signal(UUID signalId, String actorId, SignalType signalType, Double valueNumber) {
        this(signalId, actorId, signalType);
        this.valueNumber = valueNumber;
    }

    public Signal(UUID signalId, String actorId, SignalType signalType, boolean valueBoolean) {
        this(signalId, actorId, signalType);
        this.valueBoolean = valueBoolean;
    }

    public UUID getSignalId() {
        return signalId;
    }

    public void setSignalId(UUID signalId) {
        this.signalId = signalId;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public SignalType getSignalType() {
        return signalType;
    }

    public void setSignalType(SignalType signalType) {
        this.signalType = signalType;
    }

    public Double getValueNumber() {
        return valueNumber;
    }

    public void setValueNumber(Double valueNumber) {
        this.valueNumber = valueNumber;
    }

    public boolean isValueBoolean() {
        return valueBoolean;
    }

    public void setValueBoolean(boolean valueBoolean) {
        this.valueBoolean = valueBoolean;
    }
}
