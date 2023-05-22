package com.github.edustocchero.cowgpt.filters;

import com.github.edustocchero.cowgpt.services.RateLimiterService;
import io.github.bucket4j.ConsumptionProbe;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Duration;

@Component
@Order(1)
public class RateLimitFilter implements Filter {

    private static final String RETRY_AFTER_SECONDS_HEADER = "Retry-After-Seconds";

    private final RateLimiterService rateLimiterService;

    public RateLimitFilter(RateLimiterService rateLimiterService) {
        this.rateLimiterService = rateLimiterService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ConsumptionProbe probe = rateLimiterService.consumeOrFail();

        if (probe.isConsumed()) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        HttpServletResponse response = (HttpServletResponse) servletResponse;

        final int statusValue = HttpStatus.TOO_MANY_REQUESTS.value();
        response.setStatus(statusValue);

        long nanosToWaitForRefill = probe.getNanosToWaitForRefill();
        long seconds = Duration.ofNanos(nanosToWaitForRefill).toSeconds();
        response.setHeader(RETRY_AFTER_SECONDS_HEADER, String.valueOf(seconds));
    }
}
