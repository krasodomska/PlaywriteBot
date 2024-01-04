package org.application.pages;

import com.microsoft.playwright.Page;

public class DraftHorse extends Horse{

    public DraftHorse(Page page) {

        super(page);
    }

    @Override
    public Horse dailyRoutine() {
        this.work()
                .pet()
                .groom()
                .giveWater()
                .giveFood()
                .sleepTime();
        System.out.println("dailyRoutine: ziemniak");
        return this;
    }
}
