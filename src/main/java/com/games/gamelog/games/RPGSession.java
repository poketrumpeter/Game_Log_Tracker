package com.games.gamelog.games;


import java.util.Date;

public class RPGSession extends DefaultSession{

    Date currentDate;
    String sessionTime;
    String goals;
    String gameName;
    String genre;

    //Goals

    //Quests

    //Personal Thoughts


    public RPGSession(String gameName) {
        this.sessionTime = "0";
        this.currentDate = new Date();
        this.gameName = gameName;
        this.genre = "RPG";
    }

    @Override
    public Date getCurrentDate() {
        return currentDate;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getGameName() {
        return gameName;
    }

    @Override
    public void displayDate() {
        String dateDisplay = "" + this.currentDate;
        System.out.println(dateDisplay);
    }
}
