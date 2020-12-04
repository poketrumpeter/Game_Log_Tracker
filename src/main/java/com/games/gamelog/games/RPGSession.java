package com.games.gamelog.games;


import com.games.gamelog.games.displays.RPGDisplay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RPGSession extends DefaultSession {

    //Quests
    ArrayList<Quest> quests;

    public RPGSession() {
        super("", "", new RPGDisplay(new ArrayList<>()));
    }

    public RPGSession(String gameName) {
        super(gameName, "RPG", new RPGDisplay(new ArrayList<>()));
    }

    public RPGSession(String gameName, String genre) {
        super(gameName, genre, new RPGDisplay(new ArrayList<>()));
    }

    public RPGSession(String gameName, Date date, String goals) {
        super(gameName, "RPG", new RPGDisplay(new ArrayList<>()));
        setCurrentDate(date);
        setGoals(goals);
    }

    public ArrayList<Quest> getQuests() {
        return quests;
    }

    public void setQuests(ArrayList<Quest> quests) {
        this.quests = quests;
    }

    public void addQuest(String questName, String description) {
        Quest newQuest = new Quest(questName, description);

        quests.add(newQuest);

    }

}
