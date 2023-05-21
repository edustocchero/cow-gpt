package com.github.edustocchero.cowgpt.cases;

import com.github.edustocchero.cowgpt.cows.Cow;
import com.github.edustocchero.cowgpt.enums.CowLanguage;
import com.github.edustocchero.cowgpt.services.CowPhraseService;
import org.springframework.stereotype.Service;

@Service
public class CowResponseCase {

    private final CowPhraseService cowPhraseService;

    public CowResponseCase(CowPhraseService cowPhraseService) {
        this.cowPhraseService = cowPhraseService;
    }

    public String handle(String query, CowLanguage cowLanguage) {
        Cow cow = cowLanguage.getCow();

        int complexity = queryComplexity(query);

        String response = cowPhraseService.buildPhrase(cow, complexity);
        return response;
    }

    private int queryComplexity(String query) {
        int length = query.length();

        double complexity = Math.pow(length, 2) / length * 2;

        return (int) Math.abs(complexity);
    }
}
