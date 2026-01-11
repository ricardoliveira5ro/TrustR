package com.example.trustR.signals;

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

    @Autowired
    public void setSignalGenerator(SignalGenerator signalGenerator) {
        this.signalGenerator = signalGenerator;
    }

    @Autowired
    public void setSignalRepository(SignalRepository signalRepository) {
        this.signalRepository = signalRepository;
    }

    public void generateSignals(Event currentEvent) {
        LOGGER.info("Generating Signals");

        // SignalEngine to generate signals based on event
        List<Signal> signals = signalGenerator.generateSignals(currentEvent);
        signals.forEach(s -> signalRepository.saveSignal(s));
    }
}
