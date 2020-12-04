package com.games.gamelog.games.Sessions;

import com.games.gamelog.games.displays.MultiplayerDisplay;
import java.util.ArrayList;
import java.util.Date;

public class MultiplayerSession extends DefaultSession{

    //List of games and their stats
    ArrayList<MultiplayerMatch> matches;
    String improvements;

    public MultiplayerSession() {
        super("", "Multiplayer", new MultiplayerDisplay(new ArrayList<>(), ""));
    }

    public MultiplayerSession(String gameName) {
        super(gameName, "Multiplayer", new MultiplayerDisplay(new ArrayList<>(), ""));
    }

    public MultiplayerSession(String gameName, Date date, String goals) {
        super(gameName, "Multiplayer", new MultiplayerDisplay(new ArrayList<>(), ""));
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

}
