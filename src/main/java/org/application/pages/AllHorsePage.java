package org.application.pages;

import com.microsoft.playwright.Page;

public class AllHorsePage extends BasePage {
    public static int horseNumber = 0;

    public AllHorsePage(Page page) {
        super(page);
    }

    public AllHorsePage getAllGPHorses() {
        page.getByText("Mistrz").all().forEach(horse-> {
            horse.click();
            GPHorse gpHorse = new GPHorse(page);
            gpHorse.dailyRoutine();
            page.navigate("https://www.howrse.pl/elevage/chevaux/?elevage=all-horses");
            horseNumber++;
        });
        return this;
    }

    public AllHorsePage getAllGod() {
        GodHorses god = new GodHorses(page);
        god.dailyRoutine();
        return this;
    }

    public AllHorsePage getAllDraft() {
        page.getByText("ziemniak").all().forEach(horse-> {
            horse.click();
            DraftHorse draftHorse = new DraftHorse(page);
            draftHorse.dailyRoutine();
            page.navigate("https://www.howrse.pl/elevage/chevaux/?elevage=all-horses");
            horseNumber++;
        });
        return this;
    }

    public AllHorsePage getAllSideBreed() {
        SideBreedHorse side = new SideBreedHorse(page);
        side.dailyRoutine();
        return this;
    }


}
