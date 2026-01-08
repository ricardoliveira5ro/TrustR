package com.example.trustR.signals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SignalService {

    private final Logger LOGGER = LoggerFactory.getLogger(SignalService.class);

    public void generateSignals() {
        LOGGER.info("Generating Signals");
    }
}
