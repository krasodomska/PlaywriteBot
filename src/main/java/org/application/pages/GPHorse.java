package org.application.pages;

import com.microsoft.playwright.Page;

public class GPHorse extends Horse {
    public GPHorse(Page page) {
        super(page);
    }

    public GPHorse goGrandPrix() {
        page.locator("td.bottom:nth-child(2)").click();
        page.locator(".button-text-2").click();
        return this;
    }

    public GPHorse dailyRoutine() {
        this
                .goGrandPrix()
                .work()
                .groom()
                .giveCarrot()
                .giveWater()
                .pet()
                .giveFood()
                .sleepTime();
        System.out.println("dailyRoutine: Mistrz");

        return this;
    }
}
