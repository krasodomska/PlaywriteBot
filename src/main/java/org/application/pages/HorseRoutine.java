package org.application.pages;

import com.microsoft.playwright.Page;

public class HorseRoutine extends Horse{
    public HorseRoutine(Page page) {
        super(page);
    }

    public HorseRoutine giveBirth() {
        page.locator(".button-text-2").click();
        page.locator("#poulain-1").fill("Maly");
        page.locator(".button-text-0").click();
        page.navigate(ImABotNotTest.getLastHorse());
        return this;
    }
    public void competitionRoutine(String competitionSelector) {
        this.work();
        for (int i = 0; i < 3; i++) {
            page.locator(competitionSelector).click();
            page.getByText("Weź udział w zawodach").first().click(); //take participation in competition
        }
        this
                .pet()
                .groom()
                .giveCarrot()
                .giveWater()
                .sleepTime();

        page.locator(competitionSelector).click();
        page.getByText("Weź udział w zawodach").first().click();
        this.giveFood();
    }

    public void logRoutine(String nameOfHorse) {
        System.out.println("dailyRoutine:" + nameOfHorse);
        ImABotNotTest.setPlusOneHowManyHorse();
        ImABotNotTest.setLastHorse(page.url());
        MainManager.horseNumber++;
        checkHealth();
    }

    public HorseRoutine workRoutine() {
        this.work()
                .pet()
                .groom()
                .giveWater()
                .giveFood()
                .sleepTime();
        return this;
    }

    public HorseRoutine goGrandPrix() {
        page.locator("td.bottom:nth-child(2)").click();
        page.locator(".button-text-2").click();
        return this;
    }

    public HorseRoutine foalCare() {

        this
                .giveMilk()
                .pet()
                .giveCarrot()
                .giveWater()
                .sleepTime();
        return this;
    }

    public HorseRoutine teenagerCare() {
        return this;
    }

}
