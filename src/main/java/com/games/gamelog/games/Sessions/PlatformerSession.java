package com.games.gamelog.games.Sessions;

import com.games.gamelog.games.displays.PlatformerDisplay;

import java.util.ArrayList;
import java.util.Date;

public class PlatformerSession extends DefaultSession{

    //List of levels and time associated with them
    ArrayList<Level> levels;

    public PlatformerSession() {
        super("", "Platformer", new PlatformerDisplay(new ArrayList<>()));
    }

    public PlatformerSession(String gameName) {
        super(gameName, "Platformer", new PlatformerDisplay(new ArrayList<>()));
    }

    public PlatformerSession(String gameName, Date date, String goals) {
        super(gameName, "Platformer", new PlatformerDisplay(new ArrayList<>()));
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public void setLevels(ArrayList<Level> levels) {
        this.levels = levels;
    }


}
