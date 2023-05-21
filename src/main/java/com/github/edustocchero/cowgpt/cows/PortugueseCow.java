package com.github.edustocchero.cowgpt.cows;

public class PortugueseCow extends AlphabeticalCow {

    private static final Cow INSTANCE = new PortugueseCow();

    @Override
    public String getInitialCharacter() {
        return "m";
    }

    @Override
    public String getMiddleCharacter() {
        return "u";
    }

    @Override
    public String getFinalCharacter() {
        return "u";
    }

    public static Cow getInstance() {
        return INSTANCE;
    }
}
