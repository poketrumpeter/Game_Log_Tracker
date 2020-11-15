package com.games.gamelog.games;

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFavoriteGame(String favoriteGame) {
        this.favoriteGame = favoriteGame;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void addGame(String gameName, String gameGenre) {
        this.games.add(new defaultGame(gameName, gameGenre));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
