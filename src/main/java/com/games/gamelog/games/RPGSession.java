package com.games.gamelog.games;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RPGSession extends DefaultSession{

    //Quests
    ArrayList<Quest> quests;

    public RPGSession(){
        super("", "");
    }

    public RPGSession(String gameName) {
        super(gameName, "RPG");
    }

    public RPGSession(String gameName, String genre) {
        super(gameName, genre);
    }

    public RPGSession(String gameName, Date date, String goals){
        super(gameName, "RPG");
        setCurrentDate(date);
        setGoals(goals);
    }

    public ArrayList<Quest> getQuests() {
        return quests;
    }

    public void setQuests(ArrayList<Quest> quests) {
        this.quests = quests;
    }

    public void addQuest(String questName, String description){
        Quest newQuest = new Quest(questName, description);

        quests.add(newQuest);

    }

    @Override
    public String displayInfo() {
        String output = "Completed Quests: ";
        for (Quest quest : this.quests){

            if (quests.indexOf(quest) == quests.size()-1){
                output += quest.getQuestName();
                break;
            }

            output += quest.getQuestName() + " | ";
        }

        return output;
    }
}
