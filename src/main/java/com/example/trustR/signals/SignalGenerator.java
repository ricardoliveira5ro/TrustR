package com.example.trustR.signals;

import com.example.trustR.model.Event;
import com.example.trustR.model.EventType;
import com.example.trustR.model.Signal;
import com.example.trustR.model.SignalType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class SignalGenerator {

    private List<Signal> signals;

    public List<Signal> generateSignals(Event currentEvent, List<Event> events) {
        // Reset list
        signals = new ArrayList<>();

        mapEventSignal(currentEvent, events);

        return signals;
    }

    private void mapEventSignal(Event currentEvent, List<Event> events) {
        switch (currentEvent.getEventType()) {
            case ACTION_FAILED -> generateFailedActionSignal(currentEvent, events);
            case ACTION_SUCCEEDED -> generateSuccessRateSignal(currentEvent, events);
            case RATE_LIMIT_EXCEEDED -> generateRateLimitHitsSignal(currentEvent, events);
            case POLICY_VIOLATION -> generatePolicyViolationSignal(currentEvent, events);
        }
    }

    private void generateFailedActionSignal(Event currentEvent, List<Event> events) {
        // Instant Signal
        signals.add(Signal.booleanSignal(currentEvent.getActorId(), SignalType.FAILED_ACTION_ATTEMPT, true));

        // Time Window Signals
        Predicate<Event> filter5min = e -> e.getEventType() == EventType.ACTION_FAILED && e.getOccurredAt().isAfter(currentEvent.getOccurredAt().minusMinutes(5));
        long failedActions5MinCount = events.stream().filter(filter5min).count();

        Predicate<Event> filter1hr = e -> e.getEventType() == EventType.ACTION_FAILED && e.getOccurredAt().isAfter(currentEvent.getOccurredAt().minusHours(1));
        long failedActions1HrCount = events.stream().filter(filter1hr).count();

        signals.add(Signal.numericSignal(currentEvent.getActorId(), SignalType.FAILED_ACTION_ATTEMPTS_5_MIN, (double) failedActions5MinCount));
        signals.add(Signal.numericSignal(currentEvent.getActorId(), SignalType.FAILED_ACTION_ATTEMPTS_1_HOUR, (double) failedActions1HrCount));
    }

    private void generateSuccessRateSignal(Event currentEvent, List<Event> events) {
        // Instant Signal
        signals.add(Signal.booleanSignal(currentEvent.getActorId(), SignalType.SUCCESSFUL_ACTION, true));

        // Time Window Signals
        var actionFilteredEvents = events.stream().filter(e -> e.getEventType() == EventType.ACTION_SUCCEEDED || e.getEventType() == EventType.ACTION_FAILED).toList();
        int actionsCount = actionFilteredEvents.size();

        Predicate<Event> filterActionsSucceeded5Min = e -> e.getEventType() == EventType.ACTION_SUCCEEDED && e.getOccurredAt().isAfter(currentEvent.getOccurredAt().minusMinutes(5));
        long successfulActions5MinCount = actionFilteredEvents.stream().filter(filterActionsSucceeded5Min).count();

        signals.add(Signal.numericSignal(currentEvent.getActorId(), SignalType.SUCCESS_RATE_5_MIN, (double) (successfulActions5MinCount / actionsCount)));
    }

    private void generateRateLimitHitsSignal(Event currentEvent, List<Event> events) {
        // Instant Signal
        signals.add(Signal.booleanSignal(currentEvent.getActorId(), SignalType.RATE_LIMIT_HIT, true));

        // Time Window Signals
        Predicate<Event> filter10min = e -> e.getEventType() == EventType.RATE_LIMIT_EXCEEDED && e.getOccurredAt().isAfter(currentEvent.getOccurredAt().minusMinutes(10));
        long rateHits10MinCount = events.stream().filter(filter10min).count();

        signals.add(Signal.numericSignal(currentEvent.getActorId(), SignalType.RATE_LIMIT_HITS_10_MIN, (double) rateHits10MinCount));
    }

    private void generatePolicyViolationSignal(Event currentEvent, List<Event> events) {
        // Instant Signal
        signals.add(Signal.booleanSignal(currentEvent.getActorId(), SignalType.POLICY_VIOLATION_REPORTED, true));

        // Time Window Signals
        long policyViolations24HCount = events.stream().filter(e -> e.getEventType() == EventType.POLICY_VIOLATION).count();

        signals.add(Signal.numericSignal(currentEvent.getActorId(), SignalType.POLICY_VIOLATIONS_24_HOURS, (double) policyViolations24HCount));
    }
}
