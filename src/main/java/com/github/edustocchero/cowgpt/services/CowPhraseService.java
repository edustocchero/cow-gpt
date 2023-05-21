package com.github.edustocchero.cowgpt.services;

import com.github.edustocchero.cowgpt.cows.Cow;
import org.springframework.stereotype.Service;

@Service
public class CowPhraseService {

    private static final char SPACE_CHAR = ' ';

    private final CowWordService wordService;

    public CowPhraseService(CowWordService wordService) {
        this.wordService = wordService;
    }

    public String buildPhrase(Cow cow, int wordQuantity) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < wordQuantity; i++) {
            String word = wordService.buildWord(cow);
            sb.append(word);
            sb.append(SPACE_CHAR);
        }

        return sb.toString();
    }
}
