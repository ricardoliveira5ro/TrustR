package com.example.trustR.api;

import com.example.trustR.model.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

    public List<Event> getLastDayEventsByActorId(UUID eventId, String actorId, LocalDateTime eventDate) {
        String sql = "SELECT e FROM Event e WHERE e.actorId = :actorId AND " +
                "e.occurredAt >= :lastDay AND " +
                "ORDER BY e.occurredAt DESC";

        Query query = entityManager.createQuery(sql, Event.class)
                                    .setParameter("actorId", actorId)
                                    .setParameter("lastDay", eventDate.minusDays(1));

        return query.getResultList();
    }
}
