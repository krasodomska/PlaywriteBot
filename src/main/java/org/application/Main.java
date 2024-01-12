package org.application;


import org.application.pages.MainManager;

public class Main {
    public static void main(String[] args) {
        MainManager.horseLoop();
        System.out.println("I click on " + MainManager.horseNumber + " horses");

    }
}




