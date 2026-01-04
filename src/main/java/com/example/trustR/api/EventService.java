package com.example.trustR.api;

import com.example.trustR.api.dto.EventDTO;
import com.example.trustR.event.Event;
import com.example.trustR.event.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class EventService {

    private EventRepository eventRepository;
    private ObjectMapper objectMapper;

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void processEvent(EventDTO eventDTO) {
        Event event = new Event(
            eventDTO.getActorId(),
            EventType.valueOf(eventDTO.getEventType()),
            objectMapper.writeValueAsString(eventDTO.getMetadata())
        );

        eventRepository.saveEvent(event);
    }
}
