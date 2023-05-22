package com.github.edustocchero.cowgpt.services;

import io.github.bucket4j.ConsumptionProbe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateLimiterServiceTest {

    RateLimiterService service = new RateLimiterService();

    @Test
    @DisplayName("Second probe should not be consumed")
    void shouldNotConsume() {
        ConsumptionProbe probe1 = service.consume();
        ConsumptionProbe probe2 = service.consume();



        assertTrue(probe1.isConsumed());
        assertFalse(probe2.isConsumed());
    }
}
