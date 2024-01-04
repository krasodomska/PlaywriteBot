package org.application.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class SideBreedHorse extends Horse{
    public SideBreedHorse(Page page) {
        super(page);
    }

    @Override
    public Horse dailyRoutine() {

        getAllSideBreed("Cutter", ".competition-cutting");
        getAllSideBreed("Galoper", ".competition-galop");
        getAllSideBreed("Barrel", ".competition-barrel");
        getAllSideBreed("Reiner", ".competition-reining");
        getAllSideBreed("Trail", ".competition-trail-class");
        getAllSideBreed("Bieg", ".competition-cross");
        getAllSideBreed("Skacz", ".competition-saut");
        getAllSideBreed("Trot",".competition-trot");
        return this;
    }

    private void breedRoutine(String nameOfBreed, String competitionSelector) {
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
        System.out.println("dailyRoutine:" + nameOfBreed);
    }


    private SideBreedHorse getAllSideBreed(String breed, String competition) {
        List<Locator> horses = page.getByText(breed).all();
        for(Locator horse: horses){
            try {
                horse.click();
                this.breedRoutine(breed, competition);
                page.navigate("https://www.howrse.pl/elevage/chevaux/?elevage=all-horses");
            }
            catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("Error at: " +page.url());
            }
            page.navigate("https://www.howrse.pl/elevage/chevaux/?elevage=all-horses");
            AllHorsePage.horseNumber++;

        }
        return this;
    }
}
