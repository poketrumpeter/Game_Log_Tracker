package com.games.gamelog.games;

import java.util.ArrayList;
import java.util.Date;

public class PlatformerSession extends DefaultSession{

    //List of levels and time associated with them
    ArrayList<Level> levels;

    public PlatformerSession() {
        super("", "Platformer");
    }

    public PlatformerSession(String gameName) {
        super(gameName, "Platformer");
    }

    public PlatformerSession(String gameName, Date date, String goals) {
        super(gameName, "Platformer");
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public void setLevels(ArrayList<Level> levels) {
        this.levels = levels;
    }

    @Override
    public String displayInfo() {

        String output = "Levels Completed: ";

        for(Level level : levels){
            if(levels.indexOf(level) == levels.size()-1){
                output += "Level #: " + level.levelNumber +" Completion Time: " + level.completionTime +
                          " Score: " + level.score;
                break;
            }
            output += "Level #: " + level.levelNumber +" Completion Time: " + level.completionTime +
                    " Score: " + level.score + " | ";
        }

        return output;
    }
}
