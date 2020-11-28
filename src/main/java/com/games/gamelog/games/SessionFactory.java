package com.games.gamelog.games;

import javax.websocket.Session;
import java.util.Date;

public class SessionFactory {

    public SessionFactory() {
    }

    public GameSession createSession(String genre, String gameName){

        //System.out.println(genre);
        switch (genre){
            case "RPG":
                //System.out.println("new RPG");
                return new RPGSession(gameName);

            case "Multiplayer":
                //System.out.println("new multiplayer");
                return new MultiplayerSession(gameName);

            case "Platformer":
                //System.out.println("new Platformer");
                return new PlatformerSession(gameName);

            default:
                return null;
        }
    }

    public GameSession createSession(String genre, String gameName, Date date, String goals){
        switch (genre){
            case "RPG":
                //System.out.println("new RPG");
                return new RPGSession(gameName, date, goals);

            case "Multiplayer":
                //System.out.println("new multiplayer");
//                MultiplayerSession newSession = new MultiplayerSession(gameName, date, goals);
//                newSession.addMatch(new MultiplayerMatch(true));
                return new MultiplayerSession(gameName, date, goals);

            case "Platformer":
                //System.out.println("new Platformer");
                return new PlatformerSession(gameName, date, goals);

            default:
                return null;
        }
    }
}
