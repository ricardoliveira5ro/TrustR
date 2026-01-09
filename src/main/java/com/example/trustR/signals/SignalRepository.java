package com.example.trustR.signals;

import com.example.trustR.model.Signal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public class SignalRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(SignalRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveSignal(Signal signal) {
        entityManager.persist(signal);

        LOGGER.info("Signal {} processed", signal.getSignalId());
    }

    public Signal getSignal(UUID signalId) {
        return entityManager.find(Signal.class, signalId);
    }
}
