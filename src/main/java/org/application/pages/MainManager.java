package org.application.pages;

import com.microsoft.playwright.*;

public class MainManager {
    public static int horseNumber = 0;
    static Page page;


    protected MainManager horseCare(){
        while(horseNumber < 50) {
            HorseManager manager = new HorseManager(page);
            if (ImABotNotTest.getHowManyHorse() < 10) {
                manager.horseManager(page.locator(".horse-name").textContent().trim());
            } else {
                ImABotNotTest.setHowManyHorse(0);
                page.close();
                horseLoop();
            }
        }

        return this;
    }

    public static void horseLoop() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
            BrowserContext context = browser.newContext();
            context.setDefaultTimeout(10);
            page = browser.newPage();

            MainManager allHorsePage = new EntryPage(page)
                    .open()
                    .acceptCookies()
                    .clickOnLoginTab()
                    .fillLogin()
                    .fillPassword()
                    .clickLoginButton()
                    .goToHorseLink(ImABotNotTest.getLastHorse())
                    .horseCare();
        }
    }


}
