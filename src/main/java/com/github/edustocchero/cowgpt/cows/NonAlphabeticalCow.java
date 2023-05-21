package com.github.edustocchero.cowgpt.cows;

public abstract class NonAlphabeticalCow implements Cow {

    @Override
    public Boolean isAlphabetical() {
        return false;
    }

    @Override
    public abstract String getNonAlphabeticalCharacter();

    @Override
    public String getInitialCharacter() {
        return null;
    }

    @Override
    public String getMiddleCharacter() {
        return null;
    }

    @Override
    public String getFinalCharacter() {
        return null;
    }
}
