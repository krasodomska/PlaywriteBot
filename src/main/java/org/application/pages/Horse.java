package org.application.pages;

import com.microsoft.playwright.Page;

public class Horse extends BasePage {
    public Horse(Page page) {
        super(page);
    }


    protected Horse giveWater() {
        page.locator("#boutonBoire").click();
        return this;
    }

    protected Horse pet() {
        page.locator("#boutonCaresser").click();
        return this;
    }

    protected Horse giveCarrot() {
        page.locator("#boutonCarotte").click();
        return this;
    }

    protected Horse groom() {
        page.locator("#boutonPanser").click();
        return this;
    }

    protected Horse giveEnergizer() {
        page.locator("#boutonMash").click();
        return this;
    }

    protected Horse giveFood() {
        page.locator("#boutonNourrir").click();
        Integer foodAmount = 0;
        if (!page.getByText("Uwaga:").isVisible() && !page.getByText("Nie karm").isVisible()) {
            foodAmount = Integer.parseInt(page.locator("strong.section-fourrage").textContent().trim()) + 1;
        } else if (!page.getByText("Nie karm").isVisible()) {
            foodAmount = 21;
        }

        String foodLocator = String.format("#haySlider > ol:nth-child(1) > li:nth-child(%d) > span", foodAmount);
        page.locator(foodLocator).click();
        try {
            Integer oatsAmount = Integer.parseInt(page.locator("strong.section-avoine").textContent().trim()) + 1;
            String oatsLocator = String.format("#oatsSlider > ol:nth-child(1) > li:nth-child(%d) > span", oatsAmount);
            page.locator(oatsLocator).click();
        } catch (Exception e) {
            System.out.println("Im teenager");
        }

        page.locator("#feed-button > span:nth-child(1) > span:nth-child(1) > span:nth-child(1)").click();
        return this;
    }

    protected Horse work() {
        if (page.locator("#boutonMissionMontagne").isVisible()) page.locator("#boutonMissionMontagne").click();
        if (page.locator("#boutonMissionEquus").isVisible()) page.locator("#boutonMissionEquus").click();
        if (page.locator("#boutonMissionForet").isVisible()) page.locator("#boutonMissionForet").click();
        System.out.println("I was working");
        return this;
    }

    protected Horse sleepTime() {
        page.locator("#boutonCoucher").click();
        return this;
    }


    protected Horse stableCheck() {
        if (page.getByText("Zarejestruj swojego konia w ośrodku jeździeckim, aby położyć go spać już teraz!").isVisible()) {
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


    public Horse nextHorse() {
        page.click("#nav-next");
        return this;
    }


    protected Horse giveMilk() {
        page.locator("#boutonAllaiter").click();
        return this;
    }

    protected boolean sleepMode() {
        return page.locator("#boutonCoucher").getAttribute("class").contains("action-disabled") && !page.getByText("Poślij").isVisible();
    }


    protected Horse checkHealth() {
        int health = Integer.parseInt(page.locator("#sante").textContent().trim());
        if (health < 50) System.out.println("Alert health: " + health + "my url: " + page.url());
        else {
            System.out.println("My health: " + health);
        }
        return this;

    }

}
