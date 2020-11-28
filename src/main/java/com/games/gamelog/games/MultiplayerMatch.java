package com.games.gamelog.games;

public class MultiplayerMatch {

    String kills;
    String deaths;
    String assists;
    boolean victory;

    public MultiplayerMatch() {
    }

    public MultiplayerMatch(String kills, String deaths, String assists, boolean victory) {
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.victory = victory;
    }

    public String getKills() {
        return kills;
    }

    public void setKills(String kills) {
        this.kills = kills;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getAssists() {
        return assists;
    }

    public void setAssists(String assists) {
        this.assists = assists;
    }

    public boolean isVictory() {
        return victory;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
    }
}
