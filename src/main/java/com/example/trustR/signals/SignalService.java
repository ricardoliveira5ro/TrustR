package com.example.trustR.signals;

import com.example.trustR.api.EventRepository;
import com.example.trustR.model.Event;
import com.example.trustR.model.Signal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignalService {

    private final Logger LOGGER = LoggerFactory.getLogger(SignalService.class);

    private SignalGenerator signalGenerator;
    private SignalRepository signalRepository;
    private EventRepository eventRepository;

    @Autowired
    public void setSignalGenerator(SignalGenerator signalGenerator) {
        this.signalGenerator = signalGenerator;
    }

    @Autowired
    public void setSignalRepository(SignalRepository signalRepository) {
        this.signalRepository = signalRepository;
    }

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void generateSignals(Event currentEvent) {
        LOGGER.info("Generating Signals");

        List<Event> pastEvents = eventRepository.getLastDayEventsByActorId(currentEvent.getActorId(), currentEvent.getOccurredAt());

        List<Signal> signals = signalGenerator.generateSignals(currentEvent, pastEvents);
        signals.forEach(s -> signalRepository.saveSignal(s));
    }
}
