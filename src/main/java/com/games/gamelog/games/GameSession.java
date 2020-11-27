package com.games.gamelog.games;

import java.util.Date;

public interface GameSession {

    public String getGameName();

    public String getReflection();

    Date getCurrentDate();

    public void displayDate();

    public String displayInfo();

}
