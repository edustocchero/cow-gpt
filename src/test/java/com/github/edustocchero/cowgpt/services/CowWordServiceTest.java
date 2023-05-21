package com.github.edustocchero.cowgpt.services;

import com.github.edustocchero.cowgpt.cows.Cow;
import com.github.edustocchero.cowgpt.cows.EnglishCow;
import com.github.edustocchero.cowgpt.cows.JapaneseCow;
import com.github.edustocchero.cowgpt.cows.PortugueseCow;
import com.github.edustocchero.cowgpt.providers.LengthProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CowWordServiceTest {


    private LengthProvider provider;

    private CowWordService service;

    @BeforeEach
    void beforeEach() {
        provider = Mockito.mock(LengthProvider.class);
        service = new CowWordService(provider);
    }

    @Test
    @DisplayName("Should not call lengthProvider.provide() if is not an alphabetical cow")
    void shouldNotCallLengthProvider_ifIsNonAlphabetical() {
        Cow cow = JapaneseCow.getInstance();



        service.buildWord(cow);



        Mockito.verify(provider, Mockito.never())
                .provide();
    }

    @Test
    @DisplayName("Should call lengthProvider.provide() if is an alphabetical cow")
    void shouldCallLengthProvider_ifIsAlphabetical() {
        Mockito.doReturn(LengthProvider.MIN_LENGTH)
                .when(provider)
                .provide();

        Cow cow = EnglishCow.getInstance();



        service.buildWord(cow);



        Mockito.verify(provider, Mockito.times(1))
                .provide();
    }

    @Test
    @DisplayName("Validates the length of words generated by the CowWordService")
    void wordLengthTest() {
        Mockito.when(provider.provide())
                .thenReturn(LengthProvider.MIN_LENGTH)
                .thenReturn(3)
                .thenReturn(LengthProvider.MAX_LENGTH);

        Cow cow1 = EnglishCow.getInstance();
        Cow cow2 = PortugueseCow.getInstance();



        String word1 = service.buildWord(cow1);
        String word2 = service.buildWord(cow2);
        String word3 = service.buildWord(cow1);



        int word1ExpectedLength = 3;
        int word2ExpectedLength = 5;
        int word3ExpectedLength = 10;

        assertEquals(word1ExpectedLength, word1.length());
        assertEquals(word2ExpectedLength, word2.length());
        assertEquals(word3ExpectedLength, word3.length());
    }
}
