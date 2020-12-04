package com.games.gamelog.games;

import com.games.gamelog.games.Gaming.Game;
import com.games.gamelog.games.Gaming.defaultGame;
import com.games.gamelog.games.Sessions.GameSession;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class User {

    @Id
    private String id;

    private String firstName;
    private String favoriteGame;
    private String lastName;
    private ArrayList<Game> games;

    public User(){}

    public User(String userName, String favoriteGame, String lastName) {
        this.firstName = userName;
        this.favoriteGame = favoriteGame;
        this.lastName = lastName;
        this.games = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFavoriteGame() {
        return favoriteGame;
    }

    public ArrayList<Game> getGames() {
        return games;
    }
    
    public String getId() {
        return id;
    }

    //Could be factory pattern

    public void addGame(String gameName, String gameGenre) {

        this.games.add(new defaultGame(gameName, gameGenre));
    }

    public Game findGame(String name){

        for(Game game: this.games){

            if (game.getName().equals(name)){
                return game;
            }

        }

        return null;
    }

    public void addSession(Game game, GameSession newSession){

        //findGame
        findGame(game.getName()).addSession(newSession);

    }

}
