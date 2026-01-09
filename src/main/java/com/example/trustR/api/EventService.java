package com.example.trustR.api;

import com.example.trustR.api.dto.EventDTO;
import com.example.trustR.model.Event;
import com.example.trustR.model.EventType;
import com.example.trustR.signals.SignalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class EventService {

    private final Logger LOGGER = LoggerFactory.getLogger(EventService.class);

    private EventRepository eventRepository;
    private SignalService signalService;
    private ObjectMapper objectMapper;

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Autowired
    public void setSignalService(SignalService signalService) {
        this.signalService = signalService;
    }

    public void processEvent(EventDTO eventDTO) {
        LOGGER.info("Processing Event");

        Event event = new Event(
            eventDTO.getActorId(),
            EventType.valueOf(eventDTO.getEventType()),
            objectMapper.writeValueAsString(eventDTO.getMetadata())
        );

        eventRepository.saveEvent(event);

        signalService.generateSignals(event);
    }
}
