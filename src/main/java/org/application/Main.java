package org.application;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.application.pages.AllHorsePage;
import org.application.pages.EntryPage;

public class Main {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page page = browser.newPage();

            AllHorsePage allHorsePage = new EntryPage(page)
                    .open()
                    .acceptCookies()
                    .clickOnLoginTab()
                    .fillLogin()
                    .fillPassword()
                    .clickLoginButton()
                    .goToHorse()
                    .getAllGPHorses()
                    .getAllGod()
                    .getAllDraft()
                    .getAllSideBreed();

            System.out.println("I click on "+AllHorsePage.horseNumber+" horses");

        }
    }
}