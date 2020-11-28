package com.games.gamelog.games;

import java.util.ArrayList;

public interface Game {

    String getName();

    String getGenre();

    ArrayList<GameSession> getSessions();

    public void addSession(GameSession sessionAdd);

    public String getMostRecentSessionDate();
}
