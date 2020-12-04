package com.games.gamelog.games;

import com.games.gamelog.games.displays.GameDisplays;

import java.util.Date;

public abstract class DefaultSession implements GameSession {

    Date currentDate;
    String sessionTime;
    String goals;
    String gameName;
    String genre;
    GameDisplays display;

    //Personal Thoughts
    String reflection;

    public DefaultSession(String gameName, String genre, GameDisplays display) {
        currentDate = new Date();
        sessionTime = "0";
        goals = "";
        reflection = "";
        this.gameName = gameName;
        this.genre = genre;
        this.display = display;
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

    public void setSessionTime(String time) {
        this.sessionTime = time;
    }

    public String getSessionTime(){
        return sessionTime;
    }

    @Override
    public String getGenre() {
        return genre;
    }


    public GameDisplays getDisplay() {
        return display;
    }

    public void setDisplay(GameDisplays display) {
        this.display = display;
    }

    @Override
    public void displayDate() {
        String dateDisplay = "" + this.currentDate;
        System.out.println(dateDisplay);
    }


    @Override
    public String displayInfo() {
        return this.display.displayInfo();
    }

}
