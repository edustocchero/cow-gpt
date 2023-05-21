package com.github.edustocchero.cowgpt.cows;

public abstract class AlphabeticalCow implements Cow {

    @Override
    public Boolean isAlphabetical() {
        return true;
    }

    @Override
    public String getNonAlphabeticalCharacter() {
        return null;
    }

    @Override
    public abstract String getFinalCharacter();

    @Override
    public abstract String getInitialCharacter();

    @Override
    public abstract String getMiddleCharacter();
}
