package com.games.gamelog.games;

import java.util.ArrayList;
import java.util.Date;

public class MultiplayerSession extends DefaultSession{

    //List of games and their stats
    ArrayList<MultiplayerMatch> matches;
    String improvements;

    public MultiplayerSession() {
        super("", "Multiplayer");
    }

    public MultiplayerSession(String gameName) {
        super(gameName, "Multiplayer");
    }

    public MultiplayerSession(String gameName, Date date, String goals) {
        super(gameName, "Multiplayer");
        setCurrentDate(date);
        setGoals(goals);
    }

    public ArrayList<MultiplayerMatch> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<MultiplayerMatch> matches) {
        this.matches = matches;
    }

    public void addMatch(MultiplayerMatch newMatch){
        this.matches.add(newMatch);
    }

    public String getImprovements() {
        return improvements;
    }

    public void setImprovements(String improvements) {
        this.improvements = improvements;
    }

    @Override
    public String displayInfo() {

        String output = "Areas to Improve: " + improvements + " Match stats: ";
        String outcome = "";

        for(MultiplayerMatch match : matches){
            if(match.victory)
                outcome = "Victory";
            else
                outcome = "Defeat";

            int KDA = (Integer.parseInt(match.kills) + Integer.parseInt(match.assists)) / Integer.parseInt(match.deaths);

            if(matches.indexOf(match) == matches.size()-1){
                output += "KDA: " + KDA + " - " + outcome;
                break;
            }
            output += "KDA " + KDA + " - " + outcome + "|";


        }
        return output;
    }

}
