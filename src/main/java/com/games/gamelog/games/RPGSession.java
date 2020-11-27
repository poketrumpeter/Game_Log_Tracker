package com.games.gamelog.games;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RPGSession extends DefaultSession{

    Date currentDate;
    String sessionTime;
    String goals;
    String gameName;
    String genre;

    //Goals

    //Quests
    ArrayList<Quest> quests;

    //Personal Thoughts
    String reflection;

    public RPGSession(String gameName) {
        this.sessionTime = "0";
        this.currentDate = new Date();
        this.gameName = gameName;
        this.quests = new ArrayList<>();
        this.reflection = "";
        this.genre = "RPG";
    }

    @Override
    public Date getCurrentDate() {
        return currentDate;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    @Override
    public String getGameName() {
        return gameName;
    }

    public ArrayList<Quest> getQuests() {
        return quests;
    }

    public void setQuests(ArrayList<Quest> quests) {
        this.quests = quests;
    }

    @Override
    public String getReflection() {
        return reflection;
    }

    public void setReflection(String reflection) {
        this.reflection = reflection;
    }

    @Override
    public void displayDate() {
        String dateDisplay = "" + this.currentDate;
        System.out.println(dateDisplay);
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
