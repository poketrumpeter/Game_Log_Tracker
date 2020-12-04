package com.games.gamelog.games.Gaming;

import com.games.gamelog.games.Sessions.GameSession;

import java.util.ArrayList;

public interface Game {

    String getName();

    String getGenre();

    ArrayList<GameSession> getSessions();

    public String displayTime();

    public void addSession(GameSession sessionAdd);

    public String getMostRecentSessionDate();
}
