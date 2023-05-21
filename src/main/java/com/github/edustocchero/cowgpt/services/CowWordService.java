package com.github.edustocchero.cowgpt.services;

import com.github.edustocchero.cowgpt.cows.Cow;
import com.github.edustocchero.cowgpt.providers.LengthProvider;
import org.springframework.stereotype.Service;

@Service
public class CowWordService {

    private final LengthProvider lengthProvider;

    public CowWordService(LengthProvider numberProvider) {
        this.lengthProvider = numberProvider;
    }

    public String buildWord(Cow cow) {
        if (!cow.isAlphabetical()) {
            return cow.getNonAlphabeticalCharacter();
        }

        final int length = lengthProvider.provide();

        StringBuilder sb = new StringBuilder();
        sb.append(cow.getInitialCharacter());

        for (int i = 0; i < length; i++) {
            sb.append(cow.getMiddleCharacter());
        }

        sb.append(cow.getFinalCharacter());

        return sb.toString();
    }
}
