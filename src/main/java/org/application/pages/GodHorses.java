package org.application.pages;

import com.microsoft.playwright.Page;

public class GodHorses extends Horse {
    public GodHorses(Page page) {
        super(page);
    }

    @Override
    public Horse dailyRoutine() {
//        godRoutine("Achilles", ".competition-galop");
        godRoutine("Ulisses", ".competition-cross");
        godRoutine("Atalanta", ".competition-saut");
        godRoutine("Tarpan", ".competition-western-pleasure");
        godRoutine("Mango", ".competition-cutting");

        return this;
    }

    private void godRoutine(String nameOfGod, String competitionSelector) {
        page.getByText(nameOfGod).click();
        for (int i = 0; i < 3; i++) {
            page.locator(competitionSelector).click();
            page.getByText("Weź udział w zawodach").first().click(); //take participation in competition
        }
        this.work()
                .pet()
                .groom()
                .giveCarrot()
                .giveWater()
                .sleepTime();

        page.locator(competitionSelector).click();
        page.getByText("Weź udział w zawodach").first().click();
        this.giveFood();
        System.out.println("dailyRoutine:" + nameOfGod);
        page.navigate("https://www.howrse.pl/elevage/chevaux/?elevage=all-horses");
        AllHorsePage.horseNumber++;
    }

}
