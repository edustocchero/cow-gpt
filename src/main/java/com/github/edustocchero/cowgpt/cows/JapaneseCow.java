package com.github.edustocchero.cowgpt.cows;

public class JapaneseCow extends NonAlphabeticalCow {

    public static final Cow INSTANCE = new JapaneseCow();

    @Override
    public String getNonAlphabeticalCharacter() {
        return "モー";
    }
}
