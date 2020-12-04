package com.games.gamelog.games.displays;

import com.games.gamelog.games.Sessions.MultiplayerMatch;

import java.util.ArrayList;

public class MultiplayerDisplay implements GameDisplays{

    ArrayList<MultiplayerMatch> matches;
    String improvements;

    public MultiplayerDisplay(ArrayList<MultiplayerMatch> matches, String improvements) {
        this.matches = matches;
        this.improvements = improvements;
    }

    @Override
    public String displayInfo() {

        String output = "Areas to Improve: " + improvements + "---- Match stats: ";
        String outcome = "";

        for(MultiplayerMatch match : matches){
            if(match.isVictory())
                outcome = "Victory";
            else
                outcome = "Defeat";

            int KDA = (Integer.parseInt(match.getKills()) + Integer.parseInt(match.getAssists())) / Integer.parseInt(match.getDeaths());

            if(matches.indexOf(match) == matches.size()-1){
                output += "KDA: " + KDA + " - " + outcome;
                break;
            }
            output += "KDA: " + KDA + " - " + outcome + " | ";


        }
        return output;
    }
}
