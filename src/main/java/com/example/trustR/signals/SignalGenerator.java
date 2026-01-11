package com.example.trustR.signals;

import com.example.trustR.model.Event;
import com.example.trustR.model.Signal;
import com.example.trustR.model.SignalType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SignalGenerator {

    public List<Signal> generateSignals(Event currentEvent) {
        List<Signal> signals = new ArrayList<>();

        switch (currentEvent.getEventType()) {
            case ACTION_FAILED -> signals.add(Signal.booleanSignal(currentEvent.getActorId(), SignalType.FAILED_ACTION_ATTEMPT, true));
            case ACTION_SUCCEEDED -> signals.add(Signal.booleanSignal(currentEvent.getActorId(), SignalType.SUCCESSFUL_ACTION, true));
            case RATE_LIMIT_EXCEEDED -> signals.add(Signal.booleanSignal(currentEvent.getActorId(), SignalType.RATE_LIMIT_HIT, true));
            case POLICY_VIOLATION -> signals.add(Signal.booleanSignal(currentEvent.getActorId(), SignalType.POLICY_VIOLATION_REPORTED, true));
            case MANUAL_REVIEW -> signals.add(Signal.booleanSignal(currentEvent.getActorId(), SignalType.MANUAL_REVIEW_TRIGGERED, true));
            case ACCOUNT_VERIFIED -> signals.add(Signal.booleanSignal(currentEvent.getActorId(), SignalType.ACCOUNT_VERIFIED_STATUS, true));
        }

        return signals;
    }
}
