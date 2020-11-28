package com.games.gamelog.games;

import java.util.Date;

public abstract class DefaultSession implements GameSession {

    Date currentDate;
    String sessionTime;
    String goals;
    String gameName;
    String genre;

    //Personal Thoughts
    String reflection;

    public DefaultSession(String gameName, String genre) {
        currentDate = new Date();
        sessionTime = "0";
        goals = "";
        reflection = "";
        this.gameName = gameName;
        this.genre = genre;
    }

    @Override
    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    @Override
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @Override
    public String getReflection() {
        return reflection;
    }

    public void setReflection(String reflection) {
        this.reflection = reflection;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public void displayDate() {
        String dateDisplay = "" + this.currentDate;
        System.out.println(dateDisplay);
    }


}
