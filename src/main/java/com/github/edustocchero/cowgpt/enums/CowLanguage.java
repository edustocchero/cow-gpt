package com.github.edustocchero.cowgpt.enums;

import com.github.edustocchero.cowgpt.cows.Cow;
import com.github.edustocchero.cowgpt.cows.EnglishCow;
import com.github.edustocchero.cowgpt.cows.JapaneseCow;
import com.github.edustocchero.cowgpt.cows.PortugueseCow;

public enum CowLanguage implements CowStrategy {
    EN {
        @Override
        public Cow getCow() {
            return EnglishCow.getInstance();
        }
    },
    PT {
        @Override
        public Cow getCow() {
            return PortugueseCow.getInstance();
        }
    },
    JP {
        @Override
        public Cow getCow() {
            return JapaneseCow.getInstance();
        }
    }
}
