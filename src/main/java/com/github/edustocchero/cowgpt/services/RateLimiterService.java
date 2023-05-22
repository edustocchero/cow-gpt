package com.github.edustocchero.cowgpt.services;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import io.github.bucket4j.Refill;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RateLimiterService {

    private static final Duration TEN_SECONDS = Duration.ofSeconds(10);
    private static final Integer MAX_TOKENS = 1;

    private final Refill refill = Refill.intervally(MAX_TOKENS, TEN_SECONDS);
    private final Bandwidth consumeLimit = Bandwidth.classic(MAX_TOKENS, refill);

    private final Bucket bucket = Bucket.builder()
            .addLimit(consumeLimit)
            .build();

    public ConsumptionProbe consumeOrFail() {
        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);
        return probe;
    }
}
