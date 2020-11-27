package com.games.gamelog.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GamesApplication{


    public static void main(String[] args) {
        SpringApplication.run(GamesApplication.class, args);

        User user1 = new User("Gregorio", "Hades", "Figueroa");

        user1.addGame("Hades", "RPG");

        user1.addSession(user1.findGame("Hades"), new RPGSession("Hades"));

        System.out.println(user1.findGame("Hades").getMostRecentSessionDate());

    }
}
