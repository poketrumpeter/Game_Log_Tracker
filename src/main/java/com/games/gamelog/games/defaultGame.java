package com.games.gamelog.games;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class defaultGame implements Game{

    private String name;
    private String genre;
    private int timePlayed;
    ArrayList<GameSession> sessions;

    public defaultGame(){}

    public defaultGame(String name, String genre) {
        this.name = name;
        this.genre = genre;
        this.timePlayed = 0;
        this.sessions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    @Override
    public ArrayList<GameSession> getSessions() {
        return this.sessions;
    }


    public void calculateTime(){
        int sum = 0;
        for(int i = 0; i < sessions.size();i++){
            String stringSessionTime = sessions.get(i).getSessionTime();
            int intSessionTime = Integer.parseInt(stringSessionTime);
            sum = sum + intSessionTime;
        }
        setTimePlayed(sum);
    }

    public String displayTime(){
        calculateTime();
        int min = (int) (this.timePlayed /60 % 60);
        int hour = (int) (this.timePlayed / 3600);
        int sec = (int) (this.timePlayed % 60);
        String output = String.format("%d : %d : %d", hour, min, sec);

        return output;
    }

    public void addSession(GameSession sessionAdd){
        this.sessions.add(sessionAdd);
    }

    @Override
    public String getMostRecentSessionDate(){

        ArrayList<Date> dates = new ArrayList<>();

        if (this.sessions.isEmpty()){
            return "";
        }

        for (GameSession session : this.sessions){
            dates.add(session.getCurrentDate());
        }

        Date recentDate = Collections.max(dates);


        return ""+recentDate;
    }
}
