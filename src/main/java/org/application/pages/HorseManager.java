package org.application.pages;

import com.microsoft.playwright.Page;

public class HorseManager extends BasePage{
    public HorseManager(Page page) {
        super(page);
    }

    public Horse horseManager(String horseName){
        HorseRoutine horse = new HorseRoutine(page);

        switch(horseName){
            case "Cutter":
                horseCompetitionRoutine(".competition-cutting", horse);
                break;
            case "Galoper":
            case "Achilles":
            case "Wesołych Świąt":
                horseCompetitionRoutine(".competition-galop", horse);
                break;
            case "Barrel":
                horseCompetitionRoutine(".competition-barrel", horse);
                break;
            case "Reiner":
                horseCompetitionRoutine(".competition-reining", horse);
                break;
            case "Trail":
                horseCompetitionRoutine(".competition-trail-class", horse);
                break;
            case "Bieg":
            case "Ulisses":
                horseCompetitionRoutine(".competition-cross", horse);
                break;
            case "Skacz":
            case "Atalanta":
                horseCompetitionRoutine(".competition-saut", horse);
                break;
            case "Trot":
                horseCompetitionRoutine(".competition-trot", horse);
                break;
            case "Tarpan":
                horseCompetitionRoutine(".competition-western-pleasure", horse);
            case "Mistrz":
                horseGrandPrix(horse);
                break;
            default:
                horseWorkRoutine(horse);
        }
        horse.nextHorse();
        horse.logRoutine(horseName);
        return horse;
    }

    protected void horseCompetitionRoutine(String selector, HorseRoutine horse) {
        try {
            horse.competitionRoutine(selector);
        }
        catch (Exception e) {
            System.out.println("I can't compete");
            horseWorkRoutine(horse);
        }
    }

    protected void horseWorkRoutine(HorseRoutine horse) {
        try{
            horse.workRoutine();
        }
        catch (Exception x) {
            System.out.println("I will try breed");
            try {
                horse
                        .giveBirth()
                        .workRoutine();
            }
            catch (Exception y) {
                System.out.println("Is it baby");
                try {
                    horse.foalCare();
                }
                catch (Exception z) {
                    System.out.println("Nothing is possible");
                    page.navigate(ImABotNotTest.getLastHorse());
                }
            }
        }
    }

    protected void horseGrandPrix(HorseRoutine horse) {
        try {
            horse.goGrandPrix();
        }
        catch (Exception e) {
            System.out.println("I can't GrandPrix");
        }
        horseWorkRoutine(horse);
    }
}
