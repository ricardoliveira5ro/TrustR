package com.example.trustR.api.exception;

import java.time.LocalDateTime;

public record ErrorResponse(String message, String details, LocalDateTime timestamp) {}
