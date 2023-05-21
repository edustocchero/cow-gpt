package com.github.edustocchero.cowgpt.providers;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomLengthProvider implements LengthProvider {

    private final Random random = new Random();

    @Override
    public int provide() {
        return random.ints(MIN_LENGTH, MAX_LENGTH)
                .findFirst()
                .orElse(MIN_LENGTH);
    }
}
