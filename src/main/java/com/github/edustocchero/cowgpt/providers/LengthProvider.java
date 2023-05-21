package com.github.edustocchero.cowgpt.providers;

public interface LengthProvider {
    int MIN_LENGTH = 1;
    int MAX_LENGTH = 8;

    int provide();
}
