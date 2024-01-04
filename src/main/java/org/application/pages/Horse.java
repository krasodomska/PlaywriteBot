package org.application.pages;

import com.microsoft.playwright.Page;

public abstract class Horse extends BasePage {
    public Horse(Page page) {
        super(page);
    }

    //.button-text-2 -> selector ozrebienie
    //#poulain-1 -> gdzie wpisac  imie konika
    //.button-text-0 -> selektor idz do źróbka
    //#boutonAllaiter -> daj butle

    public Horse giveWater() {
        page.locator("#boutonBoire").click();
        return this;
    }

    public Horse pet() {
        page.locator("#boutonCaresser").click();
        return this;
    }

    public Horse giveCarrot() {
        page.locator("#boutonCarotte").click();
        return this;
    }

    public Horse groom() {
        page.locator("#boutonPanser").click();
        return this;
    }

    public Horse giveEnergizer() {
        page.locator("#boutonMash").click();
        return this;
    }

    public Horse giveFood() {
        page.locator("#boutonNourrir").click();
        Integer foodAmount = 0;
        if(!page.getByText("Uwaga: jeden z Twoich koni ma niedowagę").isVisible())
        {
            foodAmount = Integer.parseInt(page.locator("strong.section-fourrage").textContent().trim()) + 1;
        }
        else {
            foodAmount = 21;
        }
        String foodLocator = String.format("#haySlider > ol:nth-child(1) > li:nth-child(%d) > span", foodAmount);
        page.locator(foodLocator).click();

        Integer oatsAmount = Integer.parseInt(page.locator("strong.section-avoine").textContent().trim()) + 1;
        String oatsLocator = String.format("#oatsSlider > ol:nth-child(1) > li:nth-child(%d) > span", oatsAmount);
        page.locator(oatsLocator).click();

        page.locator("#feed-button > span:nth-child(1) > span:nth-child(1) > span:nth-child(1)").click();
        return this;
    }

    public Horse work() {
        if(page.locator("#boutonMissionMontagne").isVisible()) page.locator("#boutonMissionMontagne").click();
        if(page.locator("#boutonMissionEquus").isVisible()) page.locator("#boutonMissionEquus").click();
        if(page.locator("#boutonMissionForet").isVisible()) page.locator("#boutonMissionForet").click();
        return this;
    }

    public Horse sleepTime() {
        page.locator("#boutonCoucher").click();
        return this;
    }



    public Horse stableCheck() {
        if(page.getByText("Zarejestruj swojego konia w ośrodku jeździeckim, aby położyć go spać już teraz!").isVisible()) {
            page.locator(".action-style-2 > span:nth-child(1)").click();
            page.locator("#fourrageCheckbox").click();
            page.locator("#avoineCheckbox").click();
            page.locator("#carotteCheckbox").click();
            page.locator("#mashCheckbox").click();
            page.locator("button.button:nth-child(6) > span:nth-child(1) > span:nth-child(1) > span:nth-child(1)").click(); //serch
            page.getByText("'"); //cheapest stable for 10 days
            page.locator("#agi-100426848001701411164 > span:nth-child(1) > span:nth-child(1) > span:nth-child(1) > span:nth-child(1) > img:nth-child(2)").click(); //select
            //zatwierdź

        }
        return this;
    }


    public void competitionRoutine(String competitionSelector) {
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
    }

    public void logRoutine(String nameOfHorse){
        System.out.println("dailyRoutine:" + nameOfHorse);
        ImABotNotTest.setPlusOneHowManyHorse();
        ImABotNotTest.setLastHorse(page.url());
        AllHorsePage.horseNumber++;
    }

    public Horse goGrandPrix() {
        page.locator("td.bottom:nth-child(2)").click();
        page.locator(".button-text-2").click();
        return this;
    }

    public abstract Horse dailyRoutine();

}
