package com.games.gamelog.games;

import java.util.ArrayList;

public class defaultGame implements Game{

    private String name;
    private String genre;
    private float timePlayed;
    ArrayList<Session> sessions;

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

    public float getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(float timePlayed) {
        this.timePlayed = timePlayed;
    }

    public String displayTime(){
        int min = (int) (this.timePlayed /60);
        int hour = (int) (this.timePlayed / 120);
        int sec = (int) (this.timePlayed % 60);
        String output = String.format("%d : %d : %d", hour, min, sec);

        return output;
    }
}
