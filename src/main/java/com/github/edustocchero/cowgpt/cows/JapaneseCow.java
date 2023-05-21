package com.github.edustocchero.cowgpt.cows;

public class JapaneseCow extends NonAlphabeticalCow {

    private static final Cow INSTANCE = new JapaneseCow();

    @Override
    public String getNonAlphabeticalCharacter() {
        return "モー";
    }

    public static Cow getInstance() {
        return INSTANCE;
    }
}
