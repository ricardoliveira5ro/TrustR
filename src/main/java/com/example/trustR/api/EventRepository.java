package com.example.trustR.api;

import com.example.trustR.event.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EventRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(EventRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveEvent(Event event) {
        entityManager.persist(event);

        LOGGER.info("Event {} processed", event.getEventId());
    }
}
