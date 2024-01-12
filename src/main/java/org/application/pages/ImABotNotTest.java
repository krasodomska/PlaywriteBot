package org.application.pages;

public class ImABotNotTest {
    protected static ImABotNotTest INSTANCE;
    protected static String lastHorse = "https://www.howrse.pl/elevage/chevaux/cheval?id=50047097&go=next&elevage=&comparaison=Galoper&tri=cleanName";
    protected static int howManyHorse = 0;

    protected ImABotNotTest() {
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
