package com.games.gamelog.games.displays;

import com.games.gamelog.games.Sessions.Quest;

import java.util.ArrayList;

public class RPGDisplay implements GameDisplays{

    ArrayList<Quest> quests;

    public RPGDisplay(ArrayList<Quest> quests) {
        this.quests = quests;
    }

    @Override
    public String displayInfo() {
        String output = "Completed Quests: ";

        for (Quest quest : this.quests) {

            if (quests.indexOf(quest) == quests.size() - 1) {
                output += quest.getQuestName();
                break;
            }

            output += quest.getQuestName() + " | ";
        }

        return output;
    }
}
