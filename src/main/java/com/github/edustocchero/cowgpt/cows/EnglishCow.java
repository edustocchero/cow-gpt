package com.github.edustocchero.cowgpt.cows;

public class EnglishCow extends AlphabeticalCow {

    private static final Cow INSTANCE = new EnglishCow();

    @Override
    public String getInitialCharacter() {
        return "m";
    }

    @Override
    public String getMiddleCharacter() {
        return "o";
    }

    @Override
    public String getFinalCharacter() {
        return "o";
    }

    public static Cow getInstance() {
        return INSTANCE;
    }
}
