package com.games.gamelog.games.displays;

import com.games.gamelog.games.Level;

import java.util.ArrayList;

public class PlatformerDisplay implements GameDisplays{

    ArrayList<Level> levels;

    public PlatformerDisplay(ArrayList<Level> levels) {
        this.levels = levels;
    }

    @Override
    public String displayInfo() {
        String output = "Levels Completed: ";

        for(Level level : levels){
            if(levels.indexOf(level) == levels.size()-1){
                output += "Level #: " + level.getLevelNumber() +" Completion Time: " + level.getCompletionTime() +
                        " Score: " + level.getScore();
                break;
            }
            output += "Level #: " + level.getLevelNumber() +" Completion Time: " + level.getCompletionTime() +
                    " Score: " + level.getScore() + " | ";
        }

        return output;
    }
}
