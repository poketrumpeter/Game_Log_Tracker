package com.games.gamelog.games;

public interface Game {

    String getName();

    String getGenre();

    public void addSession(Session sessionAdd);

    public String getMostRecentSessionDate();
}
