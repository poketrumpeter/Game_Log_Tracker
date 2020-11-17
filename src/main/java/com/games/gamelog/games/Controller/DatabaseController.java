package com.games.gamelog.games.Controller;

import com.games.gamelog.games.User;
import com.games.gamelog.games.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseController implements CommandLineRunner {

    UserRepository repo;

    @Override
    public void run(String... args) throws Exception {

        repo.deleteAll();

        repo.save(new User("Gregorio", "Assassin's Creed Valhalla", "Figueroa"));
        repo.save(new User("Darrien", "League of Legends", "Lee"));
        repo.save(new User("Jackson", "Call of Duty", "Meyer"));

    }
}
