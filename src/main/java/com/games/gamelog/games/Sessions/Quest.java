package com.games.gamelog.games.Sessions;

public class Quest {

    String questName;
    String questDescription;

    public Quest() {
    }

    public Quest(String questName, String questDescription) {
        this.questName = questName;
        this.questDescription = questDescription;
    }

    public String getQuestName() {
        return questName;
    }

    public String getQuestDescription() {
        return questDescription;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
    }

    public void setQuestDescription(String questDescription) {
        this.questDescription = questDescription;
    }
}
