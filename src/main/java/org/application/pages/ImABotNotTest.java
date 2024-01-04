package org.application.pages;

public class ImABotNotTest {
    private static ImABotNotTest INSTANCE;
    private static String lastHorse = "";
    private static int howManyHorse = 0;

    private ImABotNotTest() {
    }

    public static ImABotNotTest getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ImABotNotTest();
        }

        return INSTANCE;
    }

    public static String getLastHorse() {
        return lastHorse;
    }

    public static int getHowManyHorse() {
        return howManyHorse;
    }

    public static void setLastHorse(String lastHorse) {
        ImABotNotTest.lastHorse = lastHorse;
    }

    public static void setHowManyHorse(int howManyHorse) {
        ImABotNotTest.howManyHorse = howManyHorse;
    }

    public static void setPlusOneHowManyHorse() {
        ImABotNotTest.howManyHorse++;
    }
}
