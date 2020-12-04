package com.games.gamelog.games;

import java.util.Date;

public interface GameSession {

    public String getGameName();

    public String getReflection();

    public String getGoals();

    public String getGenre();

    Date getCurrentDate();

    public String getSessionTime();

    public void displayDate();

    public String displayInfo();

}
