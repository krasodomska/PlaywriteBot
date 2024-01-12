package org.application.pages;

import com.microsoft.playwright.Page;
import org.application.game.PlayerSettings;

public class EntryPage extends BasePage {
    protected final String address = "https://www.howrse.pl/";
    public EntryPage(Page page) {
        super(page);
    }

    public EntryPage open() {
        page.navigate(address);
        return this;
    }

    public EntryPage acceptCookies() {
        page.getByText("Wyrażam zgodę na stosowanie plików cookies").click();
        return this;
    }
    public EntryPage clickOnLoginTab() {
        page.locator("#header-login-label").click();
        return this;
    }

    public EntryPage fillLogin() {
        page.locator("#login").fill(PlayerSettings.LOGIN);
        return this;
    }

    public EntryPage fillPassword() {
        page.locator("#password").fill(PlayerSettings.PASSWORD);
        return this;
    }

    public EntryPage clickLoginButton() {
        page.locator("#authentificationSubmit > span > span > span").click();
        return this;
    }

    public MainManager goToHorse() {
        page.navigate("https://www.howrse.pl/elevage/chevaux/?elevage=all-horses");
        return new MainManager();
    }

    public MainManager goToHorseLink(String horseLink) {
        page.navigate(horseLink);
        return new MainManager();
    }


}
